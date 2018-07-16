package db;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.humans.Human;
import models.humans.Visitor;

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
        Park park = dinosaur.getPark();
        Paddock paddock = dinosaur.getPaddock();

        dinosaur.rampage();

        for (Human human : paddock.getVisitorsInPaddock()){
            DBHelper.saveOrUpdate(human);
        }

        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(paddock);
    }





}
