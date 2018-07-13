package models;

public class Tyrannosaurus extends Dinosaur {

    public Tyrannosaurus() {
    }

    public Tyrannosaurus(String name,  int weight, int price, int bellyCapacity, Park park, Paddock paddock) {
        super(name, weight, price, bellyCapacity, park, paddock);
        setAttackValue(200);
        setDietType(DietType.Carnivore);

    }
}
