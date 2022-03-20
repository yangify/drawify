package sketch.line;

import canvas.Point;
import sketch.Sketch;

import java.util.List;

public class Line extends Sketch {

    public Line(List<String> parameters) {
        super(parameters);

        if (isNotAligned(p1, p2))
            throw new IllegalArgumentException("Start and end points needs to be aligned either vertically or horizontally");
    }

    public Line(Point p1, Point p2) {
        super(p1, p2);
    }

    private boolean isNotAligned(Point p1, Point p2) {
        return p1.getX() != p2.getX() && p1.getY() != p2.getY();
    }
}
