package models.dinosaurs;

import models.enums.DietType;
import models.Paddock;
import models.Park;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "velociraptors")
public class Velociraptor extends Dinosaur {

    public Velociraptor() {
    }

    public Velociraptor(String name, int weight, int price, int bellyCapacity, Park park, Paddock paddock) {
        super(name, weight, price, bellyCapacity, park, paddock);
      setAttackValue(50);
      setDietType(DietType.Omnivore);

    }
}
