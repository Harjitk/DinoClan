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

import java.util.List;

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
        Paddock diploJungle = new Paddock("Diplojungle", 10, park);
        DBPark.addPaddock(park, diploJungle);
        Paddock trexDuplex = new Paddock("Trex Duplex", 1, park);
        DBPark.addPaddock(park, diploJungle);

        Velociraptor velociraptor = new Velociraptor("Tyrant", 15, 500000, 5, park, velociraptorDen);
        DBPark.buyDinosaur(velociraptor, holdingPen);
        Velociraptor velociraptor2 = new Velociraptor("Trouble", 15, 500000, 5, park, velociraptorDen);
        DBPark.buyDinosaur(velociraptor2, holdingPen);
        Velociraptor velociraptor3 = new Velociraptor("Terminator", 15, 500000, 5, park, velociraptorDen);
        DBPark.buyDinosaur(velociraptor3, holdingPen);
        Diplodocus diplodocus = new Diplodocus("Todd", 35, 700000, 5, park, diploJungle);
        DBPark.buyDinosaur(diplodocus, holdingPen);
        Stegosaurus stegosaurus = new Stegosaurus("Stegz", 45, 850000, 6, park, stegzDwelling);
        DBPark.buyDinosaur(stegosaurus, holdingPen);
        Tyrannosaurus tyrannosaurus = new Tyrannosaurus("Rex", 55, 950000, 7, park, trexDuplex);
        DBPark.buyDinosaur(tyrannosaurus, holdingPen);

        Visitor richard = new Visitor("Richard", 1000, park);
        DBPark.addVisitor(park, richard);
        Visitor harjit = new Visitor("Harjit", 1000, park);
        DBPark.addVisitor(park, harjit);

        ParkStaff debzStaff = new ParkStaff("debz", 1000, park);
        DBPark.addParkStaff(park, debzStaff);

        DBPark.generateFood(park, 200);


        List<Visitor> foundVisitors = DBHelper.getAll(Visitor.class);
//        add DeleteAll method to DBHelper and in here?
    }
}
