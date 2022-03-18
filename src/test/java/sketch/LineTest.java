package sketch;

import canvas.Point;
import exception.InvalidParameterException;
import org.junit.Test;
import sketch.line.Line;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LineTest {

    @Test
    public void whenParameterIsNull_thenThrowException() {
        List<String> parameters = null;
        Exception exception = assertThrows(InvalidParameterException.class, () -> new Line(parameters));

        String expectedMessage = "Both start and end coordinates required";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsInsufficient_thenThrowException() {
        List<String> parameters = List.of("10 10");
        Exception exception = assertThrows(InvalidParameterException.class, () -> new Line(parameters));

        String expectedMessage = "Both start and end coordinates required";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsWord_thenThrowException() {
        List<String> parameters = List.of("10", "eight", "15", "15");
        Exception exception = assertThrows(InvalidParameterException.class, () -> new Line(parameters));

        String expectedMessage = "Both start and end coordinates must be positive digit";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsNegative_thenThrowException() {
        List<String> parameters = List.of("10", "-8", "11", "12");
        Exception exception = assertThrows(InvalidParameterException.class, () -> new Line(parameters));

        String expectedMessage = "Both start and end coordinates must be positive digit";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsNotAligned_thenThrowException() {
        List<String> parameters = List.of("10", "8", "11", "12");
        Exception exception = assertThrows(InvalidParameterException.class, () -> new Line(parameters));

        String expectedMessage = "Start and end points needs to be aligned either vertically or horizontally";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsValid_thenReturnLine() {
        List<String> parameters = List.of("10", "8", "10", "3");
        Line line = new Line(parameters);

        Point expectedStart = new Point(10, 8);
        Point actualStart = line.getStart();
        assertEquals(expectedStart, actualStart);

        Point expectedEnd = new Point(10, 3);
        Point actualEnd = line.getEnd();
        assertEquals(expectedEnd, actualEnd);
    }
}
