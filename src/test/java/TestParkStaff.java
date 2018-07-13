import models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestParkStaff {

    ParkStaff parkStaff;
    Paddock paddock;
    Park park;
    Meat meat;
    Plant plant;
    Velociraptor velociraptor;
    Tyrannosaurus tyrannosaurus;
    Stegosaurus stegosaurus;

    @Before
    public void setUp() throws Exception {
        park = new Park("DinoClan");
        parkStaff = new ParkStaff("Mr Dino Lover", 100, park);
        paddock = new Paddock("T-Rex Duplex", 1, park);
        meat = new Meat();
        plant = new Plant();
        velociraptor = new Velociraptor("Swifty", 10, 500000, 5, park, paddock);
        tyrannosaurus = new Tyrannosaurus("FML", 100000, 1000000, 40, park, paddock);
        stegosaurus = new Stegosaurus("Stig", 700, 400000, 20, park, paddock);


    }

    @Test
    public void parkStaffCanRepairPaddock() {
        paddock.setHealth(0);
        parkStaff.repairPaddock(paddock);
        assertEquals(1, paddock.getHealth());
    }

    @Test
    public void canAddFoodToPaddockWhenEmpty() {
        park.getFoodStock().add(meat);
        parkStaff.addFoodToStore(paddock);
        assertEquals(1, paddock.getFoodStore().size());
    }

    @Test
    public void canAddPlantFoodToHerbivorePaddock() {
        park.buyDinosaur(stegosaurus, paddock);
        park.addFoodToParkStock(plant);
        parkStaff.addFoodToStore(paddock);
        assertEquals(1, paddock.getFoodStore().size());
    }

    @Test
    public void canAddMeatFoodToCarnivorePaddock() {
        park.buyDinosaur(tyrannosaurus, paddock);
        park.addFoodToParkStock(meat);
        parkStaff.addFoodToStore(paddock);
        assertEquals(1, paddock.getFoodStore().size());
    }

    @Test
    public void cantAddVegeFoodToCarnivorePaddock() {
        park.buyDinosaur(tyrannosaurus, paddock);
        park.addFoodToParkStock(plant);
        parkStaff.addFoodToStore(paddock);
        assertEquals(0, paddock.getFoodStore().size());
    }



    @Test
    public void paddockStartsEmpty() {
        assertEquals(0, paddock.getDinosaursInPaddock().size());
    }

    @Test
    public void canTransferDinosaurToPaddock() {
        parkStaff.transferDinosaur(velociraptor, paddock);
        assertEquals(1, paddock.getDinosaursInPaddock().size());

    }
}
