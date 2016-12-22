package application.command;

import application.Console;
import application.ConsolePrinter;

/**
 * Created by PereZ on 2016-12-20.
 */
public class HelpCommand implements Command {

    private ConsolePrinter consolePrinter = new Console();

    private String format(Command command) {
        return String.format(" * %-8s%s", command.getName(), command.getDescription());
    }

    @Override
    public String getName() {
        return "Help";
    }

    @Override
    public String getDescription() {
        return "Show help menu";
    }

    @Override
    public void execute() {
        String divider = "-------------------------------";
        consolePrinter.print("List of all available commands:\n"+divider);
        new HelpMenu().getCommands().forEach(command -> consolePrinter.print(format(command)));
        consolePrinter.print(divider);
    }
}
