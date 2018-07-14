import models.Park;
import models.humans.Visitor;
import models.RandomGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RandomGeneratorTest {

    RandomGenerator randomGenerator;
    Park park;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {

        park = new Park("DinoClan");
        visitor = new Visitor("Mr Dino Lover", 100, park);
        randomGenerator = new RandomGenerator(visitor, park);

    }

    @Test
    public void canGenerateVisitor() {
       Visitor generatedVisitor = randomGenerator.generateVisitor();
       assertNotNull(generatedVisitor.getName());
       assertTrue(visitor.randWallet() >= 2000);
    }

    @Test
    public void canGenerateFiftyVisitors() {
        ArrayList<Visitor> generatedVisitors = randomGenerator.generateMultipleVisitors(50);
        assertEquals(50, generatedVisitors.size());
    }

    @Test
    public void generatingVisitorsAddsTicketRevenue(){
        randomGenerator.generateMultipleVisitors(50);
        assertEquals(200050000, park.getTill());
    }

    @Test
    public void generatedVisitorsAreInThePark() {
        randomGenerator.generateMultipleVisitors(50);
        assertEquals(50, park.getVisitors().size());
    }

    @Test
    public void generatedVisitorsHaveReducedWallet() {
        randomGenerator.generateMultipleVisitors(50);
        assertTrue(visitor.getWallet() <= 2000);
    }
}
