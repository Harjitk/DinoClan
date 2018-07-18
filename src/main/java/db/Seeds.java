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
        Paddock stegzDwelling = new Paddock("The Plains", 3, park);
        DBPark.addPaddock(park, stegzDwelling);
        Paddock velociraptorDen = new Paddock("Raptor Den", 5, park);
        DBPark.addPaddock(park, velociraptorDen);
        Paddock velociraptorCanyon = new Paddock("Raptor Canyon", 5, park);
        DBPark.addPaddock(park, velociraptorCanyon);
        Paddock diploJungle = new Paddock("Diplojungle", 10, park);
        DBPark.addPaddock(park, diploJungle);
        Paddock trexDuplex = new Paddock("Trex Duplex", 1, park);
        DBPark.addPaddock(park, trexDuplex);

        Velociraptor velociraptor = new Velociraptor("Tyrant", 180, 500000, 10, park, velociraptorDen);
        DBPark.buyDinosaur(park, velociraptor, velociraptorDen);
        Velociraptor velociraptor2 = new Velociraptor("Trouble", 175, 500000, 9, park, velociraptorDen);
        DBPark.buyDinosaur(park, velociraptor2, velociraptorDen);
        Velociraptor velociraptor3 = new Velociraptor("Terminator", 191, 500000, 11, park, velociraptorDen);
        DBPark.buyDinosaur(park, velociraptor3, velociraptorDen);
        Velociraptor velociraptor4 = new Velociraptor("Mr T", 150, 500000, 6, park, velociraptorDen);
        DBPark.buyDinosaur(park, velociraptor4, velociraptorDen);
        Velociraptor velociraptor5 = new Velociraptor("Notorious", 180, 500000, 10, park, velociraptorCanyon);
        DBPark.buyDinosaur(park, velociraptor5, velociraptorDen);
        Velociraptor velociraptor6 = new Velociraptor("Biggie", 175, 500000, 9, park, velociraptorCanyon);
        DBPark.buyDinosaur(park, velociraptor6, velociraptorDen);
        Velociraptor velociraptor7 = new Velociraptor("Smalls", 220, 600000, 14, park, velociraptorCanyon);
        DBPark.buyDinosaur(park, velociraptor7, velociraptorDen);

        Diplodocus diplodocus = new Diplodocus("Todd", 25000, 700000, 25, park, diploJungle);
        DBPark.buyDinosaur(park, diplodocus, diploJungle);
        Stegosaurus stegosaurus = new Stegosaurus("Stegz", 1500, 850000, 15, park, stegzDwelling);
        Stegosaurus stegosaurus2 = new Stegosaurus("Sore", 1600, 890000, 15, park, stegzDwelling);

        DBPark.buyDinosaur(park, stegosaurus, stegzDwelling);
        Tyrannosaurus tyrannosaurus = new Tyrannosaurus("Rex", 15000, 950000, 60, park, trexDuplex);
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
        DBRandomGenerator.generateMultipleVisitors(park, randomGenerator, 1);

        DBPark.generateFood(park, 1);

        DBParkStaff.addFoodToStore(park, debzStaff, velociraptorDen);
//        DBParkStaff.addFoodToStore(park, debzStaff, velociraptorDen);
//        DBParkStaff.addFoodToStore(park, debzStaff, velociraptorDen);
//
//        DBParkStaff.addFoodToStore(park, debzStaff, diploJungle);
//        DBParkStaff.addFoodToStore(park, debzStaff, diploJungle);
//        DBParkStaff.addFoodToStore(park, debzStaff, diploJungle);
//
//        DBParkStaff.addFoodToStore(park, debzStaff, stegzDwelling);
//        DBParkStaff.addFoodToStore(park, debzStaff, stegzDwelling);
//        DBParkStaff.addFoodToStore(park, debzStaff, stegzDwelling);
//
//        DBParkStaff.addFoodToStore(park, debzStaff, trexDuplex);
//        DBParkStaff.addFoodToStore(park, debzStaff, trexDuplex);
//        DBParkStaff.addFoodToStore(park, debzStaff, trexDuplex);

        velociraptor.setHappiness(0); DBHelper.saveOrUpdate(velociraptor);
        velociraptor2.setHappiness(0); DBHelper.saveOrUpdate(velociraptor2);
        velociraptor3.setHappiness(0); DBHelper.saveOrUpdate(velociraptor3);
        velociraptor4.setHappiness(0); DBHelper.saveOrUpdate(velociraptor4);

        List<Visitor> foundVisitors = DBHelper.getAll(Visitor.class);
//        add DeleteAll method to DBHelper and in here?
    }
}
