import models.DinoFactory;
import models.Paddock;
import models.Park;
import models.dinosaurs.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestDinoFactory {

    DinoFactory dinoFactory;

    Park park;
    Paddock paddock;

    @Before
    public void setUp() throws Exception {
        dinoFactory = new DinoFactory();
        park = new Park("DinoClan");
        paddock = new Paddock("AnyPen", 1, park);
    }

    @Test
    public void dinoFactoryMakesVelociraptor() {
        Dinosaur velociraptor = dinoFactory.makeDinosaur("Velociraptor", "Tyrant", 15, 500000, 5, park, paddock);
        assertTrue(velociraptor.getClass() ==  Velociraptor.class);
    }

    @Test
    public void dinoFactoryMakesTyrannosaurus() {
        Dinosaur trex = dinoFactory.makeDinosaur("Tyrannosaurus", "Tyrant", 15, 500000, 5, park, paddock);
        assertTrue(trex.getClass() ==  Tyrannosaurus.class);
    }

    @Test
    public void dinoFactoryMakesDiplodocus() {
        Dinosaur diplo = dinoFactory.makeDinosaur("Diplodocus", "Tyrant", 15, 500000, 5, park, paddock);
        assertTrue(diplo.getClass() ==  Diplodocus.class);
    }

    @Test
    public void dinoFactoryMakesStegosaurus() {
        Dinosaur stego = dinoFactory.makeDinosaur("Stegosaurus", "Tyrant", 15, 500000, 5, park, paddock);
        assertTrue(stego.getClass() ==  Stegosaurus.class);
    }





}
