package models.dinosaurs;


import models.enums.DietType;
import models.foods.Food;
import models.Paddock;
import models.Park;
import models.humans.Human;
import models.humans.Visitor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "dinosaurs")

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

    public void eatVisitor(Visitor visitor){
        //      NEEDS TO RETURN STRING IF CONDITION NOT MET
        if (this.humanBelly.size() < this.bellyCapacity) {
            getHumanBelly().add(visitor);
            visitor.setDinosaur(this);
            if (visitor.getPaddock() != null) {
                visitor.setPaddock(null);
            }
            park.getVisitors().remove(visitor);
            if (this.happiness <= 95) {
                setHappiness(this.happiness += 5);
            }
        }
    }


//    public boolean isDinosaurHappy(){
//        return this.happiness != 0;
//    }

    public void attackPaddock(){
        this.paddock.setHealth(0);

    }

    public void rampage(){

        if (happiness == 0) {
            this.attackPaddock();
            int bellyFull = this.bellyCapacity;
            List<Visitor> visitorsInPaddock = paddock.getVisitorsInPaddock();
            for(int i = 0; i < bellyFull; i ++){
                if(visitorsInPaddock.size() > 0){
                    Visitor food = visitorsInPaddock.remove(0);
                this.eatVisitor(food);
            }
//
            this.park.removeDinosaur(this);
//                Should this be moved to the park?
            }
        }
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

    @Column(name="price")
    public int getPrice() {
        return price;
    }

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

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "dinoDex",
            joinColumns = {@JoinColumn(name = "dinosaur_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "visitor_id", nullable = false, updatable = false)})
    public List<Human> getHumanVisitors() {
        return humanVisitors;
    }

    public void setHumanVisitors(List<Human> humanVisitors) {
        this.humanVisitors = humanVisitors;
    }

}
