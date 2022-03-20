package command;

import canvas.Point;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class PaintTest {

    @Test
    public void whenParameterIsNull_thenThrowException() {
        List<String> parameters = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Paint(parameters));

        String expectedMessage = "Both x and y is required";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsInsufficient_thenThrowException() {
        List<String> parameters = List.of("10");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Paint(parameters));

        String expectedMessage = "Both x and y is required";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsWord_thenThrowException() {
        List<String> parameters = List.of("ten", "eight");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Paint(parameters));

        String expectedMessage = "Both x and y must be positive digit";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsNegative_thenThrowException() {
        List<String> parameters = List.of("-10", "8");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Paint(parameters));

        String expectedMessage = "Both x and y must be positive digit";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsValid_thenReturnCreate() {
        List<String> parameters = List.of("10", "100");
        Paint paint = new Paint(parameters);

        Point expectedPoint = new Point(10, 100);
        Point actualPoint = paint.getPoint();
        assertEquals(expectedPoint, actualPoint);
    }
}
