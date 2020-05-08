package finance.export;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SimpleExportTransactions {

    private final static Logger log = LoggerFactory.getLogger(SimpleExportTransactions.class);

    private static Properties loadProperties() {
        log.info("load properties");

        Properties props = new Properties();

        try(InputStream input = ClassLoader.getSystemResourceAsStream("JdbcFin.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return props;
    }

    public String getStringInCSVFormat(String phoneNumber, String password, String dateFrom, String dateTo) {
        List<CSVData> csvDataList = new ArrayList<>();
        int balanceIncome = 0;
        int balanceExpense = 0;
        int totalBalance = 0;

        Properties properties = loadProperties();
        String url = properties.getProperty("url");

        log.info("start connection to db");
        try(Connection connection = DriverManager.getConnection(url, properties)){
            log.info("finish connection to db");
            log.info("create sql query");
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT acc.id \"id_account\", " +
                            "tran.id \"id_transaction\", " +
                            "tran.amount \"transaction_balance\", " +
                            "tran.date_trns \"date_transaction\", " +
                            "bc.income " +
                            "FROM transactions tran " +
                            "INNER JOIN accounts acc ON tran.account_id = acc.id " +
                            "INNER JOIN users us ON acc.user_id = us.id " +
                            "INNER JOIN budget_cat_transaction bct on tran.id = bct.transaction_id " +
                            "INNER JOIN budget_categories bc on bct.budget_cat_id = bc.id " +
                            "WHERE us.phone_number = ? and us.password = ?"
            )) {
                preparedStatement.setString(1, phoneNumber);
                preparedStatement.setString(2, password);

                LocalDateTime timeFrom = LocalDateTime.parse(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                LocalDateTime timeTo = LocalDateTime.parse(dateTo, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

                log.info("execute query");
                ResultSet resultSet = preparedStatement.executeQuery();

                log.info("start check of the result");
                while (resultSet.next()) {
                    Timestamp dateTransaction = resultSet.getTimestamp("date_transaction");

                    if (!(timeFrom.isBefore(dateTransaction.toLocalDateTime()) &&
                            timeTo.isAfter(dateTransaction.toLocalDateTime()))
                    ) {
                        continue;
                    }

                    int idAccount = resultSet.getInt("id_account");
                    int idTransaction = resultSet.getInt("id_transaction");
                    int transactionBalance = resultSet.getInt("transaction_balance");
                    String dateString = LocalDateTime.ofInstant(
                            dateTransaction.toInstant(),
                            ZoneId.systemDefault()
                    ).toString();
                    boolean income = resultSet.getBoolean("income");

                    if(income){
                        balanceIncome += transactionBalance;
                    } else {
                        balanceExpense -= transactionBalance;
                    }

                    csvDataList.add(new CSVData(
                            idAccount,
                            idTransaction,
                            transactionBalance,
                            dateString,
                            income
                    ));
                }
                log.info("finish check of the result");
            }

            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT sum(acc.amount_of_money) \"summ\"  " +
                            "FROM accounts acc " +
                            "INNER JOIN users us ON acc.user_id = us.id " +
                            "WHERE us.phone_number = ? AND us.password = ?"
            )) {
                preparedStatement.setString(1, phoneNumber);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    totalBalance += resultSet.getInt("summ");
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return convertCSVDataToString(
                csvDataList,
                balanceIncome,
                balanceExpense,
                totalBalance
        );
    }


    private String convertCSVDataToString(List<CSVData> list,
                                          int balanceIncome,
                                          int balanceExpense,
                                          int totalBalance){
        if (list.isEmpty()) return "";

        log.info("start converting data to string for output");
        String csvDelimiter = ",";
        String[] headers = list.get(0).getHeaders();

        StringBuilder sb = new StringBuilder();

        for (String header : headers) {
            sb.append(header).append(csvDelimiter);
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(System.lineSeparator());

        for (CSVData csvData : list) {
            sb.append(csvData.getIdAccount()).append(csvDelimiter);
            sb.append(csvData.getIdTransaction()).append(csvDelimiter);
            sb.append(csvData.getTransactionBalance()).append(csvDelimiter);
            sb.append(csvData.getDateString()).append(csvDelimiter);
            sb.append(csvData.isIncome()).append(System.lineSeparator());
        }

        sb.append("Income balance")
                .append(csvDelimiter)
                .append(balanceIncome)
                .append(System.lineSeparator());
        sb.append("Expense balance")
                .append(csvDelimiter)
                .append(balanceExpense)
                .append(System.lineSeparator());
        sb.append("Total balance")
                .append(csvDelimiter)
                .append(totalBalance)
                .append(System.lineSeparator());

        log.info("finish converting data to string for output");

        return sb.toString();
    }

    public class CSVData {
        private String[] headers = {
                "id_account",
                "id_transaction",
                "transaction_balance",
                "date",
                "income"
        };
        int idAccount;
        int idTransaction;
        int transactionBalance;
        String dateString;
        boolean income;

        public CSVData(int idAccount, int idTransaction, int transactionBalance, String dateString, boolean income) {
            this.idAccount = idAccount;
            this.idTransaction = idTransaction;
            this.transactionBalance = transactionBalance;
            this.dateString = dateString;
            this.income = income;
        }

        public String[] getHeaders() {
            return headers;
        }

        public int getIdAccount() {
            return idAccount;
        }

        public int getIdTransaction() {
            return idTransaction;
        }

        public int getTransactionBalance() {
            return transactionBalance;
        }

        public String getDateString() {
            return dateString;
        }

        public boolean isIncome() {
            return income;
        }
    }
}
