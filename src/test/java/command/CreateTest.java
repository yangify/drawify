package command;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CreateTest {

    @Test
    public void whenParameterIsNull_thenThrowException() {
        List<String> parameters = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Create(parameters));

        String expectedMessage = "Both row and column is required";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsInsufficient_thenThrowException() {
        List<String> parameters = List.of("10");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Create(parameters));

        String expectedMessage = "Both row and column is required";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsWord_thenThrowException() {
        List<String> parameters = List.of("ten", "eight");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Create(parameters));

        String expectedMessage = "Both row and column must be positive digit";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenWidthIsNegative_thenThrowException() {
        List<String> parameters = List.of("-10", "8");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Create(parameters));

        String expectedMessage = "Both row and column must be positive digit";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenHeightIsNegative_thenThrowException() {
        List<String> parameters = List.of("10", "-8");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Create(parameters));

        String expectedMessage = "Both row and column must be positive digit";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenParameterIsValid_thenReturnCreate() {
        List<String> parameters = List.of("10", "100");
        Create create = new Create(parameters);

        int expectedRows = 10;
        int actualRows = create.getWidth();
        assertEquals(expectedRows, actualRows);

        int expectedColumns = 100;
        int actualColumns = create.getHeight();
        assertEquals(expectedColumns, actualColumns);
    }
}
