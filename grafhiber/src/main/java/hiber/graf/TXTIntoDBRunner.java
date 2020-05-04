package hiber.graf;

import hiber.graf.txtintodb.ConverterTXTData;
import hiber.graf.txtintodb.DBInserter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TXTIntoDBRunner {
    public static void main(String[] args) {
        if (args.length == 0) return;

        ConverterTXTData convert = ConverterTXTData.load(args[0]);

        Configuration cfg = new Configuration().configure();

        try(SessionFactory sessionFactory = cfg.buildSessionFactory()) {
            DBInserter dbInserter = new DBInserter(sessionFactory);

            dbInserter.insert(convert);
        }
    }
}
