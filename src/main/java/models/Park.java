package models;

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
