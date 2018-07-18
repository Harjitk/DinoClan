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
import java.util.Random;

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
        DBPark.addPaddock(park, trexDuplex);

        Velociraptor velociraptor = new Velociraptor("Tyrant", 250, 500000, 10, park, velociraptorDen);
        DBPark.buyDinosaur(park, velociraptor, velociraptorDen);
        Velociraptor velociraptor2 = new Velociraptor("Trouble", 250, 500000, 10, park, velociraptorDen);
        DBPark.buyDinosaur(park, velociraptor2, velociraptorDen);
        Velociraptor velociraptor3 = new Velociraptor("Terminator", 250, 500000, 10, park, velociraptorDen);
        DBPark.buyDinosaur(park, velociraptor3, velociraptorDen);
        Velociraptor velociraptor4 = new Velociraptor("MR T", 250, 500000, 10, park, velociraptorDen);
        DBPark.buyDinosaur(park, velociraptor4, velociraptorDen);
        Diplodocus diplodocus = new Diplodocus("Todd", 19000, 700000, 50, park, diploJungle);
        DBPark.buyDinosaur(park, diplodocus, diploJungle);
        Stegosaurus stegosaurus = new Stegosaurus("Stegz", 4500, 850000, 15, park, stegzDwelling);
        DBPark.buyDinosaur(park, stegosaurus, stegzDwelling);
        Tyrannosaurus tyrannosaurus = new Tyrannosaurus("Rex", 15000, 950000, 70, park, trexDuplex);
        DBPark.buyDinosaur(park, tyrannosaurus, trexDuplex);

        Visitor richard = new Visitor("Richard", 2000, park);
        DBPark.addVisitor(park, richard);
        DBPark.moveVisitorToPaddock(park, richard, stegzDwelling);
        Visitor harjit = new Visitor("Harjit", 2000, park);
        DBPark.addVisitor(park, harjit);
        DBPark.moveVisitorToPaddock(park, harjit, velociraptorDen);

        ParkStaff debzStaff = new ParkStaff("debz", 1000, park);
        DBPark.addParkStaff(park, debzStaff);

        RandomGenerator randomGenerator = new RandomGenerator(richard, park);
        DBRandomGenerator.generateMultipleVisitors(park, randomGenerator, 10);

        DBPark.generateFood(park, 30);

        DBParkStaff.addFoodToStore(park, debzStaff, velociraptorDen);
        DBParkStaff.addFoodToStore(park, debzStaff, velociraptorDen);
        DBParkStaff.addFoodToStore(park, debzStaff, velociraptorDen);

        DBParkStaff.addFoodToStore(park, debzStaff, diploJungle);
        DBParkStaff.addFoodToStore(park, debzStaff, diploJungle);
        DBParkStaff.addFoodToStore(park, debzStaff, diploJungle);

        DBParkStaff.addFoodToStore(park, debzStaff, stegzDwelling);
        DBParkStaff.addFoodToStore(park, debzStaff, stegzDwelling);
        DBParkStaff.addFoodToStore(park, debzStaff, stegzDwelling);

        DBParkStaff.addFoodToStore(park, debzStaff, trexDuplex);
        DBParkStaff.addFoodToStore(park, debzStaff, trexDuplex);
        DBParkStaff.addFoodToStore(park, debzStaff, trexDuplex);

        velociraptor.setHappiness(0);
        DBHelper.saveOrUpdate(velociraptor);
        velociraptor2.setHappiness(0);
        DBHelper.saveOrUpdate(velociraptor);
        velociraptor3.setHappiness(0);
        DBHelper.saveOrUpdate(velociraptor);
        velociraptor4.setHappiness(0);
        DBHelper.saveOrUpdate(velociraptor);

        List<Visitor> foundVisitors = DBHelper.getAll(Visitor.class);
//        add DeleteAll method to DBHelper and in here?
    }
}
