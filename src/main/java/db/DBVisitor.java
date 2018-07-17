package db;

import models.Park;
import models.dinosaurs.Dinosaur;
import models.humans.Visitor;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBVisitor {

    private static Session session;

    public static void tauntDinosaursInPaddock(Visitor visitor) {
        visitor.tauntDinosaursInPaddock();
        for (Dinosaur dinosaur : visitor.getPaddock().getDinosaursInPaddock()) {
            DBHelper.saveOrUpdate(dinosaur);
        }

    }
        public static List<Dinosaur> getDinosaursSeenByVisitor(Visitor visitor) {

            session = HibernateUtil.getSessionFactory().openSession();
            List<Dinosaur> results = null;
            try {
                Criteria cr = session.createCriteria(Dinosaur.class);
                cr.createAlias("humanVisitors", "visitor");
                cr.add(Restrictions.eq("visitor.id", visitor.getId()));
                results = cr.list();
            } catch (HibernateException e) {
                e.printStackTrace();
            } finally {
                session.close();
            }
            return results;
        }


    }
