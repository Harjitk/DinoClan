package db;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.humans.Human;

public class DBDinosaur {

    public static void eat(Dinosaur dinosaur) {
        Food food = dinosaur.getPaddock().getFoodStore().get(0);
        dinosaur.eat();
        food.setDinosaur(dinosaur);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(food);
    }

    public static void eatHuman(Dinosaur dinosaur, Human human){
        dinosaur.eatHuman(human);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(human);
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
