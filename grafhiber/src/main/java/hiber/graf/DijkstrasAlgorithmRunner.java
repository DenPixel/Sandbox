package hiber.graf;

import hiber.graf.dijkstra.DijkstrasAlgorithm;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DijkstrasAlgorithmRunner {
    public static void main(String[] args) {
        DijkstrasAlgorithm d = new DijkstrasAlgorithm();
        Configuration cfg = new Configuration().configure();

        try(SessionFactory sessionFactory = cfg.buildSessionFactory()) {
            d.solutionProblems(sessionFactory);
        }

    }
}
