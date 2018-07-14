package models;

import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.foods.Meat;
import models.foods.Plant;
import models.humans.Human;
import models.humans.ParkStaff;
import models.humans.Visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Park {

    private String name;
    private List<Dinosaur> dinosaursInPark;
    private List<ParkStaff> parkStaff;
    private List<Visitor> visitors;
    private List<Food> foodStock;
    private List<Paddock> paddocks;
    private int till;
    private int entryFee;

//    need to write: populateFoodStock

    public Park() {
    }

    public Park(String name) {
        this.name = name;
        this.dinosaursInPark = new ArrayList<Dinosaur>();
        this.parkStaff = new ArrayList<ParkStaff>();
        this.visitors = new ArrayList<Visitor>();
        this.foodStock = new ArrayList<Food>();
        this.paddocks = new ArrayList<Paddock>();
        this.till = 200000000;
        this.entryFee = 1000;
    }

    public void addVisitorToPaddock(Visitor visitor, Paddock paddock) {
        paddock.getVisitorsInPaddock().add(visitor);
        visitor.setPaddock(paddock);
    }

    public void buyDinosaur(Dinosaur dinosaur, Paddock paddock) {
        if (this.till - dinosaur.getPrice() >= 0) {
            if (paddock.getDinosaursInPaddock().size() == 0 ||
                    paddock.getDinosaursInPaddock().get(0).getDietType() == dinosaur.getDietType()) {
                paddock.getDinosaursInPaddock().add(dinosaur);
                setTill(this.till - dinosaur.getPrice());
            }

        }

    }

    public void addPaddock(Paddock paddock) {
        this.paddocks.add(paddock);
    }

    public void removePaddock(Paddock paddock) {
        this.paddocks.remove(paddock);
    }

    public void removeDinosaur(Dinosaur dinosaur) {
        this.dinosaursInPark.remove(dinosaursInPark);
    }

    public void addVisitor(Visitor visitor) {
        this.visitors.add(visitor);
    }

    public void removeVisitor(Visitor visitor) {
        this.visitors.remove(visitor);
    }

    public void addParkStaff(ParkStaff parkStaff) {
        this.parkStaff.add(parkStaff);
    }

    public void removeParkStaff(ParkStaff parkStaff) {
        this.parkStaff.remove(parkStaff);
    }

    public void addFoodToParkStock(Food food) {
        this.foodStock.add(food);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dinosaur> getDinosaursInPark() {
        return dinosaursInPark;
    }

    public void setDinosaursInPark(List<Dinosaur> dinosaursInPark) {
        this.dinosaursInPark = dinosaursInPark;
    }

    public List<ParkStaff> getParkStaff() {
        return parkStaff;
    }

    public void setParkStaff(List<ParkStaff> parkStaff) {
        this.parkStaff = parkStaff;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public List<Food> getFoodStock() {
        return foodStock;
    }

    public void setFoodStock(List<Food> foodStock) {
        this.foodStock = foodStock;
    }

    public List<Paddock> getPaddocks() {
        return paddocks;
    }

    public void setPaddocks(List<Paddock> paddocks) {
        this.paddocks = paddocks;
    }

    public int getTill() {
        return till;
    }

    public void setTill(int till) {
        this.till = till;
    }

    public int getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }

    //    Write a method for the Park class which takes in an integer.
//        It should create new Food objects and add them to the Park's food stock ArrayList.
//        NEWING UP FOOD OBJECTS IN FOR LOOP
//        SAME LOOP- ADDING TO PARKS FOOD STOCK ARRAYLIST
//
//        It will stop creating new Food objects and
//        adding them to the food stock when the integer being passed in is reached.

    public ArrayList<Food> generateFoodStock(int num) {
        ArrayList<Food> generateFoodStock = new ArrayList<Food>();

        for (int index = 0; index < num; index++) {
            Random ran = new Random();

            int plantOrMeat = ran.nextInt(2);
            if (plantOrMeat == 1){
                Plant plant = new Plant();
                foodStock.add(plant);
                generateFoodStock.add(plant);
            }
            else if (plantOrMeat == 0){
                Meat meat = new Meat();
                foodStock.add(meat);
                generateFoodStock.add(meat);

            }
        }

        return generateFoodStock;
    }
}