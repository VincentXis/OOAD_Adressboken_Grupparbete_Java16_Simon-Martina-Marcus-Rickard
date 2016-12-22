package application.command;

import Register.Registry;
import application.Console;
import application.ConsolePrinter;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by PereZ on 2016-12-20.
 */
public class AddContactCommand implements Command {

    private List<String> parameters;
    private Registry registry;
    private ConsolePrinter consolePrinter = new Console();

    public AddContactCommand(Registry registry, List<String> parameters) {
        this.registry = registry;
        this.parameters = parameters;
    }

    public AddContactCommand() {
    }

    @Override
    public String getName() {
        return "Add";
    }

    @Override
    public String getDescription() {
        return "Adds a new contact";
    }

    @Override
    public void execute() throws InvalidParameterException {
        if (validate()) {
            registry.addContact(parameters.get(0), parameters.get(1), parameters.get(2));
            consolePrinter.print("Contact was added to registry");
        } else {
            consolePrinter.print("Add requires 3 parameters, received: " + parameters.size());
            throw new InvalidParameterException("Add requires 3 parameters, received: " + parameters.size());
        }
    }

    private boolean validate() {
        if (parameters.size() == 3) {
            return true;
        } else {
            return false;
        }
    }
}
