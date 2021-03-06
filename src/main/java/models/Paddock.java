package models;

import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.humans.Visitor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    public void dinosaursInPaddockRampage(){
        for (Dinosaur dinosaur : this.dinosaursInPaddock){
            dinosaur.rampage();
        }
        this.emptyPaddock();

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "paddock")
    @Fetch(value = FetchMode.SUBSELECT)
    public List<Dinosaur> getDinosaursInPaddock() {
        return dinosaursInPaddock;
    }

    public void setDinosaursInPaddock(List<Dinosaur> dinosaursInPaddock) {
        this.dinosaursInPaddock = dinosaursInPaddock;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "paddock")
    @Fetch(value = FetchMode.SUBSELECT)
    public List<Food> getFoodStore() {
        return foodStore;
    }

    public void setFoodStore(List<Food> foodStore) {
        this.foodStore = foodStore;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "paddock")
    @Fetch(value = FetchMode.SUBSELECT)
    public List<Visitor> getVisitorsInPaddock() {
        return visitorsInPaddock;
    }


    public void setVisitorsInPaddock(List<Visitor> visitorsInPaddock) {
        this.visitorsInPaddock = visitorsInPaddock;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "park_id", nullable = false)
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public void emptyPaddock(){
        if(this.health == 0){
        this.dinosaursInPaddock.clear();
        }
    }

    public int dinosaurCount(){
        return this.dinosaursInPaddock.size();
    }
}
