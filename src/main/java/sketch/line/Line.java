package sketch.line;

import canvas.Point;
import exception.InvalidParameterException;
import sketch.Sketch;

import java.util.List;

public class Line implements Sketch {

    private final Point start;
    private final Point end;

    public Line(List<String> parameters) {
        if (parameters == null || parameters.size() < 4)
            throw new InvalidParameterException("Both start and end coordinates required");

        try {
            int startX = Integer.parseInt(parameters.get(0));
            int startY = Integer.parseInt(parameters.get(1));
            this.start = new Point(startX, startY);

            int endX = Integer.parseInt(parameters.get(2));
            int endY = Integer.parseInt(parameters.get(3));
            this.end = new Point(endX, endY);

            if (startX < 0 || startY < 0 || endX < 0 || endY < 0) throw new NumberFormatException();

        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Both start and end coordinates must be positive digit");
        }

        if (start.getX() != end.getX() && start.getY() != end.getY())
            throw new InvalidParameterException("Start and end points needs to be aligned either vertically or horizontally");
    }

    public Point getStart() {
        return this.start;
    }

    public Point getEnd() {
        return this.end;
    }
}
