package command;

import register.Registry;
import application.commandLineInterface.console.Console;
import application.commandLineInterface.console.ConsolePrinter;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by PereZ on 2016-12-20.
 */
public class DeleteContactCommand implements Command {

    private List<String> parameters;
    private Registry registry;
    private ConsolePrinter consolePrinter = new Console();

    public DeleteContactCommand(Registry registry, List<String> parameters) {
        this.registry = registry;
        this.parameters = parameters;
    }

    public DeleteContactCommand() {
    }

    @Override
    public String getName() {
        return "Delete";
    }

    @Override
    public String getDescription() {
        return "Delete a contact";
    }

    @Override
    public void execute() throws InvalidParameterException {
        if (validate()) {
            registry.deleteContact(parameters.get(0));
        } else {
            consolePrinter.print("Delete requires 1 parameter, received: " + parameters.size());
            throw new InvalidParameterException("Delete requires 1 parameter, received: " + parameters.size());
        }
    }

    private boolean validate() {
        if (parameters.size() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
