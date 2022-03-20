package producer;

import canvas.Canvas;
import canvas.Point;
import sketch.line.Line;

public class LineArtist implements Artist {

    static void draw(Canvas canvas, Line line) {
        Point p1 = line.getP1();
        Point p2 = line.getP2();
        if (Producer.isExceedCanvas(canvas, line)) throw new IllegalArgumentException("Line exceeds canvas size");

        if (p1.getX() == p2.getX()) {
            Point start = p1.getY() < p2.getY() ? p1 : p2;
            Point end = p1.getY() > p2.getY() ? p1 : p2;
            drawHorizontalLine(canvas, start, end);
        }

        if (p1.getY() == p2.getY()) {
            Point start = p1.getX() < p2.getX() ? p1 : p2;
            Point end = p1.getX() > p2.getX() ? p1 : p2;
            drawVerticalLine(canvas, start, end);
        }

        canvas.print();
    }

    private static void drawHorizontalLine(Canvas canvas, Point start, Point end) {
        int x = start.getX();
        for (int y = start.getY(); y <= end.getY(); y++) {
            canvas.setPoint(new Point(x, y), VALUE);
        }
    }

    private static void drawVerticalLine(Canvas canvas, Point start, Point end) {
        int y = start.getY();
        for (int x = start.getX(); x <= end.getX(); x++) {
            canvas.setPoint(new Point(x, y), VALUE);
        }
    }
}
