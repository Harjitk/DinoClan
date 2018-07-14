package models.dinosaurs;


import models.enums.DietType;
import models.foods.Food;
import models.Paddock;
import models.Park;
import models.humans.Human;

import java.util.ArrayList;
import java.util.List;

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
    private Paddock paddock;
    private int bellyCapacity;


    public Dinosaur() {
    }


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
        this.paddock = paddock;
        this.bellyCapacity = bellyCapacity;
    }


    public void eat(){
        Food food = paddock.getFoodStore().get(0);
        getBelly().add(food);
        setHappiness(this.happiness += 5);
    }

//    ADD .RAMPAGE FUNCTION

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DietType getDietType() {
        return dietType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }
    public int getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public List<Food> getBelly() {
        return belly;
    }

    public void setBelly(List<Food> belly) {
        this.belly = belly;
    }

    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }

    public int getBellyCapacity() {
        return bellyCapacity;
    }

    public void setBellyCapacity(int bellyCapacity) {
        this.bellyCapacity = bellyCapacity;
    }

}
