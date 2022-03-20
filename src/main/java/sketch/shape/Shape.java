package sketch.shape;

import canvas.Point;
import sketch.Sketch;

import java.util.List;

public abstract class Shape extends Sketch {

    protected final Point p1;
    protected final Point p2;

    public Shape(List<String> parameters) {
        super(parameters);
        if (points.size() < 2)
            throw new IllegalArgumentException("Both start and end coordinates required");

        if (points.size() > 2)
            throw new IllegalArgumentException("Numbers provided exceed requirement, only 2 points required");

        this.p1 = points.get(0);
        this.p2 = points.get(1);
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
}
