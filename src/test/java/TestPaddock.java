import models.*;
import models.dinosaurs.Stegosaurus;
import models.dinosaurs.Velociraptor;
import models.foods.Meat;
import models.foods.Plant;
import models.humans.Human;
import models.humans.ParkStaff;
import models.humans.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestPaddock {

    Meat meat;
    ParkStaff parkStaff;
    Paddock paddock;
    Park park;
    Velociraptor velociraptor;
    Visitor visitor;
    Visitor visitor2;
    Stegosaurus stegosaurus;

    @Before
    public void setUp() throws Exception {
        meat = new Meat();
        park = new Park("Dino Park");
        paddock = new Paddock("Velo Pen", 4, park);
        velociraptor = new Velociraptor("Swifty", 10, 500000, 5, park, paddock);
        stegosaurus = new Stegosaurus("Robert", 700, 400000, 20, park, paddock);
        visitor = new Visitor("randgen", 2000, park);
        visitor2 = new Visitor(visitor.randName(), visitor.randWallet(), park);
        parkStaff = new ParkStaff(visitor.randName(), visitor.randWallet(), park);
        park.generateFoodStock(100);
        parkStaff.transferDinosaur(stegosaurus, paddock);
    }

    @Test
    public void PaddockHasThreeFoodItemsOfCorrectType() {
        parkStaff.addFoodToStore(paddock);
        parkStaff.addFoodToStore(paddock);
        parkStaff.addFoodToStore(paddock);
        assertEquals(3, paddock.getFoodStore().size());
        assertTrue(paddock.getFoodStore().get(0) instanceof Plant);
        assertTrue(paddock.getFoodStore().get(1) instanceof Plant);
        assertTrue(paddock.getFoodStore().get(2) instanceof Plant);
    }

    @Test
    public void WhenFoodIsEatenItIsRemoved() {
        parkStaff.addFoodToStore(paddock);
        stegosaurus.eat();
        assertEquals(0, paddock.getFoodStore().size());
    }

    @Test
    public void emptyPaddock() {
        paddock.addDinosaurToPaddock(velociraptor);
        paddock.setHealth(0);
        paddock.emptyPaddock();
        assertEquals(0, paddock.dinosaurCount());
    }
}


//    public void emptyPaddock(){
//        if(this.health == 0){
//            this.dinosaursInPaddock.clear();
//        }
//}