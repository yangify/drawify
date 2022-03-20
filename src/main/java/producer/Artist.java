package producer;

import canvas.Canvas;
import command.Draw;
import sketch.Sketch;
import sketch.line.Line;
import sketch.shape.Shape;

public interface Artist extends Producer {

    static void draw(Canvas canvas, Draw command) {
        Sketch sketch = command.getSketch();
        if (sketch instanceof Line) LineArtist.draw(canvas, (Line) sketch);
        if (sketch instanceof Shape) ShapeArtist.draw(canvas, (Shape) sketch);
    }
}
