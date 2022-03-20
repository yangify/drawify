package sketch;

import canvas.Point;

import java.util.List;

public class Sketch {

    protected Point p1;
    protected Point p2;

    public Sketch(List<String> parameters) {
        if (parameters == null || parameters.size() < 4)
            throw new IllegalArgumentException("Both start and end coordinates required");

        if (parameters.size() > 4)
            throw new IllegalArgumentException("Numbers provided exceed requirement, only 2 points required");

        try {
            int x1 = Integer.parseInt(parameters.get(0)) - 1;
            int y1 = Integer.parseInt(parameters.get(1)) - 1;
            this.p1 = new Point(x1, y1);

            int x2 = Integer.parseInt(parameters.get(2)) - 1;
            int y2 = Integer.parseInt(parameters.get(3)) - 1;
            this.p2 = new Point(x2, y2);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("All points must be digit");
        }
    }

    public Sketch(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
}
