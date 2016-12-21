package application.command;

import Register.Contact;
import Register.Registry;
import Register.RemoteRegistry;
import application.Console;
import application.ConsolePrinter;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PereZ on 2016-12-20.
 */
public class SearchCommand implements Command {

    private String name = "Search";
    private String description = "Search for contacts";

    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private List<String> parameters;

    private ConsolePrinter consolePrinter = new Console();
    private ContactFormatter cf = new ContactFormatter();
    private ContactListSorter cls = new ContactListSorter();

    public SearchCommand(Registry registry, RemoteRegistry remoteRegistry, List<String> parameters) {
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
        this.parameters = parameters;
    }

    public SearchCommand() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void execute() throws InvalidParameterException {
        List<Contact> searchResult = new ArrayList<>();
        if (validate()) {
            searchResult.addAll(registry.search(parameters.get(0)));
            searchResult.addAll(remoteRegistry.search(parameters.get(0)));
            searchResult = cls.sort(searchResult);
            for (Contact contact : searchResult) {
                consolePrinter.print(cf.format(contact));
            }
        } else {
            consolePrinter.print("Search requires 1 parameter, received: " + parameters.size());
            throw new InvalidParameterException("Search requires 1 parameter, received: " + parameters.size());
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
