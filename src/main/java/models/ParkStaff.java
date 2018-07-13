package models;

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
        Food food = park.getFoodStock().get(0);
        paddock.getFoodStore().add(food);
//        needs to be conditional
    }

    public void transferDinosaur(Dinosaur dinosaur, Paddock paddock){
        paddock.getDinosaursInPaddock().add(dinosaur);
//        needs to be conditional
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }
}
