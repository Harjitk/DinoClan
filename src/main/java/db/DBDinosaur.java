package db;

import models.dinosaurs.Dinosaur;
import models.foods.Food;

public class DBDinosaur {

public static void eat(Dinosaur dinosaur){
    Food food = dinosaur.getPaddock().getFoodStore().get(0);
    dinosaur.eat();
    food.setDinosaur(dinosaur);
    DBHelper.saveOrUpdate(dinosaur);
    DBHelper.saveOrUpdate(food);
    }



}
