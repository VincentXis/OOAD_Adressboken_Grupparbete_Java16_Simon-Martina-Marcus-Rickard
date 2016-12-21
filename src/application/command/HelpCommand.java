package application.command;

import application.Console;
import application.ConsolePrinter;

/**
 * Created by PereZ on 2016-12-20.
 */
public class HelpCommand implements Command {

    private String name = "Help";
    private String description = "Show help menu";

    private ConsolePrinter consolePrinter = new Console();

    private String format(Command command) {
        return String.format("%-8s%s", command.getName(), command.getDescription());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute() {
        new HelpMenu().getCommands().forEach(command -> consolePrinter.print(format(command)));
    }
}
