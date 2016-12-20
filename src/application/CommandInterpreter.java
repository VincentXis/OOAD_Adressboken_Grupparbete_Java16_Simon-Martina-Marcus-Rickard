package application;

import application.command.*;

public class CommandInterpreter {

    public Command interpret(CommandLine commandLine) {
        Command command;
        try {
            switch (commandLine.getCommand()) {
                case "add":
                    command = new AddContactCommand(commandLine.getParameters());
                    break;
                case "delete":
                    command = new DeleteContactCommand(commandLine.getParameters());
                    break;
                case "search":
                    command = new SearchCommand(commandLine.getParameters());
                    break;
                case "list":
                    command = new ListCommand();
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
