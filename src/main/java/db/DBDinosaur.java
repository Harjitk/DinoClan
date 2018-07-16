package db;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.humans.Human;
import models.humans.Visitor;

import java.util.ArrayList;
import java.util.List;

public class DBDinosaur {

    public static void eat(Dinosaur dinosaur) {
        Food food = dinosaur.getPaddock().getFoodStore().get(0);
        dinosaur.eat();
        food.setDinosaur(dinosaur);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(food);
    }

    public static void eatVisitor(Dinosaur dinosaur, Visitor visitor){
        dinosaur.eatVisitor(visitor);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(visitor);
    }

    public static void rampage(Dinosaur dinosaur){
//        May need to delete the dinosaur from the DB as this
        Park park = dinosaur.getPark();
        Paddock paddock = dinosaur.getPaddock();

        List<Dinosaur> oldDinosaursInPaddock = new ArrayList<>(paddock.getDinosaursInPaddock());
        List<Visitor> oldVisitorsInPaddock = new ArrayList<>(paddock.getVisitorsInPaddock());

        paddock.dinosaursInPaddockRampage();

        for (Human human : oldVisitorsInPaddock){
            DBHelper.saveOrUpdate(human);
        }

        for (Dinosaur foundDino : oldDinosaursInPaddock){
            DBHelper.saveOrUpdate(foundDino);
        }

        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(dinosaur);
    }





}
