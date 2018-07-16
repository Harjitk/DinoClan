package db;

import models.Paddock;
import models.Park;
import models.RandomGenerator;
import models.dinosaurs.*;
import models.foods.Food;
import models.foods.Meat;
import models.foods.Plant;
import models.humans.Human;
import models.humans.ParkStaff;
import models.humans.Visitor;

public class Seeds {

    public static void seedData() {


        Park park = new Park("Dino Clan");
        DBHelper.saveOrUpdate(park);

        Paddock holdingPen = new Paddock("Holding pen", 10, park);
        DBPark.addPaddock(park, holdingPen);
        Paddock stegzDwelling = new Paddock("Stegz's dwelling", 1, park);
        DBPark.addPaddock(park, stegzDwelling);
        Paddock velociraptorDen = new Paddock("Velociraptor den", 5, park);
        DBPark.addPaddock(park, velociraptorDen);

        Velociraptor velociraptor = new Velociraptor("Tyrant", 15, 500000, 5, park, holdingPen);
        DBPark.buyDinosaur(park, velociraptor, holdingPen);
        Velociraptor velociraptor2 = new Velociraptor("Trouble", 15, 500000, 5, park, holdingPen);
        DBPark.buyDinosaur(park, velociraptor2, holdingPen);
        Velociraptor velociraptor3 = new Velociraptor("Terminator", 15, 500000, 5, park, holdingPen);
        DBPark.buyDinosaur(park, velociraptor3, holdingPen);
        Diplodocus diplodocus = new Diplodocus("Todd", 35, 700000, 5, park, holdingPen);
        DBPark.buyDinosaur(park, diplodocus, holdingPen);
        Stegosaurus stegosaurus = new Stegosaurus("Stegz", 45, 850000, 6, park, holdingPen);
        DBPark.buyDinosaur(park, stegosaurus, holdingPen);
        Tyrannosaurus tyrannosaurus = new Tyrannosaurus("Rex", 55, 950000, 7, park, holdingPen);
        DBPark.buyDinosaur(park, tyrannosaurus, holdingPen);

        Visitor richard = new Visitor("Richard", 1000, park);
        DBPark.addVisitor(park, richard);
        Visitor harjit = new Visitor("Harjit", 1000, park);
        DBPark.addVisitor(park, harjit);

        ParkStaff debzStaff = new ParkStaff("debz", 1000, park);
        DBPark.addParkStaff(park, debzStaff);

        Meat meat = new Meat();
        DBHelper.saveOrUpdate(meat);
        Plant plant = new Plant();
        DBHelper.saveOrUpdate(plant);

//
//        add DeleteAll method to DBHelper and in here?
    }
}
