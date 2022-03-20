package artist;

import canvas.Canvas;
import canvas.Point;
import command.Command;
import command.Draw;
import sketch.Sketch;

public interface Artist {

    String VALUE = "x";

    static void execute(Canvas canvas, Command command) {
        if (canvas == null) throw new IllegalArgumentException("Canvas must not be null");
        if (command == null) throw new IllegalArgumentException("Command must not be null");

        if (command instanceof Draw) LineArtist.draw(canvas, (Draw) command);
    }

    static boolean isExceedCanvas(Canvas canvas, Sketch sketch) {
        int rows = canvas.getRows();
        int cols = canvas.getColumns();

        Point[] points =  new Point[]{sketch.getP1(), sketch.getP2()};
        for (Point point : points) {
            int x = point.getX();
            int y = point.getY();
            if (x < 0 || x >= rows || y < 0 || y >= cols) return true;
        }

        return false;
    }
}
