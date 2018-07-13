import models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPark {

    Visitor visitor;
    Paddock paddock;
    Park park;
    Meat meat;
    Velociraptor velociraptor;
    Velociraptor velociraptor2;


    @Before
    public void setUp() throws Exception {
        park = new Park("DinoClan");
        visitor = new Visitor("Mr Dino Lover", 100, park);
        paddock = new Paddock("T-Rex Duplex", 1, park);
        meat = new Meat();
        velociraptor = new Velociraptor("Trouble",DietType.Omnivore, 100, 500000, 5,park, paddock);
        velociraptor2 = new Velociraptor("More Trouble", DietType.Omnivore, 150, 700000, 8, park, paddock);

    }

    @Test
    public void canAddVisitorToPaddock() {
        park.addVisitorToPaddock(visitor, paddock);
        assertEquals(1, paddock.getVisitorsInPaddock().size());
    }

    @Test
    public void canBuyDinosaurs() {
        park.buyDinosaur(velociraptor, paddock);
        assertEquals(1, paddock.getDinosaursInPaddock().size());
        assertEquals(199500000, park.getTill());
    }

//    @Test
//    public void cannotAddMultipleDinosaurTypesToSamePaddock() {
//        park.buyDinosaur(velociraptor, paddock);
//    }
}
