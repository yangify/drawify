package illustrator;

import canvas.Canvas;
import canvas.Point;
import org.junit.Test;
import sketch.line.Line;
import sketch.shape.Rectangle;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PainterTest {

    @Test
    public void whenNoObstacle_thenPaintAll() {
        Canvas canvas = new Canvas(5, 5);
        Point point = new Point(2, 2);
        Painter.paint(canvas, point, "o");

        String expected = "-------\n" +
                "|ooooo|\n" +
                "|ooooo|\n" +
                "|ooooo|\n" +
                "|ooooo|\n" +
                "|ooooo|\n" +
                "-------\n";
        String actual = canvas.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void whenObstacleAndOutside_thenPaintAround() {
        Canvas canvas = new Canvas(5, 5);
        ShapeArtist.draw(canvas, new Rectangle(List.of("1", "1", "3", "3")));
        Point point = new Point(4, 4);
        Painter.paint(canvas, point, "o");

        String expected = "-------\n" +
                "|xxxoo|\n" +
                "|x xoo|\n" +
                "|xxxoo|\n" +
                "|ooooo|\n" +
                "|ooooo|\n" +
                "-------\n";
        String actual = canvas.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void whenObstacleAndInside_thenPaintWithin() {
        Canvas canvas = new Canvas(5, 5);
        ShapeArtist.draw(canvas, new Rectangle(List.of("1", "1", "3", "3")));
        LineArtist.draw(canvas, new Line(List.of("4", "4", "4", "5")));

        Point point1 = new Point(1, 1);
        Painter.paint(canvas, point1, "o");

        Point point2 = new Point(0, 3);
        Painter.paint(canvas, point2, "o");

        String expected = "-------\n" +
                "|xxx  |\n" +
                "|xox  |\n" +
                "|xxx  |\n" +
                "|ooox |\n" +
                "|ooox |\n" +
                "-------\n";
        String actual = canvas.toString();

        assertEquals(expected, actual);
    }
}
