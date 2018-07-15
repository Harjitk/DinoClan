package models.dinosaurs;

import models.enums.DietType;
import models.Paddock;
import models.Park;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stegosauruses")
public class Stegosaurus extends Dinosaur {

    public Stegosaurus() {
    }

    public Stegosaurus(String name, int weight, int price, int bellyCapacity, Park park, Paddock paddock) {
        super(name, weight, price, bellyCapacity, park, paddock);
        setAttackValue(90);
        setDietType(DietType.Herbivore);
    }
}
