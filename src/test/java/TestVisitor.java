import models.*;
import models.dinosaurs.Velociraptor;
import models.foods.Meat;
import models.humans.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestVisitor {

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
        park.addVisitorToPaddock(visitor, paddock);

        velociraptor = new Velociraptor("Trouble", 100, 500000, 5, park, paddock);
        velociraptor2 = new Velociraptor("More Trouble", 150, 700000, 8, park, paddock);

        park.buyDinosaur(velociraptor, paddock);
        park.buyDinosaur(velociraptor2, paddock);

        meat = new Meat();
        }



    @Test
    public void canTauntAllDinosaursInPaddock() {
        park.addVisitorToPaddock(visitor, paddock);
        visitor.tauntDinosaursInPaddock();
        assertEquals(45, velociraptor.getHappiness());
        assertEquals(45, velociraptor2.getHappiness());
    }

    @Test
    public void canGetRandomName() {
        assertNotNull(visitor.randName());
    }

    @Test
    public void randomWalletAbove2000(){
        assertTrue(visitor.randWallet() >= 2000);
//        assertTrue(visitor.randWallet() >= 2000);
    }
}
