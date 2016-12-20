package application.command;

import java.util.List;

/**
 * Created by PereZ on 2016-12-20.
 */
public class SearchCommand implements Command {

    String name = "Search";
    String decsription = "Search for contacts";

    List<String> parameters;
    public SearchCommand(List<String> parameters){

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
