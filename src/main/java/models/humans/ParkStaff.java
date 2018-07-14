package models.humans;

import models.Paddock;
import models.Park;
import models.dinosaurs.Dinosaur;
import models.enums.DietType;
import models.foods.Food;
import models.foods.Meat;
import models.foods.Plant;

import javax.persistence.*;

@Entity
@Table(name="partStaffs")

public class ParkStaff extends Human {

    private Park park;

    public ParkStaff() {

    }

    public ParkStaff(String name, int wallet, Park park) {
        super(name, wallet);
        this.park = park;

//        calmDinosaur(dinosaur)
    }


    public void repairPaddock(Paddock paddock){
        paddock.setHealth(1);
    }

    public void addFoodToStore(Paddock paddock){
//
        Food food = park.getFoodStock().get(0);

        if (paddock.getDinosaursInPaddock().size() > 0){

            if ((food instanceof Meat) && paddock.getDinosaursInPaddock().get(0).getDietType() == DietType.Carnivore) {
                paddock.getFoodStore().add(food);
            }

            else if ((food instanceof Plant) && paddock.getDinosaursInPaddock().get(0).getDietType() == DietType.Herbivore) {
               paddock.getFoodStore().add(food);
            }

            else if (paddock.getDinosaursInPaddock().get(0).getDietType() == DietType.Omnivore){
                paddock.getFoodStore().add(food);
            }

        }

        if (paddock.getDinosaursInPaddock().size() == 0){
            paddock.getFoodStore().add(food);
        }


    }

    public void transferDinosaur(Dinosaur dinosaur, Paddock paddock){
        paddock.getDinosaursInPaddock().add(dinosaur);
//        needs to be conditional
    }

    public void calmDinosaursInPadddock(Paddock paddock){
        int calm = 5;
        int currentHappiness;
        int newHappiness;
        for (Dinosaur dinosaur : paddock.getDinosaursInPaddock()) {
            currentHappiness = dinosaur.getHappiness();
            newHappiness = currentHappiness += calm;
            dinosaur.setHappiness(newHappiness);
        }
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="park_id", nullable = false)
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }
}
