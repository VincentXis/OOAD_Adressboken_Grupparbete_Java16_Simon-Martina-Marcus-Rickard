package application;

import Register.*;
import application.command.Command;

public class CommandLineInterface implements InputHandler {
    private Registry registry = new Registry();
    private RemoteRegistry remoteRegistry = new RemoteRegistry();
    private RegistryPersister registryPersister = new RegistryPersister(registry);
    private AutoSave autoSave = new AutoSave(registryPersister);

    private CommandInterpreter commandInterpreter = new CommandInterpreter(registry,remoteRegistry, registryPersister);
    private Console console = new Console();
    private CatalogueLoader catalogueLoader = new CatalogueLoader(remoteRegistry);


    public CommandLineInterface() {
    }

    public void runCommandLineInterface() {
        catalogueLoader.run();
        autoSave.autoSave();
        console.registerInputHandler(this);
    }

    @Override
    public void handle(CommandLine commandLine) {
        try {
            Command command = commandInterpreter.interpret(commandLine);
            command.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
