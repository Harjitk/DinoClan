package models.dinosaurs;


import models.enums.DietType;
import models.foods.Food;
import models.Paddock;
import models.Park;
import models.humans.Human;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Dinosaur {

    private int id;
    private String name;
    private DietType dietType;
    private int attackValue;
    private int happiness;
    private int weight;
    private int price;
    private Park park;
    private List<Food> belly;
    private List<Human> humanBelly;
    private List<Human> humanVisitors;
    private Paddock paddock;
    private int bellyCapacity;


    public Dinosaur(String name, int weight, int price, int bellyCapacity, Park park, Paddock paddock) {
        this.name = name;
        this.dietType = null;
        this.attackValue = 0;
        this.happiness = 50;
        this.weight = weight;
        this.price = price;
        this.park = park;
        this.belly = new ArrayList<Food>();
        this.humanBelly = new ArrayList<Human>();
        this.humanVisitors = new ArrayList<Human>();
        this.paddock = paddock;
        this.bellyCapacity = bellyCapacity;
    }

    public Dinosaur() {
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() {
        return id;
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


    @Enumerated(value = EnumType.STRING)
    public DietType getDietType() {
        return dietType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }

    @Column(name="attackValue")
    public int getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    @Column(name="happiness")
    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    @Column(name="weight")
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    @Column(name="price")
    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name="bellyCapacity")
    public int getBellyCapacity() {
        return bellyCapacity;
    }

    public void setBellyCapacity(int bellyCapacity) {
        this.bellyCapacity = bellyCapacity;
    }


    public void eat(){
        Food food = paddock.getFoodStore().get(0);
        getBelly().add(food);
        setHappiness(this.happiness += 5);
    }

//    ADD .RAMPAGE FUNCTION

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "park_id", nullable = false)
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    @OneToMany(mappedBy = "dinosaur")
    public List<Food> getBelly() {
        return belly;
    }

    public void setBelly(List<Food> belly) {
        this.belly = belly;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="paddock_id", nullable = false )
    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }


    @OneToMany(mappedBy= "dinosaur")
    public List<Human> getHumanBelly() {
        return humanBelly;
    }

    public void setHumanBelly(List<Human> humanBelly) {
        this.humanBelly = humanBelly;
    }

    public List<Human> getHumanVisitors() {
        return humanVisitors;
    }

    public void setHumanVisitors(List<Human> humanVisitors) {
        this.humanVisitors = humanVisitors;
    }
}
