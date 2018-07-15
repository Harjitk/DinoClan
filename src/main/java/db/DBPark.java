package db;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.humans.ParkStaff;
import models.humans.Visitor;

public class DBPark {

    public static void addVisitorToPaddock(Park park, Visitor visitor, Paddock paddock) {
        park.addVisitorToPaddock(visitor, paddock);
        DBHelper.saveOrUpdate(visitor);
        DBHelper.saveOrUpdate(paddock);
        for (Dinosaur dinosaur : paddock.getDinosaursInPaddock()) {
            DBHelper.saveOrUpdate(dinosaur);
        }

    }

    public static void moveVisitorToPaddock(Park park, Visitor visitor, Paddock paddock) {
        park.moveVisitorToPaddock(visitor, paddock);
        DBHelper.saveOrUpdate(visitor);
        DBHelper.saveOrUpdate(paddock);
        for (Dinosaur dinosaur : paddock.getDinosaursInPaddock()) {
            DBHelper.saveOrUpdate(dinosaur);
        }
    }

    public static void buyDinosaur(Park park, Dinosaur dinosaur, Paddock paddock){
        park.buyDinosaur(dinosaur, paddock);
        dinosaur.setPark(park);
        park.getDinosaursInPark().add(dinosaur);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(paddock);
    }

    public static void addPaddock(Park park, Paddock paddock){
        park.addPaddock(paddock);
        DBHelper.saveOrUpdate(paddock);
        DBHelper.saveOrUpdate(park);
    }

    public static void removePaddock(Park park, Paddock paddock){
        park.removePaddock(paddock);
        DBHelper.delete(paddock);
        DBHelper.saveOrUpdate(park);
    }

    public static void removeDinosaur(Park park, Dinosaur dinosaur){
        park.removeDinosaur(dinosaur);
        DBHelper.delete(dinosaur);
        DBHelper.saveOrUpdate(park);
    }

    public static void addVisitor(Park park, Visitor visitor){
        park.addVisitor(visitor);
        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(visitor);
    }

    public static void removeVisitor(Park park, Visitor visitor){
        park.removeVisitor(visitor);
        DBHelper.delete(visitor);
        DBHelper.saveOrUpdate(park);
    }

    public static void addParkStaff(Park park, ParkStaff parkStaff){
        park.addParkStaff(parkStaff);
        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(parkStaff);
    }






}


