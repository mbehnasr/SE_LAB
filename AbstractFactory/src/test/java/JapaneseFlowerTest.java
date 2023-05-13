import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JapaneseFlowerTest {

    @Test
    void testType() {
        JapaneseGardenCreator japaneseGardenCreator = new FactoryCreator().createJapaneseGardenCreator();
        ;
        assertTrue(japaneseGardenCreator.createFlower() instanceof JapaneseFlower);
    }

    @Test
    void testLocation() {
        JapaneseGardenCreator japaneseGardenCreator = new FactoryCreator().createJapaneseGardenCreator();
        ;
        assertSame("Japan", japaneseGardenCreator.createFlower().location);
    }

}