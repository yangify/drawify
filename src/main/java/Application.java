import illustrator.Illustrator;
import canvas.Canvas;
import command.*;
import factory.CanvasFactory;
import factory.CommandFactory;

import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);
    static Canvas canvas;

    public static void main(String[] args) {

        Command command = new Placeholder();
        while (!(command instanceof Quit)) {
            try {
                if (canvas != null) System.out.println(canvas);
                String rawCommand = prompt();
                command = CommandFactory.create(rawCommand);
                execute(command);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void execute(Command command) {
        if (command instanceof Create) canvas = CanvasFactory.execute((Create) command);
        Illustrator.illustrate(canvas, command);
    }

    public static String prompt() {
        System.out.print("enter command: ");
        return scanner.nextLine();
    }
}
