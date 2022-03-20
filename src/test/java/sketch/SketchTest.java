package sketch;

import canvas.Point;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class SketchTest {

    @Test
    public void whenParameterIsNull_thenThrowException() {
        List<String> parameters = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Sketch(parameters));

        String expectedMessage = "Parameters cannot be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsInsufficient_thenThrowException() {
        List<String> parameters = List.of("10");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Sketch(parameters));

        String expectedMessage = "All points must come in pair";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsWord_thenThrowException() {
        List<String> parameters = List.of("10", "eight", "15", "15");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Sketch(parameters));

        String expectedMessage = "All points must be digit";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsValid_thenReturnLine() {
        List<String> parameters = List.of("10", "8", "10", "3");
        Sketch sketch = new Sketch(parameters);

        List<Point> expected = List.of(new Point(9, 7), new Point(9, 2));
        List<Point> actual = sketch.getPoints();
        assertEquals(expected, actual);
    }
}
