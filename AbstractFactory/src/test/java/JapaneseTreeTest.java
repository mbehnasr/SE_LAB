import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JapaneseTreeTest {
    @Test
    void testType() {
        JapaneseGardenCreator japaneseGardenCreator = new FactoryCreator().createJapaneseGardenCreator();
        ;
        assertTrue(japaneseGardenCreator.createTree() instanceof JapaneseTree);
    }

    @Test
    void testAge() {
        JapaneseGardenCreator japaneseGardenCreator = new FactoryCreator().createJapaneseGardenCreator();

        assertTrue(japaneseGardenCreator.createTree().maxAge == 100);
    }

}