import models.*;
import models.dinosaurs.Diplodocus;
import models.dinosaurs.Stegosaurus;
import models.dinosaurs.Tyrannosaurus;
import models.dinosaurs.Velociraptor;
import models.foods.Meat;
import models.foods.Plant;
import models.humans.ParkStaff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestParkStaff {

    ParkStaff parkStaff;
    Paddock paddock;
    Park park;
    Meat meat;
    Plant plant;
    Velociraptor velociraptor;
    Tyrannosaurus tyrannosaurus;
    Stegosaurus stegosaurus;
    Stegosaurus stegosaurus2;
    Diplodocus diplodocus;

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
        stegosaurus2 = new Stegosaurus("Stig", 700, 400000, 20, park, paddock);
        diplodocus = new Diplodocus("Dip by Dip you Dip", 15000, 1000000, 50, park, paddock);
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
    public void canGenerateFoodAndFindVeg() {
        park.generateFoodStock(20);
        park.buyDinosaur(tyrannosaurus, paddock);
        park.addFoodToParkStock(plant);
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

    @Test
    public void cantAddCarnivoreToOmnivoreEnclosure() {
        parkStaff.transferDinosaur(velociraptor, paddock);
        parkStaff.transferDinosaur(tyrannosaurus, paddock);
        assertEquals(1, paddock.getDinosaursInPaddock().size());
        assertEquals("This dinosaur is a(n) Carnivore, but the paddock is full of Omnivores", parkStaff.transferDinosaur(tyrannosaurus, paddock));
    }

    @Test
    public void cantAddHerbivoreToCarnivoreEnclosure() {
        parkStaff.transferDinosaur(tyrannosaurus, paddock);
        parkStaff.transferDinosaur(stegosaurus, paddock);
        assertEquals(1, paddock.getDinosaursInPaddock().size());
    }

    @Test
    public void canAddDifferentHerbivoresToHerbivoreEnclosure() {
        parkStaff.transferDinosaur(stegosaurus, paddock);
        parkStaff.transferDinosaur(diplodocus, paddock);
        assertEquals(2, paddock.getDinosaursInPaddock().size());
    }

    @Test
    public void canMakeDinosaursHappy() {
        park.buyDinosaur(stegosaurus, paddock);
        park.buyDinosaur(stegosaurus2, paddock);
        parkStaff.calmDinosaursInPadddock(paddock);
        assertEquals(55, paddock.getDinosaursInPaddock().get(0).getHappiness());
        assertEquals(55, paddock.getDinosaursInPaddock().get(1).getHappiness());
    }

    @Test
    public void cantMakeDinosaursHappyPast100() {
        park.buyDinosaur(stegosaurus, paddock);
        park.buyDinosaur(stegosaurus2, paddock);
        parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock); parkStaff.calmDinosaursInPadddock(paddock);
        assertEquals(100, paddock.getDinosaursInPaddock().get(0).getHappiness());
        assertEquals(100, paddock.getDinosaursInPaddock().get(1).getHappiness());
        assertEquals("This dinosaur is already as happy as can be", parkStaff.calmDinosaursInPadddock(paddock));
    }
}
