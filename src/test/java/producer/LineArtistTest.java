package producer;

import canvas.Canvas;
import org.junit.Test;
import sketch.line.Line;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LineArtistTest {

    @Test
    public void whenHorizontalLineValid_thenDrawLine() {
        Canvas canvas = new Canvas(3, 3);
        Line line = new Line(List.of("0", "0", "0", "2"));
        LineArtist.draw(canvas, line);

        String expected =
                "-----\n" +
                "|xxx|\n" +
                "|   |\n" +
                "|   |\n" +
                "-----\n";
        String actual = canvas.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void whenVerticalLineValid_thenDrawLine() {
        Canvas canvas = new Canvas(3, 3);
        Line line = new Line(List.of("0", "0", "2", "0"));
        LineArtist.draw(canvas, line);

        String expected =
                "-----\n" +
                "|x  |\n" +
                "|x  |\n" +
                "|x  |\n" +
                "-----\n";
        String actual = canvas.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void whenHorizontalLineExceedsCanvas_thenThrowException() {
        Canvas canvas = new Canvas(3, 3);
        Line line = new Line(List.of("0", "0", "0", "3"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> LineArtist.draw(canvas, line));

        String expectedMessage = "Line exceeds canvas size";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenVerticalLineExceedsCanvas_thenThrowException() {
        Canvas canvas = new Canvas(3, 3);
        Line line = new Line(List.of("0", "0", "3", "0"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> LineArtist.draw(canvas, line));

        String expectedMessage = "Line exceeds canvas size";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
