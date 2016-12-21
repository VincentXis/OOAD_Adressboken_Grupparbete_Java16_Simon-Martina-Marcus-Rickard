package application;

import Register.AutoSave;
import Register.Registry;
import Register.RegistryPersister;
import Register.RemoteRegistry;
import application.command.Command;

public class CommandLineInterface implements InputHandler {
    private Registry registry = new Registry();
    private RegistryPersister registryPersister = new RegistryPersister(registry);
    private AutoSave autoSave = new AutoSave(registryPersister);
    private RemoteRegistry remoteRegistry = new RemoteRegistry();
    private Application application;
    private CommandInterpreter commandInterpreter = new CommandInterpreter(registry,remoteRegistry, application);
    private Console console = new Console();


    public CommandLineInterface(Application application) {
        this.application = application;
    }

    public void runCommandLineInterface() {
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
