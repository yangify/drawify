package illustrator;

import canvas.Canvas;
import org.junit.Assert;
import org.junit.Test;
import sketch.Sketch;
import sketch.line.Line;
import sketch.shape.Rectangle;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArtistTest {

    @Test
    public void whenDrawingAndCanvasNull_thenThrowException() {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class,
                () -> Artist.draw(null, null));

        String expectedMessage = "Canvas must not be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenDrawingAndCommandNull_thenThrowException() {
        Canvas canvas = new Canvas(5, 5);
        Exception exception = Assert.assertThrows(IllegalArgumentException.class,
                () -> Artist.draw(canvas, null));

        String expectedMessage = "Sketch must not be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenSketchLine_thenDrawLine() {
        Canvas canvas = new Canvas(5, 5);
        Sketch sketch = new Line(List.of("1", "1", "1", "5"));
        Artist.draw(canvas, sketch);

        String expected = "-------\n" +
                "|x    |\n" +
                "|x    |\n" +
                "|x    |\n" +
                "|x    |\n" +
                "|x    |\n" +
                "-------\n";
        String actual = canvas.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void whenSketchShape_thenDrawShape() {
        Canvas canvas = new Canvas(5, 5);
        Sketch sketch = new Rectangle(List.of("1", "1", "5", "5"));
        Artist.draw(canvas, sketch);

        String expected = "-------\n" +
                "|xxxxx|\n" +
                "|x   x|\n" +
                "|x   x|\n" +
                "|x   x|\n" +
                "|xxxxx|\n" +
                "-------\n";
        String actual = canvas.toString();

        assertEquals(expected, actual);
    }
}
