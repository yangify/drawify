package illustrator;

import canvas.Canvas;
import command.Command;
import command.Draw;
import command.Paint;
import org.junit.Assert;
import org.junit.Test;
import sketch.Sketch;
import sketch.line.Line;

import java.util.List;

import static org.junit.Assert.*;
import static illustrator.Illustrator.isExceedCanvas;

public class IllustratorTest {

    @Test
    public void whenExecutingAndCanvasNull_thenThrowException() {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class,
                () -> Illustrator.illustrate(null, null));

        String expectedMessage = "Canvas must not be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenExecutingAndCommandNull_thenThrowException() {
        Canvas canvas = new Canvas(5, 5);
        Exception exception = Assert.assertThrows(IllegalArgumentException.class,
                () -> Illustrator.illustrate(canvas, null));

        String expectedMessage = "Command must not be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenSketchExceedsCanvas_thenReturnTrue() {
        Canvas canvas = new Canvas(5, 5);
        Sketch sketch = new Sketch(List.of("0", "3", "0", "5"));

        assertTrue(isExceedCanvas(canvas, sketch));
    }

    @Test
    public void whenSketchWithinCanvas_thenReturnFalse() {
        Canvas canvas = new Canvas(5, 5);
        Sketch sketch = new Sketch(List.of("1", "3", "1", "4"));

        assertFalse(isExceedCanvas(canvas, sketch));
    }

    @Test
    public void whenCommandDraw_thenDraw() {
        Canvas canvas = new Canvas(5, 5);
        Sketch sketch = new Line(List.of("1", "1", "3", "1"));
        Command command = new Draw(sketch);
        Illustrator.illustrate(canvas, command);

        String expected = "-------\n" +
                "|xxx  |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "-------\n";
        String actual = canvas.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void whenCommandPaint_thenPaint() {
        Canvas canvas = new Canvas(5, 5);
        Command command = new Paint(List.of("1", "1", "o"));
        Illustrator.illustrate(canvas, command);

        String expected = "-------\n" +
                "|ooooo|\n" +
                "|ooooo|\n" +
                "|ooooo|\n" +
                "|ooooo|\n" +
                "|ooooo|\n" +
                "-------\n";
        String actual = canvas.toString();

        assertEquals(expected, actual);
    }
}
