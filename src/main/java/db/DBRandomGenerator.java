package db;

import models.Park;
import models.RandomGenerator;
import models.humans.Visitor;

public class DBRandomGenerator {

    public static void generateMultipleVisitors(Park park, RandomGenerator randomGenerator, int numToGenerate){

        park.setVisitors(DBPark.getVisitorsForPark(park));

        randomGenerator.generateMultipleVisitors(numToGenerate);

        for (Visitor generatedVisitor : DBPark.getVisitorsForPark(park)){
            DBHelper.saveOrUpdate(generatedVisitor);
        }

    }

}
