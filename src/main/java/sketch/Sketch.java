package sketch;

import canvas.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sketch {

    protected List<Point> points;

    public Sketch(List<String> parameters) {
        if (parameters == null) throw new IllegalArgumentException("Parameters cannot be null");
        if (parameters.isEmpty()) throw new IllegalArgumentException("Parameters cannot be empty");
        this.points = new ArrayList<>();

        try {
            for (int i = 0; i < parameters.size(); i+=2) {
                int x = Integer.parseInt(parameters.get(i)) - 1;
                int y = Integer.parseInt(parameters.get(i + 1)) - 1;
                points.add(new Point(x, y));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("All points must be digit");
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("All points must come in pair");
        }
    }

    public Sketch(Point[] points) {
        this.points = Arrays.asList(points);
    }

    public List<Point> getPoints() {
        return this.points;
    }
}
