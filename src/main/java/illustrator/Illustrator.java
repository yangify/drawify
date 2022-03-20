package illustrator;

import canvas.Canvas;
import canvas.Point;
import command.Command;
import command.Draw;
import command.Paint;
import sketch.Sketch;

public class Illustrator {

    public static void illustrate(Canvas canvas, Command command) {
        if (canvas == null) throw new IllegalArgumentException("Canvas must not be null");
        if (command == null) throw new IllegalArgumentException("Command must not be null");

        if (command instanceof Draw) Artist.draw(canvas, ((Draw) command).getSketch());
        if (command instanceof Paint) Painter.paint(canvas, ((Paint) command).getPoint(), ((Paint) command).getValue());
    }

    protected static boolean isExceedCanvas(Canvas canvas, Sketch sketch) {
        Point[] points =  new Point[]{sketch.getP1(), sketch.getP2()};
        for (Point point : points) {
            if (isExceedCanvas(canvas, point)) return true;
        }
        return false;
    }

    protected static boolean isExceedCanvas(Canvas canvas, Point point) {
        int x = point.getX();
        int y = point.getY();
        return x < 0 || x >= canvas.getWidth() || y < 0 || y >= canvas.getHeight();
    }
}
