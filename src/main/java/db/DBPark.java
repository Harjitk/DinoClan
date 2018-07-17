package db;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.humans.ParkStaff;
import models.humans.Visitor;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DBPark {

    private static Session session;

    public static void moveVisitorToPaddock(Park park, Visitor visitor, Paddock paddock) {

        List<Dinosaur> dinosaursInPaddock = DBPaddock.getDinosaursForPaddock(paddock);
        park.moveVisitorToPaddock(visitor, paddock);

//        visitor.setDinosSeen(DBVisitor.getDinosaursSeenByVisitor(visitor));
//
//        for (Dinosaur dinosaur : dinosaursInPaddock) {
//            dinosaur.setHumanVisitors(DBDinosaur.getHumansSeenByDinosaur(dinosaur));
//        }

        DBHelper.saveOrUpdate(visitor);
        DBHelper.saveOrUpdate(paddock);
        for (Dinosaur dinosaur : dinosaursInPaddock) {
            DBHelper.saveOrUpdate(dinosaur);
        }
    }

    public static List<Dinosaur> getDinosaursForPark(Park park) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<Dinosaur> results = null;
        try {
            Criteria cr = session.createCriteria(Dinosaur.class);
            cr.add(Restrictions.eq("park", park));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static void buyDinosaur(Park park, Dinosaur dinosaur, Paddock paddock) {
        park.buyDinosaur(dinosaur, paddock);
        dinosaur.setPark(park);

        getDinosaursForPark(park).add(dinosaur);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(paddock);
    }

    public static void addPaddock(Park park, Paddock paddock) {
        park.addPaddock(paddock);
        DBHelper.saveOrUpdate(paddock);
        DBHelper.saveOrUpdate(park);
    }

    public static void removePaddock(Paddock paddock) {
        Park park = paddock.getPark();
        park.removePaddock(paddock);
        DBHelper.delete(paddock);
        DBHelper.saveOrUpdate(park);
    }

    public static void removeDinosaur(Dinosaur dinosaur) {
        Park park = dinosaur.getPark();
        park.removeDinosaur(dinosaur);
        DBHelper.delete(dinosaur);
        DBHelper.saveOrUpdate(park);
    }

    public static void addVisitor(Park park, Visitor visitor) {
        park.setVisitors(getVisitorsForPark(park));
        park.addVisitor(visitor);
        DBHelper.saveOrUpdate(visitor);
        DBHelper.saveOrUpdate(park);
    }

    public static List<Visitor> getVisitorsForPark(Park park) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<Visitor> results = null;
        try {
            Criteria cr = session.createCriteria(Visitor.class);
            cr.add(Restrictions.eq("park", park));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static void removeVisitor(Visitor visitor) {
        Park park = visitor.getPark();
        park.removeVisitor(visitor);
        DBHelper.delete(visitor);
        DBHelper.saveOrUpdate(park);
    }

    public static void addParkStaff(Park park, ParkStaff parkStaff) {
        park.addParkStaff(parkStaff);
        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(parkStaff);
    }

    public static void generateFood(Park park, int qtyToGenerate) {
        park.generateFoodStock(qtyToGenerate);
        for (Food food : park.getFoodStock()) {
            DBHelper.saveOrUpdate(food);
        }
    }


}


