package db;

import models.Paddock;
import models.Park;
import models.foods.Food;
import models.humans.Visitor;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFood {

    private static Session session;

    public static List<Food> getFoodInPark(Park park) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<Food> results = null;
        try {
            Criteria cr = session.createCriteria(Food.class);
            cr.add(Restrictions.eq("park", park));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Object getFirstBitOfFoodInPaddock(Paddock paddock) {

        session = HibernateUtil.getSessionFactory().openSession();
       Object result = null;
        try {
            Criteria cr = session.createCriteria(Food.class);
            cr.add(Restrictions.eq("paddock", paddock));
            result = cr.list().get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }


}
