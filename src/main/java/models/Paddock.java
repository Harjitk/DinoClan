package models;

import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.humans.Visitor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="paddocks")

public class Paddock {

    private int id;
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

    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() {
        return id;
    }
  
    //NOTE - THIS IS NOT CONDITIONAL. Use ParkStaff transferDinosaur function to move dinosaurs around, not this.
    public void addDinosaurToPaddock(Dinosaur dinosaur){
        getDinosaursInPaddock().add(dinosaur);
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Column(name="health")
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void addDinosaurToPaddock(Dinosaur dinosaur){
        getDinosaursInPaddock().add(dinosaur);
    }

    public void removeDinosaurFromPaddock(Dinosaur dinosaur){
        getDinosaursInPaddock().remove(dinosaur);
    }

    @OneToMany(mappedBy = "paddock")
    public List<Dinosaur> getDinosaursInPaddock() {
        return dinosaursInPaddock;
    }

    public void setDinosaursInPaddock(List<Dinosaur> dinosaursInPaddock) {
        this.dinosaursInPaddock = dinosaursInPaddock;
    }


    @OneToMany(mappedBy = "paddock")
    public List<Food> getFoodStore() {
        return foodStore;
    }

    public void setFoodStore(List<Food> foodStore) {
        this.foodStore = foodStore;
    }

    @OneToMany(mappedBy = "paddock")
    public List<Visitor> getVisitorsInPaddock() {
        return visitorsInPaddock;
    }


    public void setVisitorsInPaddock(List<Visitor> visitorsInPaddock) {
        this.visitorsInPaddock = visitorsInPaddock;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "park_id", nullable = false)
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }
}
