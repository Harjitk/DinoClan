package db;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.humans.ParkStaff;

public class DBParkStaff {

    public static void repairPaddock(ParkStaff parkStaff, Paddock paddock){
        parkStaff.repairPaddock(paddock);
        DBHelper.saveOrUpdate(paddock);
    }

    public static void addFoodToStore(ParkStaff parkStaff, Paddock paddock){
        Park park = paddock.getPark();
        Food food = parkStaff.addFoodToStore(paddock);

        DBHelper.saveOrUpdate(paddock);
        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(food);
    }

    public static void transferDinosaur(ParkStaff parkStaff, Dinosaur dinosaur, Paddock paddock){
        parkStaff.transferDinosaur(dinosaur, paddock);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(paddock);
    }

    public static void calmDinosaursInPaddock(ParkStaff parkStaff, Paddock paddock){
        parkStaff.calmDinosaursInPadddock(paddock);
        for (Dinosaur dinosaur : paddock.getDinosaursInPaddock()){
            DBHelper.saveOrUpdate(dinosaur);
        }
    }


}
