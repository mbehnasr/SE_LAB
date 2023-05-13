import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JapaneseGardenCreatorTest {


    @Test
    void testType() {

        ;
        assertTrue(new FactoryCreator().createJapaneseGardenCreator() instanceof JapaneseGardenCreator);
    }


}