package hiber.graf.txtintodb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Objects;

public class DBInserter {
    private SessionFactory sessionFactory;

    public DBInserter(SessionFactory sessionFactory) {
        this.sessionFactory = Objects.requireNonNull(sessionFactory);
    }

    public void insert(ConverterTXTData convert) {
        if (convert == null) return;

        try (Session session = sessionFactory.openSession()) {

            try {
                session.beginTransaction();

                convert.getCities().forEach(session::saveOrUpdate);
                convert.getConnections().forEach(session::saveOrUpdate);
                convert.getProblems().forEach(session::saveOrUpdate);

                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
