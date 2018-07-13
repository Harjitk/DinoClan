package models;

public class ParkStaff extends Human {

    public ParkStaff() {
    }

    public ParkStaff(String name, int wallet) {
        super(name, wallet);

//        to add:
//        Park park;

//        transferDinosaur(dinosaur, paddock)
//        calmDinosaur(dinosaur)
//        addFoodToStore(paddock)
    }


    public void repairPaddock(Paddock paddock){
        paddock.setHealth(1);
    }


}
