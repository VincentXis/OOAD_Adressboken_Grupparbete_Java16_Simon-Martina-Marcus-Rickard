package application.command;

import java.util.ArrayList;
import java.util.List;

public class HelpMenu {
    public HelpMenu() {
        build();
    }

    private List<Command> commands = new ArrayList<>();

    private void build(){
        commands.add(new AddContactCommand());
        commands.add(new DeleteContactCommand());
        commands.add(new SearchCommand());
        commands.add(new ListCommand());
        commands.add(new HelpCommand());
        commands.add(new QuitCommand());
    }

    public List<Command> getCommands() {
        return commands;
    }
}
