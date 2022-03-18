package canvas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void whenPointIdentical_thenReturnTrue() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertEquals(p1, p2);
    }
}
