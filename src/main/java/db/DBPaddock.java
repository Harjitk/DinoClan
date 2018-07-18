package db;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.humans.Visitor;
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

    public static List<Food> getFoodInPaddock(Paddock paddock) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<Food> results = null;
        try {
            Criteria cr = session.createCriteria(Food.class);
            cr.add(Restrictions.eq("paddock", paddock));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Object getFirstVisitorsInPaddock(Paddock paddock) {
        session = HibernateUtil.getSessionFactory().openSession();
        Object results = null;
        try {
            Criteria cr = session.createCriteria(Visitor.class);
            cr.add(Restrictions.eq("paddock", paddock));
            cr.setMaxResults(1);
            results = cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


    public static Dinosaur getFirstDinosaurInPaddock(Paddock paddock) {
        session = HibernateUtil.getSessionFactory().openSession();
        Dinosaur result = null;
        try {
            Criteria cr = session.createCriteria(Dinosaur.class);
            cr.add(Restrictions.eq("paddock", paddock));
            cr.setMaxResults(1);
            result = (Dinosaur)cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }




}
