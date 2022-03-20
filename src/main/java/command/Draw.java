package command;

import sketch.Sketch;

public class Draw implements Command {

    private final Sketch sketch;

    public Draw(Sketch sketch) {
        if (sketch == null) throw new IllegalArgumentException("Sketch must not be null");
        this.sketch = sketch;
    }

    public Sketch getSketch() {
        return sketch;
    }
}
