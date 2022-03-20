package producer;

import canvas.Canvas;
import command.Command;
import command.Draw;

public class Producer {

    public static void execute(Canvas canvas, Command command) {
        if (canvas == null) throw new IllegalArgumentException("Canvas must not be null");
        if (command == null) throw new IllegalArgumentException("Command must not be null");

        if (command instanceof Draw) Artist.draw(canvas, (Draw) command);
    }
}
