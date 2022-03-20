package factory;

import canvas.Canvas;
import command.Create;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CanvasFactoryTest {

    @Test
    public void whenCreateCommandNull_thenThrowException() {
        Create command = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> CanvasFactory.execute(command));

        String expectedMessage = "Create command is null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenCommandValid_thenReturnCanvas() {
        Create command = new Create(List.of("10", "8"));
        Canvas canvas = CanvasFactory.execute(command);
        assertNotNull(canvas);

        String expected = "------------\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "------------\n";
        String actual = canvas.toString();

        assertEquals(expected, actual);
    }
}
