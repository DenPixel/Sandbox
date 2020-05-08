package finance.addtransaction;

import finance.entity.Account;
import finance.entity.BudgetCategory;
import finance.entity.Transaction;
import finance.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class SimpleAddTransaction {

    private final static Logger log = LoggerFactory.getLogger(SimpleAddTransaction.class);

    private Scanner scanner = new Scanner(System.in);

    public void addTransaction(String phoneNumber, String password) {

        Configuration cfg = new Configuration().configure();

        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()
        ) {

            User user = getUser(phoneNumber, password, session);

            if (user == null) {
                log.info("user not found");
                return;
            }
            log.info("user found");

            Account account = getAccount(session, user);

            if (account == null) {
                log.info("account not found");
                return;
            }
            log.info("user found");

            List<BudgetCategory> categories = getCategories(session);

            if (categories.isEmpty()) {
                log.info("categories not found or user exit");
                return;
            }

            int amount = getAmount();

            log.info("amount of money in transaction = " + amount);

            log.info("create new transaction");
            Transaction transaction = new Transaction(
                    account,
                    LocalDateTime.now().toInstant(ZoneOffset.UTC),
                    amount,
                    new HashSet<>(categories)
            );

            if (categories.get(0).getIncome()) {
                account.addAmountOfMoney(amount);
            }else {
                account.addAmountOfMoney(-amount);
            }

            try {
                log.info("start update db");
                session.beginTransaction();

                session.save(transaction);
                session.update(account);

                session.getTransaction().commit();
                log.info("finish update db");
            } catch (Exception e) {
                log.info("fail update db");
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }

    private User getUser(String phoneNumber, String password, Session session) {

        log.info("search user by phone number and password");
        Query<User> userQuery = session.createQuery(
                "FROM User us " +
                        "WHERE us.phoneNumber = :phoneNumber " +
                        "AND us.password = :password",
                User.class
        );

        userQuery.setParameter("phoneNumber", phoneNumber);
        userQuery.setParameter("password", password);

        return userQuery.getResultList().get(0);
    }

    private Account getAccount(Session session, User user){
        System.out.print("id account: ");
        int idAccount = scanner.nextInt();

        log.info("user search account by  id_account");

        Query<Account> accountQuery = session.createQuery(
                "FROM Account ac " +
                        "WHERE ac.user.id = :id " +
                        "AND ac.id = :idAccount",
                Account.class
        );

        accountQuery.setParameter("id", user.getId());
        accountQuery.setParameter("idAccount", idAccount);

        return accountQuery.getResultList().get(0);
    }

    private int getAmount(){
        int amount;
        log.info("user input amount of money in transaction");
        do {
            System.out.print("amount of money in transaction: ");
            amount = scanner.nextInt();
        } while (amount <= 0);

        return amount;
    }

    private List<BudgetCategory> getCategories(Session session){
        List<BudgetCategory> categories = new ArrayList<>();

        boolean income = false;

        log.info("search budget categories by id");

        do {
            System.out.print("id budget categories(separated by space)(0000 for exit): ");
            String line = scanner.next();

            if (line.equals("0000")) {
                return categories;
            }

            String[] idCategories = line.split(" ");

            for (String idCategory : idCategories) {
                Query<BudgetCategory> categoryQuery = session.createQuery(
                        "FROM BudgetCategory bc " +
                                "WHERE bc.id = :id",
                        BudgetCategory.class
                );

                categoryQuery.setParameter("id", Integer.valueOf(idCategory));

                List<BudgetCategory> resultList = categoryQuery.getResultList();

                if (resultList.isEmpty()) {
                    continue;
                }

                BudgetCategory category = resultList.get(0);

                if (!categories.isEmpty() && category.getIncome() == income) {
                    continue;
                } else if (categories.isEmpty()) {
                    income = category.getIncome();
                }

                categories.add(category);
            }

        } while (categories.isEmpty());

        return categories;
    }
}
