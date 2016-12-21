package application;

import Register.Registry;
import Register.fileManagement.RegistryPersister;
import Register.RemoteRegistry;
import application.command.*;

public class CommandInterpreter {
    private Registry registry;
    private RemoteRegistry remoteRegistry;

    private RegistryPersister registryPersister;

    public CommandInterpreter(Registry registry, RemoteRegistry remoteRegistry, RegistryPersister registryPersister) {
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;

        this.registryPersister = registryPersister;
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
                command = new QuitCommand(registryPersister);
                break;
            default:
                throw new Exception("InvalidCommandException");
        }
        return command;
    }
}
