package application.command;

import java.util.List;

/**
 * Created by PereZ on 2016-12-20.
 */
public class AddContactCommand implements Command {

    String name = "Add";
    String decsription = "Adds a new contact";

    List<String> parameters;

    public AddContactCommand(List<String> parameters) {

        this.parameters = parameters;

    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.decsription;
    }

    @Override
    public void execute() {

    }
}
