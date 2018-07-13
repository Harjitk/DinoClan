package models;

import java.util.ArrayList;
import java.util.List;

public class Paddock {

    private String name;
    private int capacity;
    private String environment;
    private int health;
    private List<Dinosaur> dinosaursInPaddock;
    private List<Food> foodStore;
    private List<Visitor> visitorsInPaddock;
    private Park park;

    public Paddock() {
    }

    public Paddock(String name, int capacity, String environment, Park park) {
        this.name = name;
        this.capacity = capacity;
        this.environment = environment;
        this.health = 1;
        this.dinosaursInPaddock = new ArrayList<Dinosaur>();
        this.foodStore = new ArrayList<Food>();
        this.visitorsInPaddock = new ArrayList<Visitor>();
        this.park = park;

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

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
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
