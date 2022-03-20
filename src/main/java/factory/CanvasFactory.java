package factory;

import canvas.Canvas;
import command.Create;

public class CanvasFactory {

    public static Canvas execute(Create command) {
        if (command == null) throw new IllegalArgumentException("Create command is null");

        int width = command.getWidth();
        int height = command.getHeight();

        return new Canvas(width, height);
    }
}
