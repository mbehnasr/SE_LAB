import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

    @Test
    public void computeArea(){
        Shape square = new Square(2);
        double area = square.computeArea();
        assertEquals(4.0, area);
    }
}
