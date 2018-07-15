package db;

import models.dinosaurs.Dinosaur;
import models.humans.Visitor;

public class DBVisitor {

    public static void tauntDinosaursInPaddock(Visitor visitor){
        visitor.tauntDinosaursInPaddock();
        for (Dinosaur dinosaur : visitor.getPaddock().getDinosaursInPaddock()){
            DBHelper.saveOrUpdate(dinosaur);
        }


    }

}
