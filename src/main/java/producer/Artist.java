package producer;

import canvas.Canvas;
import sketch.Sketch;
import sketch.line.Line;
import sketch.shape.Shape;

public class Artist extends Producer {

    static String VALUE = "x";

    static void draw(Canvas canvas, Sketch sketch) {
        if (canvas == null) throw new IllegalArgumentException("Canvas must not be null");
        if (sketch == null) throw new IllegalArgumentException("Sketch must not be null");

        delegate(canvas, sketch);
    }

    private static void delegate(Canvas canvas, Sketch sketch) {
        if (sketch instanceof Line) LineArtist.draw(canvas, (Line) sketch);
        if (sketch instanceof Shape) ShapeArtist.draw(canvas, (Shape) sketch);
    }
}
