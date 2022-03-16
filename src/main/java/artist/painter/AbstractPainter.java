package artist.painter;

import artist.Artist;
import canvas.Canvas;
import canvas.Point;

public abstract class AbstractPainter implements Artist {

    public abstract void paint(Canvas canvas, Point point);

}
