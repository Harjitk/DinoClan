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
@Table(name="parkstaff")

public class ParkStaff extends Human {

    private Park park;

    public ParkStaff() {

    }

    public ParkStaff(String name, int wallet, Park park) {
        super(name, wallet);
        this.park = park;

    }


    public void repairPaddock(Paddock paddock){
        paddock.setHealth(1);
    }

    public void addFoodToStore(Paddock paddock){
        //      NEEDS TO RETURN STRING IF CONDITION NOT MET

        int foodCount = 0;
        if (foodCount == 0){

        for (Food food : park.getFoodStock()) {

                if (paddock.getDinosaursInPaddock().size() > 0 && foodCount == 0){

                    if ((food instanceof Meat) && paddock.getDinosaursInPaddock().get(0).getDietType() == DietType.Carnivore) {
                        paddock.getFoodStore().add(food);
                        foodCount += 1;
                    }

                    else if ((food instanceof Plant) && paddock.getDinosaursInPaddock().get(0).getDietType() == DietType.Herbivore) {
                        paddock.getFoodStore().add(food);
                        foodCount += 1;
                    }

                    else if (paddock.getDinosaursInPaddock().get(0).getDietType() == DietType.Omnivore){
                        paddock.getFoodStore().add(food);
                        foodCount += 1;
                    }
                }

                if (paddock.getDinosaursInPaddock().size() == 0 && foodCount == 0){
                    paddock.getFoodStore().add(food);
                    foodCount += 1;
                }
            }
        }
    }

    public String transferDinosaur(Dinosaur dinosaur, Paddock paddock) {

        if (paddock.getCapacity() > paddock.getDinosaursInPaddock().size()) {

            if (paddock.getDinosaursInPaddock().size() == 0) {
                paddock.getDinosaursInPaddock().add(dinosaur);
            } else if (paddock.getDinosaursInPaddock().get(0).getDietType() == dinosaur.getDietType()) {
                paddock.getDinosaursInPaddock().add(dinosaur);
            } else {
                return "This dinosaur is a(n) " + dinosaur.getDietType() + ", but the paddock is full of " + paddock.getDinosaursInPaddock().get(0).getDietType() + "s";
            }



        }
        return null;
    }


    public String calmDinosaursInPadddock(Paddock paddock){
        int calm = 5;
        int currentHappiness;
        int newHappiness;

        for (Dinosaur dinosaur : paddock.getDinosaursInPaddock()) {
            if (dinosaur.getHappiness() <= 95) {
                currentHappiness = dinosaur.getHappiness();
                newHappiness = currentHappiness += calm;
                dinosaur.setHappiness(newHappiness);
            }
            else return "This dinosaur is already as happy as can be";
        }

        return null;
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
