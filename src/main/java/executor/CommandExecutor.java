package executor;

import command.Command;

public class CommandExecutor {

    static CommandExecutor instance;

    private CommandExecutor() {}

    public static CommandExecutor getInstance() {
        if (instance == null) instance = new CommandExecutor();
        return instance;
    }

    public void execute(Command command) {

    }
}
