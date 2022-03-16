package factory;

import command.Command;
import command.Create;
import exception.InvalidCommandException;

public class CommandFactory {

    public static Command create(String rawCommand) throws InvalidCommandException {
        return new Create();
    }
}
