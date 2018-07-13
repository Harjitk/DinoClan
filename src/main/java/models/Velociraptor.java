package models;

public class Velociraptor extends Dinosaur {

    public Velociraptor() {
    }

    public Velociraptor(String name, DietType dietType, int weight, int price, int bellyCapacity, Park park, Paddock paddock) {
        super(name, dietType, weight, price, bellyCapacity, park, paddock);
    }
}
