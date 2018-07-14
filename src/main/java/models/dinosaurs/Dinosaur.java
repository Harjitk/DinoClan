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
    private List <Human> humanVisitors;
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
        this.humanVisitors = new ArrayList<Human>();
        this.paddock = paddock;
        this.bellyCapacity = bellyCapacity;
    }


    public void eat(){
        //      NEEDS TO RETURN STRING IF CONDITION NOT MET
        if (this.belly.size() < this.bellyCapacity) {
            Food food = paddock.getFoodStore().get(0);
            getBelly().add(food);
            paddock.getFoodStore().remove(food);
            if (this.happiness <= 95) {
                setHappiness(this.happiness += 5);
            }
        }
    }

    public void eatHuman(Human human){
        //      NEEDS TO RETURN STRING IF CONDITION NOT MET
        if (this.humanBelly.size() < this.bellyCapacity) {
            getHumanBelly().add(human);
            park.getVisitors().remove(human);
            if (this.happiness <= 95) {
                setHappiness(this.happiness += 5);
            }
        }
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
