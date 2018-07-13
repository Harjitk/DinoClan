package models;

import java.util.ArrayList;
import java.util.List;

public class Paddock {

    private String name;
    private int capacity;
    private int health;
    private List<Dinosaur> dinosaursInPaddock;
    private List<Food> foodStore;
    private List<Visitor> visitorsInPaddock;
    private Park park;

    public Paddock() {
    }

    public Paddock(String name, int capacity, Park park) {
        this.name = name;
        this.capacity = capacity;
        this.health = 1;
        this.dinosaursInPaddock = new ArrayList<Dinosaur>();
        this.foodStore = new ArrayList<Food>();
        this.visitorsInPaddock = new ArrayList<Visitor>();
        this.park = park;

    }

    public void addDinosaurToPaddock(Dinosaur dinosaur){
        getDinosaursInPaddock().add(dinosaur);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Dinosaur> getDinosaursInPaddock() {
        return dinosaursInPaddock;
    }

    public void setDinosaursInPaddock(List<Dinosaur> dinosaursInPaddock) {
        this.dinosaursInPaddock = dinosaursInPaddock;
    }

    public List<Food> getFoodStore() {
        return foodStore;
    }

    public void setFoodStore(List<Food> foodStore) {
        this.foodStore = foodStore;
    }

    public List<Visitor> getVisitorsInPaddock() {
        return visitorsInPaddock;
    }

    public void setVisitorsInPaddock(List<Visitor> visitorsInPaddock) {
        this.visitorsInPaddock = visitorsInPaddock;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }
}
