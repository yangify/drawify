package producer;

import canvas.Canvas;
import command.Draw;
import org.junit.Test;
import sketch.Sketch;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArtistTest {

    @Test
    public void whenSinglePoint_thenDraw() {
        Canvas canvas = new Canvas(3, 3);
        Sketch sketch = new Sketch(List.of("1", "1", "1", "1"));
        Draw draw = new Draw(sketch);
        Artist.draw(canvas, draw);

        String expected = "-----\n" +
                "|   |\n" +
                "| x |\n" +
                "|   |\n" +
                "-----\n";
        String actual = canvas.toString();

        assertEquals(expected, actual);
    }
}
