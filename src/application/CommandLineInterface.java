package application;

import Register.*;
import Register.fileManagement.AutoSave;
import Register.fileManagement.RegistryPersister;
import application.command.Command;

import java.security.InvalidParameterException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandLineInterface implements InputHandler {
    private static final Logger log = Logger.getLogger(CommandLineInterface.class.getName());
    private Registry registry = new Registry();
    private RemoteRegistry remoteRegistry = new RemoteRegistry();
    private RegistryPersister registryPersister = new RegistryPersister(registry);
    private AutoSave autoSave = new AutoSave(registryPersister);

    private CommandInterpreter commandInterpreter = new CommandInterpreter(registry,remoteRegistry, registryPersister);
    private Console console = new Console();
    private CatalogueLoader catalogueLoader = new CatalogueLoader(remoteRegistry);


    public void runCommandLineInterface() {
        console.print("Welcome!");
        catalogueLoader.run();
        autoSave.autoSave();
        console.registerInputHandler(this);
    }

    @Override
    public void handle(CommandLine commandLine) {
        try {
            Command command = commandInterpreter.interpret(commandLine);
            command.execute();
            log.info("Given command was successfully executed");
        } catch (InvalidParameterException e) {
            log.log(Level.SEVERE, "An exception was thrown: ", e);
        } catch (Exception e) {
            log.log(Level.SEVERE, "An exception was thrown: ", e);
            console.print("Invalid command: " + commandLine.getCommand());
        }
    }
}
