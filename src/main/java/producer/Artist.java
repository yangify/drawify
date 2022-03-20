package producer;

import canvas.Canvas;
import canvas.Point;
import sketch.Sketch;
import sketch.line.Line;
import sketch.shape.Shape;

public class Artist {

    static String VALUE = "x";

    static void draw(Canvas canvas, Sketch sketch) {
        if (canvas == null) throw new IllegalArgumentException("Canvas must not be null");
        if (sketch == null) throw new IllegalArgumentException("Sketch must not be null");

        delegate(canvas, sketch);
    }

    private static void delegate(Canvas canvas, Sketch sketch) {
        if (sketch instanceof Line) LineArtist.draw(canvas, (Line) sketch);
        if (sketch instanceof Shape) ShapeArtist.draw(canvas, (Shape) sketch);
    }

    static boolean isExceedCanvas(Canvas canvas, Sketch sketch) {
        Point[] points =  new Point[]{sketch.getP1(), sketch.getP2()};
        for (Point point : points) {
            if (isExceedCanvas(canvas, point)) return true;
        }
        return false;
    }

    static boolean isExceedCanvas(Canvas canvas, Point point) {
        int x = point.getX();
        int y = point.getY();
        return x < 0 || x >= canvas.getWidth() || y < 0 || y >= canvas.getHeight();
    }
}
