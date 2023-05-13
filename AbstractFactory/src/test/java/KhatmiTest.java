import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KhatmiTest {

    @Test
    void testType() {
        IranianGardenCreator iranianGardenCreator = new FactoryCreator().createIranianGardenCreator();
        ;
        assertTrue(iranianGardenCreator.createFlower() instanceof Khatmi);
    }

    @Test
    void testLocation() {
        IranianGardenCreator iranianGardenCreator = new FactoryCreator().createIranianGardenCreator();
        ;
        assertSame("Iran", iranianGardenCreator.createFlower().location);
    }

}