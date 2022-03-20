package canvas;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenPointIdentical_thenReturnTrue() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertEquals(p1, p2);
    }

    @Test
    public void whenPointBefore_thenReturnTrue() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 3);
        assertTrue(p1.isBefore(p2));

        Point p3 = new Point(1, 3);
        assertTrue(p1.isBefore(p3));

        Point p4 = new Point(2, 2);
        assertTrue(p1.isBefore(p4));
    }

    @Test
    public void whenPointNotBefore_thenReturnFalse() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(1, 2);
        assertFalse(p1.isBefore(p2));

        Point p3 = new Point(1, 3);
        assertFalse(p1.isBefore(p3));

        Point p4 = new Point(2, 2);
        assertFalse(p1.isBefore(p4));
    }

    @Test
    public void whenPointOverlaps_thenReturnFalse() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertFalse(p2.isBefore(p1));
    }
}
