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
public class ListCommand implements Command {
    Registry registry;
    RemoteRegistry remoteRegistry;
    ConsolePrinter consolePrinter = new Console();
    ContactFormatter cf = new ContactFormatter();
    ContactListSorter cls = new ContactListSorter();

    public ListCommand(Registry registry, RemoteRegistry remoteRegistry) {
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
    }

    String name = "List";
    String description = "Show contactlist";

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

        searchResult.addAll(registry.getContacts());
        searchResult.addAll(remoteRegistry.getContacts());
        searchResult = cls.sort(searchResult);
        for (Contact contact : searchResult) {
            consolePrinter.print(cf.format(contact));
        }

    }
}
