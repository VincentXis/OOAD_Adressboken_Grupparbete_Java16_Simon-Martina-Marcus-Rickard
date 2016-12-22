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
        return "List";
    }

    @Override
    public String getDescription() {
        return "Show contact list";
    }

    public void execute() throws InvalidParameterException {
        List<Contact> searchResult = new ArrayList<>();
        String divider = "----------------------------------------";

        searchResult.addAll(registry.getContacts());
        searchResult.addAll(remoteRegistry.getContacts());
        searchResult = cls.sort(searchResult);

        if (!searchResult.isEmpty()) {
            consolePrinter.print("\tShowing all available contact/s\n" + divider);
            searchResult.forEach(contact -> consolePrinter.print(cf.format(contact)));

            consolePrinter.print(String.format("%s\nLocal :%3d\nRemote:%3d\n%s", divider,
                    registry.getContacts().size(), remoteRegistry.getContacts().size(), divider));
        } else {
            consolePrinter.print("Your contact list is empty");
        }
    }
}













