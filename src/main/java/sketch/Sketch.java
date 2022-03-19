package sketch;

import canvas.Point;
import exception.InvalidParameterException;

import java.util.List;

public class Sketch {

    protected Point p1;
    protected Point p2;

    public Sketch(List<String> parameters) {
        if (parameters == null || parameters.size() < 4)
            throw new InvalidParameterException("Both start and end coordinates required");

        if (parameters.size() > 4)
            throw new InvalidParameterException("Numbers provided exceed requirement, only 2 points required");

        try {
            int x1 = Integer.parseInt(parameters.get(0));
            int y1 = Integer.parseInt(parameters.get(1));
            this.p1 = new Point(x1, y1);

            int x2 = Integer.parseInt(parameters.get(2));
            int y2 = Integer.parseInt(parameters.get(3));
            this.p2 = new Point(x2, y2);

            if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) throw new NumberFormatException();

        } catch (NumberFormatException e) {
            throw new InvalidParameterException("All points must be positive digit");
        }
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
}
