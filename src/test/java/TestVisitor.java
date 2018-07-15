import models.*;
import models.dinosaurs.Velociraptor;
import models.foods.Meat;
import models.humans.ParkStaff;
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
    ParkStaff parkStaff;

    @Before
    public void setUp() throws Exception {
        park = new Park("DinoClan");
        visitor = new Visitor("Mr Dino Lover", 100, park);
        parkStaff = new ParkStaff(visitor.randName(), visitor.randWallet(), park);
        paddock = new Paddock("T-Rex Duplex", 2, park);
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
    }

    @Test
    public void cantTauntBeyond5() {
        park.addVisitorToPaddock(visitor, paddock);
        visitor.tauntDinosaursInPaddock(); visitor.tauntDinosaursInPaddock(); visitor.tauntDinosaursInPaddock(); visitor.tauntDinosaursInPaddock(); visitor.tauntDinosaursInPaddock(); visitor.tauntDinosaursInPaddock(); visitor.tauntDinosaursInPaddock(); visitor.tauntDinosaursInPaddock(); visitor.tauntDinosaursInPaddock(); visitor.tauntDinosaursInPaddock(); visitor.tauntDinosaursInPaddock();
        assertEquals(0, paddock.getDinosaursInPaddock().get(0).getHappiness());
        assertEquals("This dinosaur is angry as hell and looks ready to RAMPAGE", visitor.tauntDinosaursInPaddock());
    }
}
