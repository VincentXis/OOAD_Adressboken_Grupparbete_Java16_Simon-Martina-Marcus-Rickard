package application.command;

/**
 * Created by PereZ on 2016-12-20.
 */
public class HelpCommand implements Command{

    String name = "Help";
    String description = "Show help menu";

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

    }
}
