package command;

import exception.InvalidParameterException;
import org.junit.Test;
import sketch.Sketch;
import sketch.line.Line;

import java.util.List;

import static org.junit.Assert.*;

public class DrawTest {

    @Test
    public void whenParameterIsNull_thenThrowException() {
        Sketch sketch = null;
        Exception exception = assertThrows(InvalidParameterException.class, () -> new Draw(sketch));

        String expectedMessage = "Sketch must not be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsValid_thenReturnFraw() {
        Line line = new Line(List.of("10", "8", "10", "9"));
        Draw draw = new Draw(line);
        assertNotNull(draw.getSketch());
    }
}
