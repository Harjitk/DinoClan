package db;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBPaddock {

    private static Session session;

    public static List<Dinosaur> getDinosaursForPaddock(Paddock paddock) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<Dinosaur> results = null;
        try {
            Criteria cr = session.createCriteria(Dinosaur.class);
            cr.add(Restrictions.eq("paddock", paddock));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
