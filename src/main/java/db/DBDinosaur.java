package db;

import models.DinoFactory;
import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.humans.Human;
import models.humans.Visitor;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DBDinosaur {

    private static Session session;

    public static void eat(Dinosaur dinosaur) {
        if (dinosaur.getPaddock().getFoodStore().size() > 0) {
            dinosaur.eat();
            DBHelper.saveOrUpdate(dinosaur);
        }
    }

    public static void eatVisitor(Dinosaur dinosaur, Visitor visitor) {
        dinosaur.eatVisitor(visitor);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(visitor);
    }

    public static void rampage(Dinosaur dinosaur) {
//        May need to delete the dinosaur from the DB as this
        Park park = dinosaur.getPark();
        Paddock paddock = dinosaur.getPaddock();

        List<Dinosaur> oldDinosaursInPaddock = new ArrayList<>(paddock.getDinosaursInPaddock());
        List<Visitor> oldVisitorsInPaddock = new ArrayList<>(paddock.getVisitorsInPaddock());

        paddock.dinosaursInPaddockRampage();

        for (Human human : oldVisitorsInPaddock) {
            DBHelper.saveOrUpdate(human);
        }

        for (Dinosaur foundDino : oldDinosaursInPaddock) {
            DBHelper.saveOrUpdate(foundDino);
        }

        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(dinosaur);
    }

    public static List<Human> getHumansSeenByDinosaur(Dinosaur dinosaur) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<Human> results = null;
        try {
            Criteria cr = session.createCriteria(Human.class);
            cr.createAlias("dinosSeen", "dinosaur");
            cr.add(Restrictions.eq("dinosaur.id", dinosaur.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


    public static Paddock getTheDinosaursPaddock(Dinosaur dinosaur) {
       return dinosaur.getPaddock();
    }
}




