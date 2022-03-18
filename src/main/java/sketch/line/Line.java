package sketch.line;

import exception.InvalidParameterException;
import sketch.Sketch;

import java.util.List;

public class Line extends Sketch {

    public Line(List<String> parameters) {
        super(parameters);

        if (start.getX() != end.getX() && start.getY() != end.getY())
            throw new InvalidParameterException("Start and end points needs to be aligned either vertically or horizontally");
    }
}
