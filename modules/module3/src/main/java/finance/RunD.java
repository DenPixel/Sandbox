package finance;

import finance.addtransaction.SimpleAddTransaction;
import finance.export.OutputCSV;
import finance.export.SimpleExportTransactions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class RunD {
    private final static Logger log = LoggerFactory.getLogger(RunD.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        log.info("start program");

        log.info("user input phone number");
        System.out.print("phone number: ");
        String phoneNumber = scanner.next();

        log.info("user input password");
        System.out.print("password: ");
        String password = scanner.next();

        log.info("user chooses add transaction or export transactions");
        System.out.print(
                "switch \n" +
                        "1. add transaction \n" +
                        "2. export transactions \n"
        );

        switch (scanner.next()){
            case "1":
                log.info("user chose add transaction");
                SimpleAddTransaction work = new SimpleAddTransaction();

                work.addTransaction(phoneNumber, password);
                break;
            case "2":
                log.info("user chose export transactions");
                SimpleExportTransactions set = new SimpleExportTransactions();

                System.out.println("date format YYYY-MM-DDTHH:mm:ss");
                log.info("user input date from");
                System.out.print("input date from: ");
                String dateFrom = scanner.next();
                log.info("user input date from");
                System.out.print("input date to: ");
                String dateTo = scanner.next();

                String stringInCSVFormat = set.getStringInCSVFormat(
                        phoneNumber,
                        password,
                        dateFrom,
                        dateTo
                );

                OutputCSV outputCSV = new OutputCSV();

                log.info("user input path directory");
                System.out.print("input path directory: ");
                String pathDir = scanner.next();
                log.info("user input name file");
                System.out.print("input name file: ");
                String name = scanner.next();

                outputCSV.outputToCSV(pathDir, name, stringInCSVFormat);
                break;
            default:
                break;
        }

        log.info("start program");
    }
}
