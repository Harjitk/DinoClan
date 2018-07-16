import models.*;
import models.dinosaurs.Stegosaurus;
import models.dinosaurs.Velociraptor;
import models.foods.Food;
import models.foods.Meat;
import models.humans.ParkStaff;
import models.humans.Visitor;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.assertEquals;

public class TestPark {

    Visitor visitor;
    Visitor visitor2;
    ParkStaff parkStaff;
    Paddock paddock;
    Paddock paddock2;
    Park park;
    Meat meat;
    Velociraptor velociraptor;
    Velociraptor velociraptor2;
    Stegosaurus stegosaurus;


    @Before
    public void setUp() throws Exception {
        park = new Park("DinoClan");
        visitor = new Visitor("Mr Dino Lover", 100, park);
        visitor2 = new Visitor(visitor.randName(), visitor.randWallet(), park);
        parkStaff = new ParkStaff(visitor.randName(), visitor.randWallet(), park);
        paddock = new Paddock("T-Rex Duplex", 1, park);
        paddock2 = new Paddock("Velo Pen", 4, park);
        meat = new Meat();
        velociraptor = new Velociraptor("Trouble", 100, 500000, 5, park, paddock);
        velociraptor2 = new Velociraptor("More Trouble", 150, 700000, 8, park, paddock);
        stegosaurus = new Stegosaurus("Robert", 700, 400000, 20, park, paddock);


    }

    @Test
    public void canAddVisitorToPaddock() {
        park.moveVisitorToPaddock(visitor, paddock);
        assertEquals(1, paddock.getVisitorsInPaddock().size());
    }

    @Test
    public void canMoveVisitorToNewPaddock() {
        park.moveVisitorToPaddock(visitor, paddock);
        park.moveVisitorToPaddock(visitor, paddock2);
        assertEquals(0, paddock.getVisitorsInPaddock().size());
        assertEquals(1, paddock2.getVisitorsInPaddock().size());

    }

    @Test
    public void canBuyDinosaurs() {
        park.buyDinosaur(velociraptor, paddock);
        assertEquals(1, paddock.getDinosaursInPaddock().size());
        assertEquals(199500000, park.getTill());
    }

    @Test
    public void cannotAddMultipleDinosaurTypesToSamePaddock() {
        park.buyDinosaur(velociraptor, paddock);
        park.buyDinosaur(stegosaurus, paddock);
        assertEquals(1, paddock.getDinosaursInPaddock().size());

    }

    @Test
    public void canGenerateFoodStock() {
        park.generateFoodStock(20);
        assertEquals(20, park.getFoodStock().size() );
    }

    @Test
    public void visitorHasDinosaurInSeenPadocksWhenAddedToPaddock() {
        parkStaff.transferDinosaur(velociraptor, paddock2);
        park.moveVisitorToPaddock(visitor, paddock2);
        assertEquals(velociraptor, visitor.getDinosSeen().get(0));
    }
}
