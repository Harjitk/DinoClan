import models.Paddock;
import models.ParkStaff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestParkStaff {

    ParkStaff parkStaff;
    Paddock paddock;

    @Before
    public void setUp() throws Exception {
        parkStaff = new ParkStaff("Mr Dino Lover", 100);
        paddock = new Paddock("T-Rex Duplex", 1, "Temperate");
    }

    @Test
    public void parkStaffCanRepairPaddock() {
        paddock.setHealth(0);
        parkStaff.repairPaddock(paddock);
        assertEquals(1, paddock.getHealth());
    }
}
