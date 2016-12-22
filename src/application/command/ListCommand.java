package application.command;

import Register.Registry;
import Register.RemoteRegistry;
import Register.contact.Contact;
import application.Console;
import application.ConsolePrinter;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PereZ on 2016-12-20.
 */
public class ListCommand implements Command {

    private String name = "List";
    private String description = "Show contactlist";

    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private ContactListSorter cls = new ContactListSorter();

    private ConsolePrinter consolePrinter = new Console();
    private ContactFormatter cf = new ContactFormatter();

    public ListCommand(Registry registry, RemoteRegistry remoteRegistry) {
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
    }

    public ListCommand() {
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

        searchResult.addAll(registry.getContacts());
        searchResult.addAll(remoteRegistry.getContacts());
        searchResult = cls.sort(searchResult);
        if(searchResult.isEmpty()){
            consolePrinter.print("Your contact list is empty");
        }
        for (Contact contact : searchResult) {
            consolePrinter.print(cf.format(contact));
        }

    }
}
