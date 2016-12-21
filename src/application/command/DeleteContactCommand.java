package application.command;

import Register.Registry;
import application.Console;
import application.ConsolePrinter;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by PereZ on 2016-12-20.
 */
public class DeleteContactCommand implements Command {
    Registry registry;
    ConsolePrinter consolePrinter = new Console();
    String name = "Delete";
    String decsription = "Delete a contact";

    List<String> parameters;

    public DeleteContactCommand(List<String> parameters){
        this.parameters = parameters;
    }

    public DeleteContactCommand() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return decsription;
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
