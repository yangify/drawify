package factory;

import command.*;
import exception.InvalidCommandException;
import sketch.line.Line;
import sketch.shape.Rectangle;

import java.util.List;

public class CommandFactory {

    static String delimiter = " ";

    public static Command create(String rawCommand) throws InvalidCommandException {
        List<String> splitCommand = List.of(rawCommand.split(delimiter));
        if (splitCommand.size() == 0) throw new InvalidCommandException("Command cannot be empty");

        List<String> parameters = splitCommand.subList(1, splitCommand.size());
        switch (splitCommand.get(0)) {
            case "C": return new Create(parameters);
            case "L": return new Draw(new Line(parameters));
            case "R": return new Draw(new Rectangle(parameters));
            case "B": return new Paint(parameters);
            case "Q": return new Quit();
            default: return null;
        }
    }
}
