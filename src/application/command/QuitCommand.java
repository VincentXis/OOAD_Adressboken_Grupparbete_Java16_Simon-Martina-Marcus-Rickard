package application.command;

/**
 * Created by PereZ on 2016-12-20.
 */
public class QuitCommand implements Command {
    String name = "Quit";
    String decsription = "Quit program";

    public QuitCommand() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return decsription;
    }

    @Override
    public void execute() {

    }
}
