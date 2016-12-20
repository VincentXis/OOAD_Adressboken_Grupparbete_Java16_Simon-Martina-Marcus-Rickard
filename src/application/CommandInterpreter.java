package application;

import Register.Registry;
import Register.RemoteRegistry;
import application.command.*;

public class CommandInterpreter {
    private Registry registry = new Registry();
    private RemoteRegistry remoteRegistry = new RemoteRegistry();

    public CommandInterpreter(Registry registry,RemoteRegistry remoteRegistry){
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
    }

    /**
     * FIXA RETURN!
     * @param commandLine
     * @return
     */
    public Command interpret(CommandLine commandLine) {

        Command command = null;
        try {
            switch (commandLine.getCommand()) {
                case "add":
                    return new AddContactCommand(registry, commandLine.getParameters());
                case "delete":
                    return new DeleteContactCommand(commandLine.getParameters());
                case "search":
                    return new SearchCommand(registry, remoteRegistry, commandLine.getParameters());

                case "list":
                    command = new ListCommand(registry, remoteRegistry);
                    break;
                case "help":
                    command = new HelpCommand();
                    break;
                case "quit":
                    command = new QuitCommand();
                default:
                    throw new Exception("InvalidCommandException");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return command;
    }
}
