package command;

import sketch.Sketch;

public class Draw implements Command {

    private final Sketch sketch;

    public Draw(Sketch sketch) {
        this.sketch = sketch;
    }

    public Sketch getSketch() {
        return sketch;
    }
}
