package producer;

import canvas.Canvas;
import canvas.Point;
import command.Draw;
import sketch.Sketch;
import sketch.line.Line;
import sketch.shape.Shape;

public interface Artist extends Producer {

    String VALUE = "x";

    static void draw(Canvas canvas, Draw command) {
        Sketch sketch = command.getSketch();
        Point p1 = sketch.getP1();
        Point p2 = sketch.getP2();

        if (p1.equals(p2)) {
            canvas.setPoint(p1, VALUE);
        } else {
            delegate(canvas, sketch);
        }
    }

    private static void delegate(Canvas canvas, Sketch sketch) {
        if (sketch instanceof Line) LineArtist.draw(canvas, (Line) sketch);
        if (sketch instanceof Shape) ShapeArtist.draw(canvas, (Shape) sketch);
    }
}
