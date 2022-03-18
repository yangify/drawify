package canvas;

import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasTest {

    @Test
    public void whenInitializingAndParameterNegative_thenThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Canvas(-1, 10));

        String expectedMessage = "Rows and columns must be positive";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenInitializingAndParameterValid_thenReturnCanvas() {
        Canvas canvas = new Canvas(2, 2);
        assertNotNull(canvas);
    }

    @Test
    public void whenInitializingAndParameterValid_thenReturnValidRows() {
        Canvas canvas = new Canvas(2, 2);
        int expectedRows = canvas.getRows();
        int actualRows = 2;
        assertEquals(expectedRows, actualRows);
    }

    @Test
    public void whenInitializingAndParameterValid_thenReturnValidColumns() {
        Canvas canvas = new Canvas(2, 2);
        int expectedCols = canvas.getColumns();
        int actualCols = canvas.getColumns();
        assertEquals(expectedCols, actualCols);
    }

    @Test
    public void whenValidatingPointAndXNegative_thenThrowException() {
        Canvas canvas = new Canvas(2, 2);
        Point point = new Point(-1, 1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> canvas.validatePoint(point));

        String expectedMessage = "x should be positive";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenValidatingPointAndXExceeds_thenThrowException() {
        Canvas canvas = new Canvas(2, 2);
        Point point = new Point(2, 1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> canvas.validatePoint(point));

        String expectedMessage = "x should be less than 2";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenValidatingPointAndYNegative_thenThrowException() {
        Canvas canvas = new Canvas(2, 2);
        Point point = new Point(1, -1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> canvas.validatePoint(point));

        String expectedMessage = "y should be positive";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenValidatingPointAndYExceeds_thenThrowException() {
        Canvas canvas = new Canvas(2, 2);
        Point point = new Point(1, 2);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> canvas.validatePoint(point));

        String expectedMessage = "y should be less than 2";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenGettingPointAndPointValid_theReturnValue() {
        Canvas canvas = new Canvas(2, 2);
        Point point = new Point(1, 1);

        String expected = " ";
        String actual = canvas.getPoint(point);

        assertEquals(expected, actual);
    }

    @Test
    public void whenSettingPointAndPointValid_thenMarkPoint() {
        Canvas canvas = new Canvas(2, 2);
        Point point = new Point(1, 1);
        canvas.setPoint(point, "x");

        String expected = "x";
        String actual = canvas.getPoint(point);

        assertEquals(expected, actual);
    }

    @Test
    public void whenParameterValid_thenProduceValidString() {
        Canvas canvas = new Canvas(2, 2);
        String expected =
                "----\n" +
                "|  |\n" +
                "|  |\n" +
                "----\n";
        String actual = canvas.toString();
        assertEquals(expected, actual);
    }
}
