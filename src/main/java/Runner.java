import db.DBDinosaur;
import db.DBHelper;
import models.Paddock;
import models.Park;
import models.dinosaurs.*;
import models.foods.Meat;
import models.foods.Plant;
import models.humans.ParkStaff;
import models.humans.Visitor;

public class Runner {

    public static void main(String[] args) {


       Park park = new Park("Dino Clan");
        DBHelper.saveOrUpdate(park);

        Paddock paddock = new Paddock("T-Rex's Pad", 1, park);
        DBHelper.saveOrUpdate(paddock);

        Velociraptor velociraptor = new Velociraptor("Tyrant", 15, 500000, 5, park, paddock);
        DBHelper.saveOrUpdate(velociraptor);
        Diplodocus diplodocus = new Diplodocus("Todd", 35, 700000, 5, park, paddock);
        DBHelper.saveOrUpdate(diplodocus);
        Stegosaurus stegosaurus = new Stegosaurus("Stegz", 45, 850000, 6, park, paddock);
        DBHelper.saveOrUpdate(stegosaurus);
        Tyrannosaurus tyrannosaurus = new Tyrannosaurus("Rex", 55, 950000, 7, park, paddock);
        DBHelper.saveOrUpdate(tyrannosaurus);

        Visitor visitor1 = new Visitor("Richard", 1000, park);
        DBHelper.saveOrUpdate(visitor1);

        Visitor visitor2 = new Visitor("Harjit", 1000, park);
        DBHelper.saveOrUpdate(visitor2);

        ParkStaff parkStaff1 = new ParkStaff("debz", 1000, park);
        DBHelper.saveOrUpdate(parkStaff1);

        Meat meat = new Meat();
        DBHelper.saveOrUpdate(meat);

        Plant plant = new Plant();
        DBHelper.saveOrUpdate(plant);

        park.generateFoodStock(10);
        parkStaff1.addFoodToStore(paddock);
        DBDinosaur.eat(diplodocus);

    }
}
