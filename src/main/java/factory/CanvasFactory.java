package factory;

import canvas.Canvas;
import command.Create;

public class CanvasFactory {

    public static Canvas execute(Create command) {
        if (command == null) throw new IllegalArgumentException("Create command is null");

        int rows = command.getRows();
        int cols = command.getColumns();

        Canvas canvas = new Canvas(rows, cols);
        canvas.print();

        return canvas;
    }
}
