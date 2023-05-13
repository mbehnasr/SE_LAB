import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClone {

    @Test
    void testClone() {

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "blue";

        Circle circleClone = (Circle) circle.clone();

        assertEquals(circleClone, circle);
        assertEquals(circleClone.radius, circle.radius);
        assertEquals(circleClone.x, circle.x);
        assertEquals(circleClone.y, circle.y);
        assertEquals(circleClone.color, circle.color);
    }
}