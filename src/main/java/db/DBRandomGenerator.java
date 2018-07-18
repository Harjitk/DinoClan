package db;

import models.Park;
import models.RandomGenerator;
import models.dinosaurs.Dinosaur;
import models.humans.Visitor;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBRandomGenerator {

    private static Session session;

    public static void generateMultipleVisitors(Park park, RandomGenerator randomGenerator, int numToGenerate){

        park.setVisitors(DBPark.getVisitorsForPark(park));

        randomGenerator.generateMultipleVisitors(numToGenerate);

        for (Visitor generatedVisitor : DBPark.getVisitorsForPark(park)){
            DBHelper.saveOrUpdate(generatedVisitor);
        }

    }

//    public static List<String> getFirstNamesFromHuman(Visitor visitor) {
//
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Dinosaur> results = null;
//        try {
//            Criteria cr = session.createCriteria(Dinosaur.class);
//            cr.add(Restrictions.eq("visitor", visitor));
//            results = cr.list();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return results;
//    }


}
