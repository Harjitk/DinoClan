package db;

import models.Park;
import models.RandomGenerator;
import models.humans.Visitor;

public class DBRandomGenerator {

    public static void generateMultipleVisitors(Park park, RandomGenerator randomGenerator, int numToGenerate){

        randomGenerator.generateMultipleVisitors(numToGenerate);

        for (Visitor generatedVisitor : park.getVisitors()){
            DBHelper.saveOrUpdate(generatedVisitor);
        }

    }

}
