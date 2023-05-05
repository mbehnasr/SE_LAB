import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;


public class RectangleTest {

    @Test
    void computeArea(){
        Rectangle rectangle = new Rectangle(2,6);
        double area = rectangle.computeArea();
        assertEquals(12.0, area);
    }

    @Test
    void setSides(){
        Rectangle rectangle = new Rectangle(4, 10);
        assertEquals(40.0, rectangle.computeArea());
        rectangle.setHeight(3);
        assertEquals(12.0, rectangle.computeArea());
        rectangle.setWidth(4);
        assertEquals(20.0, rectangle.computeArea());
    }
}
