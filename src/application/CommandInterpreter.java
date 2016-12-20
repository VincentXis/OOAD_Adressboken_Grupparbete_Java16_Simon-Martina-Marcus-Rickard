package application;

import application.command.AddContactCommand;
import application.command.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandInterpreter {


    public Command interpret(CommandLine commandLine) {

        Command command;

        switch (commandLine.getCommand()) {

            case "add":
                return command = new AddContactCommand(commandLine.getParameters());

            try {
                throw new Exception("InvalidCommandException");
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        return command;
    }
}
