package producer;

import canvas.Canvas;
import canvas.Point;
import command.Draw;
import sketch.Sketch;
import sketch.line.Line;
import sketch.shape.Shape;

public class Artist {

    static String VALUE = "x";

    static void draw(Canvas canvas, Draw command) {
        if (canvas == null) throw new IllegalArgumentException("Canvas must not be null");
        if (command == null) throw new IllegalArgumentException("Command must not be null");

        Sketch sketch = command.getSketch();
        delegate(canvas, sketch);
    }

    private static void delegate(Canvas canvas, Sketch sketch) {
        if (sketch instanceof Line) LineArtist.draw(canvas, (Line) sketch);
        if (sketch instanceof Shape) ShapeArtist.draw(canvas, (Shape) sketch);
    }

    static boolean isExceedCanvas(Canvas canvas, Sketch sketch) {
        int rows = canvas.getWidth();
        int cols = canvas.getHeight();

        Point[] points =  new Point[]{sketch.getP1(), sketch.getP2()};
        for (Point point : points) {
            int x = point.getX();
            int y = point.getY();
            if (x < 0 || x >= rows || y < 0 || y >= cols) return true;
        }

        return false;
    }
}
