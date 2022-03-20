package producer;

import canvas.Canvas;
import org.junit.Assert;
import org.junit.Test;
import sketch.shape.Rectangle;
import sketch.shape.Shape;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShapeArtistTest {

    @Test
    public void whenDrawingAndCanvasNull_thenThrowException() {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class,
                () -> ShapeArtist.draw(null, (Shape) null));

        String expectedMessage = "Canvas must not be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenDrawingAndCommandNull_thenThrowException() {
        Canvas canvas = new Canvas(5, 5);
        Exception exception = Assert.assertThrows(IllegalArgumentException.class,
                () -> ShapeArtist.draw(canvas, (Shape) null));

        String expectedMessage = "Shape must not be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenPoint1BottomLeft_thenDraw() {
        Canvas canvas = new Canvas(5, 5);
        Shape shape = new Rectangle(List.of("4", "0", "0", "4"));
        ShapeArtist.draw(canvas, shape);

        String expected = "-------\n" +
                "|xxxxx|\n" +
                "|x   x|\n" +
                "|x   x|\n" +
                "|x   x|\n" +
                "|xxxxx|\n" +
                "-------\n";
        String actual = canvas.toString();
        assertEquals(expected, actual);

    }
    @Test
    public void whenPoint1TopRight_thenDraw() {
        Canvas canvas = new Canvas(5, 5);
        Shape shape = new Rectangle(List.of("0", "4", "4", "0"));
        ShapeArtist.draw(canvas, shape);

        String expected = "-------\n" +
                "|xxxxx|\n" +
                "|x   x|\n" +
                "|x   x|\n" +
                "|x   x|\n" +
                "|xxxxx|\n" +
                "-------\n";
        String actual = canvas.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void whenPoint1TopLeft_thenDraw() {
        Canvas canvas = new Canvas(5, 5);
        Shape shape = new Rectangle(List.of("0", "0", "4", "4"));
        ShapeArtist.draw(canvas, shape);

        String expected = "-------\n" +
                "|xxxxx|\n" +
                "|x   x|\n" +
                "|x   x|\n" +
                "|x   x|\n" +
                "|xxxxx|\n" +
                "-------\n";
        String actual = canvas.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void whenPoint1BottomRight_thenDraw() {
        Canvas canvas = new Canvas(5, 5);
        Shape shape = new Rectangle(List.of("4", "4", "0", "0"));
        ShapeArtist.draw(canvas, shape);

        String expected = "-------\n" +
                "|xxxxx|\n" +
                "|x   x|\n" +
                "|x   x|\n" +
                "|x   x|\n" +
                "|xxxxx|\n" +
                "-------\n";
        String actual = canvas.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void whenSinglePoint_thenDraw() {
        Canvas canvas = new Canvas(1, 1);
        Shape shape = new Rectangle(List.of("0", "0", "0", "0"));
        ShapeArtist.draw(canvas, shape);

        String expected = "---\n" +
                "|x|\n" +
                "---\n";
        String actual = canvas.toString();
        assertEquals(expected, actual);
    }
}
