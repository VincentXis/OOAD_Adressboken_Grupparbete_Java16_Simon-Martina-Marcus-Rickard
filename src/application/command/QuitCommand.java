package application.command;

import application.Application;

/**
 * Created by PereZ on 2016-12-20.
 */
public class QuitCommand implements Command {
    private String name = "Quit";
    private String description = "Quit program";
    private Application application;

    public QuitCommand(Application application) {
        this.application = application;
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
        application.quit();
    }
}
