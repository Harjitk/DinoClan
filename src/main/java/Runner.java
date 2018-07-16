import db.*;
import models.Paddock;
import models.Park;
import models.dinosaurs.*;
import models.foods.Meat;
import models.foods.Plant;
import models.humans.ParkStaff;
import models.humans.Visitor;

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
       DBPark.buyDinosaur(velociraptor, holdingPen);
       Velociraptor velociraptor2 = new Velociraptor("Trouble", 15, 500000, 5, park, holdingPen);
     DBPark.buyDinosaur(velociraptor2, holdingPen);
       Velociraptor velociraptor3 = new Velociraptor("Terminator", 15, 500000, 5, park, holdingPen);
     DBPark.buyDinosaur(velociraptor3, holdingPen);
       Diplodocus diplodocus = new Diplodocus("Todd", 35, 700000, 5, park, holdingPen);
     DBPark.buyDinosaur(diplodocus, holdingPen);
       Stegosaurus stegosaurus = new Stegosaurus("Stegz", 45, 850000, 6, park, holdingPen);
     DBPark.buyDinosaur(stegosaurus, holdingPen);
       Tyrannosaurus tyrannosaurus = new Tyrannosaurus("Rex", 55, 950000, 7, park, holdingPen);
     DBPark.buyDinosaur(tyrannosaurus, holdingPen);

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

       DBPark.moveVisitorToPaddock(richard, velociraptorDen);
        DBPark.moveVisitorToPaddock(harjit, velociraptorDen);
        DBPark.moveVisitorToPaddock(greg, velociraptorDen);
        DBPark.moveVisitorToPaddock(debbie, velociraptorDen);
        DBPark.moveVisitorToPaddock(matt, velociraptorDen);
        DBPark.moveVisitorToPaddock(cleyra, velociraptorDen);

       ParkStaff debzStaff = new ParkStaff("debz", 1000, park);
       DBPark.addParkStaff(park, debzStaff);

       Meat meat = new Meat();
       DBHelper.saveOrUpdate(meat);
       Plant plant = new Plant();
       DBHelper.saveOrUpdate(plant);

       DBParkStaff.transferDinosaur(debzStaff, velociraptor, velociraptorDen);
        DBParkStaff.transferDinosaur(debzStaff, velociraptor2, velociraptorDen);
        DBParkStaff.transferDinosaur(debzStaff, velociraptor3, velociraptorDen);

//        Testing rampage
        velociraptor.setHappiness(0);
        velociraptor2.setHappiness(0);
        velociraptor3.setHappiness(0);
        DBDinosaur.rampage(velociraptor);

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
