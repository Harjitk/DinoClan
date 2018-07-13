package models;

import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.humans.Human;
import models.humans.ParkStaff;
import models.humans.Visitor;

import java.util.ArrayList;
import java.util.List;

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

    public void addVisitorToPaddock(Visitor visitor, Paddock paddock){
        paddock.getVisitorsInPaddock().add(visitor);
        visitor.setPaddock(paddock);
    }

    public void buyDinosaur(Dinosaur dinosaur, Paddock paddock) {
        if (this.till - dinosaur.getPrice() >= 0) {
            if (paddock.getDinosaursInPaddock().size() == 0 ||
                    paddock.getDinosaursInPaddock().get(0).getDietType() == dinosaur.getDietType() ){
                paddock.getDinosaursInPaddock().add(dinosaur);
                setTill(this.till - dinosaur.getPrice());
            }

        }

    }

    public void addPaddock(Paddock paddock){
        this.paddocks.add(paddock);
    }

    public void removePaddock(Paddock paddock){
        this.paddocks.remove(paddock);
    }

    public void removeDinosaur(Dinosaur dinosaur){
        this.dinosaursInPark.remove(dinosaursInPark);
    }

    public void addVisitor(Visitor visitor){
        this.visitors.add(visitor);
    }

    public void removeVisitor(Visitor visitor){
        this.visitors.remove(visitor);
    }

    public void addParkStaff(ParkStaff parkStaff){
        this.parkStaff.add(parkStaff);
    }

    public void removeParkStaff(ParkStaff parkStaff){
        this.parkStaff.remove(parkStaff);
    }

    public void addFoodToParkStock(Food food){
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


}
