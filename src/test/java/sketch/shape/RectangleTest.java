package sketch.shape;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RectangleTest {

    @Test
    public void whenPointsLessThan2_thenThrowException() {
        List<String> parameters = List.of("10", "8");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Rectangle(parameters));

        String expected = "Both start and end coordinates required";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void whenPointsMoreThan2_thenThrowException() {
        List<String> parameters = List.of("10", "8", "11", "12", "10", "12");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Rectangle(parameters));

        String expected = "Points provided exceed requirement, only 2 points required";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }
}
