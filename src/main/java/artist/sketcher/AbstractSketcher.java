package artist.sketcher;

import canvas.Canvas;
import line.Line;
import shape.Shape;

public abstract class AbstractSketcher {

    public abstract void sketch(Canvas canvas, Line line);

    public abstract void sketch(Canvas canvas, Shape shape);

}
