package models.dinosaurs;

import models.enums.DietType;
import models.Paddock;
import models.Park;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tyrannosauruses")
public class Tyrannosaurus extends Dinosaur {

    public Tyrannosaurus() {
    }

    public Tyrannosaurus(String name, int weight, int price, int bellyCapacity, Park park, Paddock paddock) {
        super(name, weight, price, bellyCapacity, park, paddock);
        setAttackValue(200);
        setDietType(DietType.Carnivore);
    }

}
