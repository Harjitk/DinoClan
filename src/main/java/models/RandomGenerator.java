package models;

import db.DBPark;
import models.humans.Visitor;

import java.util.ArrayList;

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
        DBPark.addVisitor(park, generatedVisitor);
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


}


