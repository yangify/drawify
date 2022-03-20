package sketch.line;

import canvas.Point;
import sketch.Sketch;

import java.util.List;

public class Line extends Sketch {

    protected final Point p1;
    protected final Point p2;

    public Line(List<String> parameters) {
        super(parameters);
        if (points.size() < 2)
            throw new IllegalArgumentException("Both start and end coordinates required");

        if (points.size() > 2)
            throw new IllegalArgumentException("Points provided exceed requirement, only 2 points required");

        this.p1 = points.get(0);
        this.p2 = points.get(1);

        if (isNotAligned())
            throw new IllegalArgumentException("Start and end points needs to be aligned either vertically or horizontally");
    }

    public Line(Point p1, Point p2) {
        super(new Point[]{p1, p2});
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return this.p1;
    }

    public Point getP2() {
        return this.p2;
    }

    private boolean isNotAligned() {
        return p1.getX() != p2.getX() && p1.getY() != p2.getY();
    }
}
