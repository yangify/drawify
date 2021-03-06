package sketch.line;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LineTest {

    @Test
    public void whenPointsLessThan2_thenThrowException() {
        List<String> parameters = List.of("10", "8");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Line(parameters));

        String expected = "Both start and end coordinates required";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void whenPointsMoreThan2_thenThrowException() {
        List<String> parameters = List.of("10", "8", "11", "12", "10", "12");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Line(parameters));

        String expected = "Points provided exceed requirement, only 2 points required";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void whenParametersNotAligned_thenThrowException() {
        List<String> parameters = List.of("10", "8", "11", "12");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Line(parameters));

        String expectedMessage = "Start and end points needs to be aligned either vertically or horizontally";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
