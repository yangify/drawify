package canvas;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenPointIsSelf_thenReturnTrue() {
        Point p1 = new Point(1, 2);
        assertEquals(p1, p1);
    }

    @Test
    public void whenObjectNotPoint_thenReturnFalse() {
        Point p1 = new Point(1, 2);
        assertFalse(p1.equals("hello"));
    }

    @Test
    public void whenPointIdentical_thenReturnTrue() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertTrue(p1.equals(p2));
    }

    @Test
    public void whenXNotIdentical_thenReturnFalse() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 2);
        assertFalse(p1.equals(p2));
    }

    @Test
    public void whenYNotIdentical_thenReturnFalse() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 1);
        assertFalse(p1.equals(p2));
    }
}
