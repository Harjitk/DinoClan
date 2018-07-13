import models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestParkStaff {

    ParkStaff parkStaff;
    Paddock paddock;
    Park park;
    Meat meat;
    Velociraptor velociraptor;

    @Before
    public void setUp() throws Exception {
        park = new Park("DinoClan");
        parkStaff = new ParkStaff("Mr Dino Lover", 100, park);
        paddock = new Paddock("T-Rex Duplex", 1, park);
        meat = new Meat();
        velociraptor = new Velociraptor();

    }

    @Test
    public void parkStaffCanRepairPaddock() {
        paddock.setHealth(0);
        parkStaff.repairPaddock(paddock);
        assertEquals(1, paddock.getHealth());
    }

    @Test
    public void canAddFoodToPaddock() {
        park.getFoodStock().add(meat);
        parkStaff.addFoodToStore(paddock);
        assertEquals(1, paddock.getFoodStore().size());
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
