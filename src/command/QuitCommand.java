package command;

import Register.registryFileManagement.RegistryPersister;
import application.Application;
import application.Console;
import application.ConsolePrinter;

import java.util.logging.Logger;

/**
 * Created by PereZ on 2016-12-20.
 */
public class QuitCommand implements Command {

    private static final Logger log = Logger.getLogger(QuitCommand.class.getName());

    private Application application;
    private RegistryPersister registryPersister;
    private ConsolePrinter consolePrinter = new Console();

    public QuitCommand() {
    }

    public QuitCommand(RegistryPersister registryPersister, Application application) {
        this.registryPersister = registryPersister;
        this.application = application;
    }

    @Override
    public String getName() {
        return "Quit";
    }

    @Override
    public String getDescription() {
        return "Quit program";
    }

    @Override
    public void execute() {
        log.info("Saving local contacts");
        consolePrinter.print("Saving all local contacts");
        registryPersister.save();
        consolePrinter.print("Goodbye!");
        application.quit();
    }
}
