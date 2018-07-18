import controllers.VisitorsController;
import db.*;
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

public class Runner {

    public static void main(String[] args) {

     //Seeding DB & saving
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
        Visitor greg = new Visitor("Greg", 1000, park);
        DBPark.addVisitor(park, greg);
        Visitor debbie = new Visitor("Debbie", 1000, park);
        DBPark.addVisitor(park, debbie);
        Visitor matt = new Visitor("Matt", 1000, park);
        DBPark.addVisitor(park, matt);
        Visitor cleyra = new Visitor("Cleyra", 1000, park);
        DBPark.addVisitor(park, cleyra);

        ParkStaff debzStaff = new ParkStaff("debz", 1000, park);
        DBPark.addParkStaff(park, debzStaff);

        RandomGenerator randomGenerator = new RandomGenerator(harjit, park);

        DBParkStaff.transferDinosaur(debzStaff, velociraptor, velociraptorDen);
        DBParkStaff.transferDinosaur(debzStaff, velociraptor2, velociraptorDen);
        DBParkStaff.transferDinosaur(debzStaff, velociraptor3, velociraptorDen);

        DBPark.moveVisitorToPaddock(park, richard, velociraptorDen);
        DBPark.moveVisitorToPaddock(park, harjit, velociraptorDen);
        DBPark.moveVisitorToPaddock(park, greg, velociraptorDen);
        DBPark.moveVisitorToPaddock(park, debbie, velociraptorDen);
        DBPark.moveVisitorToPaddock(park, matt, velociraptorDen);
        DBPark.moveVisitorToPaddock(park, cleyra, velociraptorDen);

        List<Dinosaur> cleyraSeen = DBVisitor.getDinosaursSeenByVisitor(cleyra);
        List<Human> velociraptorSeen = DBDinosaur.getHumansSeenByDinosaur(velociraptor);
        List<Dinosaur> dinosaursInPaddock = DBPaddock.getDinosaursForPaddock(velociraptorDen);

        DBPark.generateFood(park, 4);

        DBRandomGenerator.generateMultipleVisitors(park, randomGenerator, 2);

        DBParkStaff.addFoodToStore(park, debzStaff, velociraptorDen);
        DBParkStaff.addFoodToStore(park, debzStaff, velociraptorDen);
        DBParkStaff.addFoodToStore(park, debzStaff, velociraptorDen);
        DBParkStaff.addFoodToStore(park, debzStaff, velociraptorDen);

       Object firstFood = DBFood.getFirstBitOfFoodInPaddock(velociraptorDen);

       Paddock veloPaddock = DBDinosaur.getTheDinosaursPaddock(velociraptor);

       Object firstObjectInRaptorDen = DBPaddock.getFirstVisitorsInPaddock(velociraptorDen);
       Visitor firstVisitorInRaptorDen = (Visitor)firstObjectInRaptorDen;

       Object firstDinoInRaptorDen = DBPaddock.getFirstDinosaurInPaddock(velociraptorDen);
       Dinosaur firstVelociraptorInRaptorDen = (Dinosaur)firstDinoInRaptorDen;


//
//        List<Dinosaur> dinosaurs = DBHelper.getAll(Dinosaur.class);

////        Testing rampage
//        velociraptor.setHappiness(0);
//        velociraptor2.setHappiness(0);
//        velociraptor3.setHappiness(0);
//        DBDinosaur.rampage(velociraptor);

//        Testing food generation
//        DBPark.generateFood(park, 10);

//        Testing moving food to paddock and then dinosaur eating it
//        DBParkStaff.addFoodToStore(debzStaff, velociraptorDen);
//        DBParkStaff.addFoodToStore(debzStaff, velociraptorDen);
//        DBDinosaur.eat(velociraptor);

//        Testing generating visitors
        DBRandomGenerator.generateMultipleVisitors(park, randomGenerator, 2);

//       //Moving dinosaurs to paddocks
//       debzStaff.transferDinosaur(stegosaurus, stegzDwelling);
//       debzStaff.transferDinosaur(velociraptor, velociraptorDen);
//       debzStaff.transferDinosaur(velociraptor2, velociraptorDen);
//
//       //DBDinosaur tests
//        park.generateFoodStock(10);
//        debzStaff.addFoodToStore(holdingPen);
//        DBDinosaur.eat(diplodocus);
//        DBDinosaur.eatHuman(stegosaurus, richard);
//
//        //DBVisitor tests
//        DBPark.addVisitorToPaddock(park, harjit, stegzDwelling);
//        DBVisitor.tauntDinosaursInPaddock(harjit);
//
//        //DBParkStaff tests
//     holdingPen.setHealth(0);
//        DBHelper.saveOrUpdate(holdingPen);
//        DBParkStaff.repairPaddock(debzStaff, holdingPen);
//
//        DBParkStaff.addFoodToStore(debzStaff, holdingPen);
//
//        DBParkStaff.transferDinosaur(debzStaff, velociraptor3, velociraptorDen);
//
//        DBParkStaff.calmDinosaursInPaddock(debzStaff, velociraptorDen);
//
//        //DBPark tests
//        DBPark.addVisitorToPaddock(park, richard, holdingPen);
//        DBPark.moveVisitorToPaddock(park, richard, velociraptorDen);
//        DBPark.removeDinosaur(park, tyrannosaurus);


    }
}
