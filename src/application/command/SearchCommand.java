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
    Registry registry;
    RemoteRegistry remoteRegistry;
    ConsolePrinter consolePrinter = new Console();
    ContactFormatter cf = new ContactFormatter();
    ContactListSorter cls = new ContactListSorter();


    String name = "Search";
    String decsription = "Search for contacts";

    List<String> parameters;

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
        return decsription;
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
