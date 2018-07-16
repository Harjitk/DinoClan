package db;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.humans.ParkStaff;
import models.humans.Visitor;

public class DBPark {

    public static void moveVisitorToPaddock(Visitor visitor, Paddock paddock) {
        Park park = paddock.getPark();
        park.moveVisitorToPaddock(visitor, paddock);
        DBHelper.saveOrUpdate(visitor);
        DBHelper.saveOrUpdate(paddock);
        for (Dinosaur dinosaur : paddock.getDinosaursInPaddock()) {
            DBHelper.saveOrUpdate(dinosaur);
        }
    }

    public static void buyDinosaur(Dinosaur dinosaur, Paddock paddock) {
        Park park = paddock.getPark();
        park.buyDinosaur(dinosaur, paddock);
        dinosaur.setPark(park);
        park.getDinosaursInPark().add(dinosaur);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(paddock);
    }

    public static void addPaddock(Park park, Paddock paddock) {
        park.addPaddock(paddock);
        DBHelper.saveOrUpdate(paddock);
        DBHelper.saveOrUpdate(park);
    }

    public static void removePaddock(Paddock paddock) {
        Park park = paddock.getPark();
        park.removePaddock(paddock);
        DBHelper.delete(paddock);
        DBHelper.saveOrUpdate(park);
    }

    public static void removeDinosaur(Dinosaur dinosaur) {
        Park park = dinosaur.getPark();
        park.removeDinosaur(dinosaur);
        DBHelper.delete(dinosaur);
        DBHelper.saveOrUpdate(park);
    }

    public static void addVisitor(Park park, Visitor visitor) {
        park.addVisitor(visitor);
        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(visitor);
    }

    public static void removeVisitor(Visitor visitor) {
        Park park = visitor.getPark();
        park.removeVisitor(visitor);
        DBHelper.delete(visitor);
        DBHelper.saveOrUpdate(park);
    }

    public static void addParkStaff(Park park, ParkStaff parkStaff) {
        park.addParkStaff(parkStaff);
        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(parkStaff);
    }

    public static void generateFood(Park park, int qtyToGenerate) {
        park.generateFoodStock(qtyToGenerate);
        for (Food food : park.getFoodStock()) {
            DBHelper.saveOrUpdate(food);
        }
    }


}


