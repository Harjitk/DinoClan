import models.*;
import models.dinosaurs.Velociraptor;
import models.foods.Meat;
import models.humans.ParkStaff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VelociraptorTest {

    Meat meat;
    ParkStaff parkStaff;
    Paddock paddock;
    Park park;
    Velociraptor velociraptor;

    @Before
    public void setUp() throws Exception {
        meat = new Meat();
        park = new Park("Dino Park");
        paddock = new Paddock("Velo Pen", 4, park);
        velociraptor = new Velociraptor("Swifty", 10, 500000, 5, park, paddock);
        paddock.addDinosaurToPaddock(velociraptor);
        paddock.getFoodStore().add(meat);
    }

    @Test
    public void canAddFoodToBelly() {
        velociraptor.eat();
        assertEquals(1, velociraptor.getBelly().size());
        assertEquals(55, velociraptor.getHappiness());
    }

    @Test
    public void getAttackValue() {
        assertEquals(20, velociraptor.getAttackValue());
    }

}

