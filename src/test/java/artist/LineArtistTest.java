package artist;

import canvas.Canvas;
import command.Draw;
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
        Draw draw = new Draw(line);
        LineArtist.draw(canvas, draw);

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
        Draw draw = new Draw(line);
        LineArtist.draw(canvas, draw);

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
        Draw draw = new Draw(line);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> LineArtist.draw(canvas, draw));

        String expectedMessage = "Line exceeds canvas size";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenVerticalLineExceedsCanvas_thenThrowException() {
        Canvas canvas = new Canvas(3, 3);
        Line line = new Line(List.of("0", "0", "3", "0"));
        Draw draw = new Draw(line);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> LineArtist.draw(canvas, draw));

        String expectedMessage = "Line exceeds canvas size";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
