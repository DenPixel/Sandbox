package hiber.graf;

import hiber.graf.entity.City;
import hiber.graf.entity.Connection;
import hiber.graf.entity.Problem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnerDemo {

    private static final Logger logger = LoggerFactory.getLogger(RunnerDemo.class);

    public static void main(String[] args) {
        City city1 = new City();
        city1.setName("city1");

        City city2 = new City();
        city2.setName("city2");

        Connection connection = new Connection();
        connection.addConnection(city1,city2);
        connection.setCost(6L);

        Problem problem = new Problem();
        problem.addProblem(city1,city2);

        Configuration cfg = new Configuration().configure();

        try(SessionFactory sessionFactory = cfg.buildSessionFactory();
            Session session = sessionFactory.openSession()
        ) {
            try {
                session.beginTransaction();

                session.saveOrUpdate(city1);
                session.saveOrUpdate(city2);
                session.saveOrUpdate(connection);
                session.saveOrUpdate(problem);

                session.getTransaction().commit();
            } catch (Exception e){
                session.getTransaction().rollback();
                logger.error("Error during transaction", e);
            }
        }
    }
}
