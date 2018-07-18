package models;

import db.DBPark;
import db.DBVisitor;
import models.humans.Visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RandomGenerator {

    private Visitor visitor;
    private Park park;

    public RandomGenerator() {
    }

    public RandomGenerator(Visitor visitor, Park park) {
        this.visitor = visitor;
        this.park = park;
    }



    public Visitor generateVisitor(){
        Visitor generatedVisitor;
        generatedVisitor = new Visitor(visitor.randName(), visitor.randWallet(), park);

        Collections.shuffle(park.getPaddocks());
        Paddock paddock = park.getPaddocks().get(0);

        DBPark.addVisitor(park, generatedVisitor);
        generatedVisitor.setPaddock(paddock);
        DBPark.moveVisitorToPaddock(park, generatedVisitor, paddock);

        return generatedVisitor;
    }

    public ArrayList<Visitor> generateMultipleVisitors(int number){
        ArrayList<Visitor> generatedVisitors = new ArrayList<Visitor>();
            for(int i=0; i<number; i++){
                Visitor visitor = generateVisitor();
                generatedVisitors.add(visitor);
            }
        return generatedVisitors;
    }

//    public ArrayList<Visitor> generateMultipleVisitorsAndAddToPaddocks(int number){
//        ArrayList<Visitor> generatedVisitors = new ArrayList<Visitor>();
//        for(int i=0; i<number; i++){
//            Visitor visitor = generateVisitor();
//            generatedVisitors.add(visitor);
//        }
//        return generatedVisitors;
//    }

}


