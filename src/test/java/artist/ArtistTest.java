package artist;

import canvas.Canvas;
import org.junit.Assert;
import org.junit.Test;
import sketch.Sketch;

import java.util.List;

import static org.junit.Assert.*;

public class ArtistTest {

    @Test
    public void whenExecutingAndCanvasNull_thenThrowException() {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class,
                () -> Artist.execute(null, null));

        String expectedMessage = "Canvas must not be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenExecutingAndCommandNull_thenThrowException() {
        Canvas canvas = new Canvas(5, 5);
        Exception exception = Assert.assertThrows(IllegalArgumentException.class,
                () -> Artist.execute(canvas, null));

        String expectedMessage = "Command must not be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenSketchExceedsCanvas_thenReturnTrue() {
        Canvas canvas = new Canvas(5, 5);
        Sketch sketch = new Sketch(List.of("0", "3", "0", "5"));

        assertTrue(Artist.isExceedCanvas(canvas, sketch));
    }

    @Test
    public void whenSketchWithinCanvas_thenReturnFalse() {
        Canvas canvas = new Canvas(5, 5);
        Sketch sketch = new Sketch(List.of("0", "3", "0", "4"));

        assertFalse(Artist.isExceedCanvas(canvas, sketch));
    }
}
