import models.*;
import models.dinosaurs.Velociraptor;
import models.foods.Meat;
import models.humans.Human;
import models.humans.ParkStaff;
import models.humans.Visitor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class VelociraptorTest {

    Meat meat;
    ParkStaff parkStaff;
    Paddock paddock;
    Park park;
    Velociraptor velociraptor;
    Visitor visitor;
    Visitor visitor2;
    RandomGenerator randomGenerator;

    @Before
    public void setUp() throws Exception {
        meat = new Meat();
        park = new Park("Dino Park");
        paddock = new Paddock("Velo Pen", 4, park);
        velociraptor = new Velociraptor("Swifty", 10, 500000, 5, park, paddock);
        visitor = new Visitor("randgen", 2000, park);
        visitor2 = new Visitor(visitor.randName(), visitor.randWallet(), park);
        parkStaff = new ParkStaff(visitor.randName(), visitor.randWallet(), park);
        parkStaff.transferDinosaur(velociraptor, paddock);
        park.generateFoodStock(10);
        parkStaff.addFoodToStore(paddock);
        parkStaff.addFoodToStore(paddock);
        parkStaff.addFoodToStore(paddock);
        parkStaff.addFoodToStore(paddock);
        parkStaff.addFoodToStore(paddock);
        parkStaff.addFoodToStore(paddock);
        parkStaff.addFoodToStore(paddock);
        parkStaff.addFoodToStore(paddock);
        parkStaff.addFoodToStore(paddock);
        parkStaff.addFoodToStore(paddock);
        randomGenerator = new RandomGenerator(visitor, park);
        randomGenerator.generateMultipleVisitors(50);

        paddock.getVisitorsInPaddock().add(visitor);
        paddock.getVisitorsInPaddock().add(visitor2);

    }

    @Test
    public void canAddFoodToBelly() {
        velociraptor.eat();
        assertEquals(1, velociraptor.getBelly().size());
        assertEquals(55, velociraptor.getHappiness());
    }

    @Test
    public void canEatUntilFull() {
        velociraptor.setBellyCapacity(1);
        velociraptor.eat();
        velociraptor.eat();
        assertEquals(1, velociraptor.getBelly().size());
    }

    @Test
    public void canEatUntilFullFive() {
        velociraptor.setBellyCapacity(5);
        velociraptor.eat();
        velociraptor.eat();
        velociraptor.eat();
        velociraptor.eat();
        velociraptor.eat();
        velociraptor.eat();
        velociraptor.eat();
        velociraptor.eat();
        velociraptor.eat();
        velociraptor.eat();
        assertEquals(5, velociraptor.getBelly().size());
    }

    @Test
    public void canEatVisitor() {
        velociraptor.eatHuman(visitor);
        assertEquals(1, velociraptor.getHumanBelly().size());
        assertEquals(55, velociraptor.getHappiness());
    }

    @Test
    public void parkHasHumanFood() {
        assertTrue(park.getVisitors().get(0) instanceof Visitor);
    }

    @Test
    public void canEatUntilFullOfHumans() {
        velociraptor.setBellyCapacity(5);
        velociraptor.eatHuman(park.getVisitors().get(0));
        velociraptor.eatHuman(park.getVisitors().get(0));
        velociraptor.eatHuman(park.getVisitors().get(0));
        velociraptor.eatHuman(park.getVisitors().get(0));
        velociraptor.eatHuman(park.getVisitors().get(0));
        velociraptor.eatHuman(park.getVisitors().get(0));
        velociraptor.eatHuman(park.getVisitors().get(0));
        velociraptor.eatHuman(park.getVisitors().get(0));
        velociraptor.eatHuman(park.getVisitors().get(0));
        velociraptor.eatHuman(park.getVisitors().get(0));
        assertEquals(5, velociraptor.getHumanBelly().size());
        assertEquals(45, park.getVisitors().size());
        assertTrue(velociraptor.getHumanBelly().get(0) instanceof Visitor);
    }


    @Test
    public void getAttackValue() {
        assertEquals(50, velociraptor.getAttackValue());
    }

//    @Test
//    public void dinosaurHappiness() {
//        assertEquals(true, velociraptor.isDinosaurHappy());
//        velociraptor.setHappiness(0);
//        assertEquals(false, velociraptor.isDinosaurHappy());v
//    }

    @Test
    public void attachPaddock() {
        velociraptor.attackPaddock();
        assertEquals(0, paddock.getHealth());
        assertEquals(0, paddock.dinosaurCount());
    }

    @Test
    public void rampage() {
        velociraptor.setHappiness(0);
        velociraptor.rampage();
        assertEquals(0, paddock.getHealth());
        assertEquals(0, paddock.dinosaurCount());
        assertEquals(0, park.getDinosaursInPark().size());
    }
}
    // check paddocks health is 0
    //check paddock is empty
//        //check dino has left park
//        assertEquals(2, velociraptor.getHumanBelly().size());








