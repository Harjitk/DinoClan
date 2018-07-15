import db.DBDinosaur;
import db.DBHelper;
import db.DBVisitor;
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

        Paddock paddock = new Paddock("Holding pen", 10, park);
        DBHelper.saveOrUpdate(paddock);
        Paddock paddock1 = new Paddock("Todd's dwelling", 1, park);
        DBHelper.saveOrUpdate(paddock1);
        Paddock paddock2 = new Paddock("Velociraptor den", 5, park);
        DBHelper.saveOrUpdate(paddock2);

        Velociraptor velociraptor = new Velociraptor("Tyrant", 15, 500000, 5, park, paddock);
        DBHelper.saveOrUpdate(velociraptor);
        Velociraptor velociraptor2 = new Velociraptor("Trouble", 15, 500000, 5, park, paddock);
        DBHelper.saveOrUpdate(velociraptor2);
        Velociraptor velociraptor3 = new Velociraptor("Terminator", 15, 500000, 5, park, paddock);
        DBHelper.saveOrUpdate(velociraptor3);
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

     parkStaff1.transferDinosaur(stegosaurus, paddock1);
     parkStaff1.transferDinosaur(velociraptor, paddock2);
     parkStaff1.transferDinosaur(velociraptor2, paddock2);
     parkStaff1.transferDinosaur(velociraptor3, paddock2);

        park.generateFoodStock(10);
        parkStaff1.addFoodToStore(paddock);
        DBDinosaur.eat(diplodocus);

        park.addVisitorToPaddock(visitor1, paddock1);
        DBHelper.saveOrUpdate(paddock);
        DBHelper.saveOrUpdate(visitor1);

        DBDinosaur.eatHuman(stegosaurus, visitor1);

        park.addVisitorToPaddock(visitor2, paddock2);
        DBVisitor.tauntDinosaursInPaddock(visitor2);



    }
}
