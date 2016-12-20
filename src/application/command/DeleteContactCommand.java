package application.command;

import java.util.List;

/**
 * Created by PereZ on 2016-12-20.
 */
public class DeleteContactCommand implements Command {

    String name = "Delete";
    String decsription = "Delete a contact";

    List<String> parameters;

    public DeleteContactCommand(List<String> parameters){

        this.parameters = parameters;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute() {

    }
}
