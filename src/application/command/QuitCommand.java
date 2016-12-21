package application.command;

import Register.fileManagement.RegistryPersister;
import application.Application;
import application.Console;
import application.ConsolePrinter;

import java.util.logging.Logger;

/**
 * Created by PereZ on 2016-12-20.
 */
public class QuitCommand implements Command {

    private static final Logger log = Logger.getLogger(QuitCommand.class.getName());

    private String name = "Quit";
    private String description = "Quit program";

    private RegistryPersister registryPersister;
    private ConsolePrinter consolePrinter = new Console();

    public QuitCommand() {

    }

    public QuitCommand(RegistryPersister registryPersister) {
        this.registryPersister = registryPersister;
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
        log.info("Saving local contacts");
        registryPersister.save();
        consolePrinter.print("Goodbye!");
        new Application().quit();
    }
}
