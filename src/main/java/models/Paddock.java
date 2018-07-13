package models;

public class Paddock {

    private String name;
    private int capacity;
    private String environment;
    private int health;

    public Paddock() {
    }

    public Paddock(String name, int capacity, String environment) {
        this.name = name;
        this.capacity = capacity;
        this.environment = environment;
        this.health = 1;
//        need to add:
//        List<Dinosaur> dinosaursInPaddock;
//        List<iEdible> foodStore;
//        List<Visitor> visitorsInPaddock;
//        Park park;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
