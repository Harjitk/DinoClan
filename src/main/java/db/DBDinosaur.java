package db;

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
        human.setDinosaur(dinosaur);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(human);
    }





}
