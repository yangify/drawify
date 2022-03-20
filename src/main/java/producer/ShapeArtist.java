package producer;

import canvas.Canvas;
import canvas.Point;
import sketch.line.Line;
import sketch.shape.Rectangle;
import sketch.shape.Shape;

import java.util.List;

public class ShapeArtist extends Artist{

    static void draw(Canvas canvas, Shape shape) {
        if (canvas == null) throw new IllegalArgumentException("Canvas must not be null");
        if (shape == null) throw new IllegalArgumentException("Shape must not be null");
        if (isExceedCanvas(canvas, shape)) throw new IllegalArgumentException("Shape exceeds out of canvas");

        if (shape instanceof Rectangle) drawRectangle(canvas, (Rectangle) shape);
    }

    private static void drawRectangle(Canvas canvas, Rectangle rectangle) {

        Point p1 = rectangle.getP1();
        Point p2 = rectangle.getP2();

        int startX = Math.min(p1.getX(), p2.getX());
        int endX = Math.max(p1.getX(), p2.getX());

        int startY = Math.min(p1.getY(), p2.getY());
        int endY = Math.max(p1.getY(), p2.getY());

        Line horizontalLine1 = new Line(new Point(p1.getX(), startY), new Point(p1.getX(), endY));
        Line horizontalLine2 = new Line(new Point(p2.getX(), startY), new Point(p2.getX(), endY));

        Line verticalLine1 = new Line(new Point(startX, p1.getY()), new Point(endX, p1.getY()));
        Line verticalLine2 = new Line(new Point(startX, p2.getY()), new Point(endX, p2.getY()));

        for (Line line : List.of(horizontalLine1, horizontalLine2, verticalLine1, verticalLine2)) {
            LineArtist.draw(canvas, line);
        }

//        // top and bottom
//        for (int y = startY; y <= endY; y++) {
//            canvas.setPoint(new Point(p1.getX(), y), VALUE);
//            canvas.setPoint(new Point(p2.getX(), y), VALUE);
//        }
//
//        // left and right
//        for (int x = startX; x <= endX; x++) {
//            canvas.setPoint(new Point(x, p1.getY()), VALUE);
//            canvas.setPoint(new Point(x, p2.getY()), VALUE);
//        }
    }
}
