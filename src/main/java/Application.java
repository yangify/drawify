import command.Command;
import command.Placeholder;
import command.Quit;
import executor.CommandExecutor;
import factory.CommandFactory;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Command command = new Placeholder();
        CommandExecutor commandExecutor = CommandExecutor.getInstance();

        while (!(command instanceof Quit)) {
            System.out.print("enter command: ");
            String rawCommand = scanner.nextLine();

            try {
                command = CommandFactory.create(rawCommand);
                commandExecutor.execute(command);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
