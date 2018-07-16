package models;

import models.dinosaurs.Dinosaur;
import models.foods.Food;
import models.foods.Meat;
import models.foods.Plant;
import models.humans.Human;
import models.humans.ParkStaff;
import models.humans.Visitor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Entity
@Table(name="parks")

public class Park {

    private int id;
    private String name;
    private List<Dinosaur> dinosaursInPark;
    private List<ParkStaff> parkStaff;
    private List<Visitor> visitors;
    private List<Food> foodStock;
    private List<Paddock> paddocks;
    private int till;
    private int entryFee;

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

    @Column(name="till")
    public int getTill() {
        return till;
    }

    public void setTill(int till) {
        this.till = till;
    }

    @Column(name="entryFree")
    public int getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }

//    Don't think it's ever relevant to use this method rather than moveVisitorToPaddock.
//    public void addVisitorToPaddock(Visitor visitor, Paddock paddock) {
//        paddock.getVisitorsInPaddock().add(visitor);
//        visitor.setPaddock(paddock);
//        for (Dinosaur dinosaur : paddock.getDinosaursInPaddock()){
//            visitor.getDinosSeen().add(dinosaur);
//            dinosaur.getHumanVisitors().add(visitor);
//        }
//    }

    public void moveVisitorToPaddock(Visitor visitor, Paddock paddock) {
        if (visitor.getPaddock() != null){
        visitor.getPaddock().getVisitorsInPaddock().remove(visitor);
        }
        paddock.getVisitorsInPaddock().add(visitor);
        visitor.setPaddock(paddock);
        for (Dinosaur dinosaur : paddock.getDinosaursInPaddock()){
            visitor.getDinosSeen().add(dinosaur);
            dinosaur.getHumanVisitors().add(visitor);
        }
    }

    public void buyDinosaur(Dinosaur dinosaur, Paddock paddock) {
//      NEEDS TO RETURN STRING IF CONDITION NOT MET

        if (paddock.getCapacity() > paddock.getDinosaursInPaddock().size()) {

            if (this.till - dinosaur.getPrice() >= 0) {
                if (paddock.getDinosaursInPaddock().size() == 0 ||
                        paddock.getDinosaursInPaddock().get(0).getDietType() == dinosaur.getDietType()) {
                    paddock.getDinosaursInPaddock().add(dinosaur);
                    setTill(this.till - dinosaur.getPrice());
                }
            }
        }
    }

    public void addPaddock(Paddock paddock) {
        this.paddocks.add(paddock);
    }

    public void removePaddock(Paddock paddock) {
        this.paddocks.remove(paddock);
    }

    public void removeDinosaur(Dinosaur dinosaur) {
        this.dinosaursInPark.remove(dinosaursInPark);
    }

    public void addVisitor(Visitor visitor) {
        this.visitors.add(visitor);
        int visitorWallet = visitor.getWallet();
        setTill(till += entryFee);
        visitor.setWallet(visitorWallet -= entryFee);
    }

    public void removeVisitor(Visitor visitor) {
        this.visitors.remove(visitor);
    }

    public void addParkStaff(ParkStaff parkStaff) {
        this.parkStaff.add(parkStaff);
    }

    public void removeParkStaff(ParkStaff parkStaff) {
        this.parkStaff.remove(parkStaff);
    }

    public void addFoodToParkStock(Food food) {
        this.foodStock.add(food);
    }

    @OneToMany(mappedBy = "park")
    public List<Dinosaur> getDinosaursInPark() {
        return dinosaursInPark;
    }

    public void setDinosaursInPark(List<Dinosaur> dinosaursInPark) {
        this.dinosaursInPark = dinosaursInPark;
    }


    @OneToMany(mappedBy = "park")
    public List<ParkStaff> getParkStaff() {
        return parkStaff;
    }


    public void setParkStaff(List<ParkStaff> parkStaff) {
        this.parkStaff = parkStaff;
    }


    @OneToMany(mappedBy = "park")
    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    @OneToMany(mappedBy = "park")
    public List<Food> getFoodStock() {
        return foodStock;
    }

    public void setFoodStock(List<Food> foodStock) {
        this.foodStock = foodStock;
    }

@OneToMany(mappedBy = "park")
    public List<Paddock> getPaddocks() {
        return paddocks;
    }

    public void setPaddocks(List<Paddock> paddocks) {
        this.paddocks = paddocks;
    }


    public ArrayList<Food> generateFoodStock(int num) {
        ArrayList<Food> generatedFoodStock = new ArrayList<Food>();

        for (int index = 0; index < num; index++) {
            Random ran = new Random();

            int plantOrMeat = ran.nextInt(2);
            if (plantOrMeat == 1){
                Plant plant = new Plant();
                foodStock.add(plant);
                generatedFoodStock.add(plant);
            }
            else if (plantOrMeat == 0){
                Meat meat = new Meat();
                foodStock.add(meat);
                generatedFoodStock.add(meat);

            }
        }

        return generatedFoodStock;
    }
}