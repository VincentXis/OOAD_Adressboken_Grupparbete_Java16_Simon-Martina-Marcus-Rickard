package application;

import Register.Registry;
import Register.RemoteRegistry;
import application.command.*;

public class CommandInterpreter {
    private Registry registry = new Registry();
    private RemoteRegistry remoteRegistry = new RemoteRegistry();

    public CommandInterpreter(Registry registry, RemoteRegistry remoteRegistry) {
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
    }


    public Command interpret(CommandLine commandLine) throws Exception {

        Command command = null;
        try {
            switch (commandLine.getCommand()) {
                case "add":
                    command = new AddContactCommand(registry, commandLine.getParameters());
                    break;
                case "delete":
                    command = new DeleteContactCommand(commandLine.getParameters());
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
                    command = new QuitCommand();
                    break;
                default:
                    throw new Exception("InvalidCommandException");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return command;
    }
}
