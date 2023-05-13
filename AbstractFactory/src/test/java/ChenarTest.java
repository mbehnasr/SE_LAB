import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChenarTest {

    @Test
    void testType() {
        IranianGardenCreator iranianGardenCreator = new FactoryCreator().createIranianGardenCreator();
        assertTrue(iranianGardenCreator.createTree() instanceof Chenar);
    }

    @Test
    void testAge() {
        IranianGardenCreator iranianGardenCreator = new FactoryCreator().createIranianGardenCreator();

        assertTrue(iranianGardenCreator.createTree().maxAge == 50);
    }

}