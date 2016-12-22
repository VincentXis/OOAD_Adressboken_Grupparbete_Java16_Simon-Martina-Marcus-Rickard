package application;

import register.Registry;
import register.RemoteRegistry;
import register.registryFileManagement.RegistryPersister;
import command.*;

public class CommandInterpreter {

    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private RegistryPersister registryPersister;
    private Application application;

    public CommandInterpreter(Registry registry, RemoteRegistry remoteRegistry, RegistryPersister registryPersister, Application application) {
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
        this.registryPersister = registryPersister;
        this.application = application;
    }

    public Command interpret(CommandLine commandLine) throws Exception {
        Command command;
        switch (commandLine.getCommand()) {
            case "add":
                command = new AddContactCommand(registry, commandLine.getParameters());
                break;
            case "delete":
                command = new DeleteContactCommand(registry, commandLine.getParameters());
                break;
            case "search":
                command = new SearchCommand(registry, remoteRegistry, commandLine.getParameters());
                break;
            case "list":
                command = new ListCommand(registry, remoteRegistry);
                break;
            case "help":
                command = new HelpCommand();
                break;
            case "quit":
                command = new QuitCommand(registryPersister, application);
                break;
            default:
                throw new Exception("InvalidCommandException");
        }
        return command;
    }
}
