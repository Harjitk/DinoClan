package models.dinosaurs;

import models.enums.DietType;
import models.Paddock;
import models.Park;

public class Diplodocus extends Dinosaur {

    public Diplodocus() {
    }

    public Diplodocus(String name, int weight, int price, int bellyCapacity, Park park, Paddock paddock) {
        super(name, weight, price, bellyCapacity, park, paddock);
        setAttackValue(20);
        setDietType(DietType.Herbivore);
    }
}
