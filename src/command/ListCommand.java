package command;

import register.Registry;
import register.RemoteRegistry;
import contact.Contact;
import application.commandLineInterface.console.Console;
import application.commandLineInterface.console.ConsolePrinter;
import command.commandUtilityClasses.ContactFormatter;
import command.commandUtilityClasses.ContactListSorter;

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
        List<Contact> contactList = new ArrayList<>();
        String divider = "----------------------------------------";

        contactList.addAll(registry.getContacts());
        contactList.addAll(remoteRegistry.getContacts());
        contactList = cls.sort(contactList);

        if (!contactList.isEmpty()) {
            consolePrinter.print("\tShowing all available contact/s\n" + divider);
            contactList.forEach(contact -> consolePrinter.print(cf.format(contact)));

            consolePrinter.print(String.format("%s\nList contains\tLocal:%3d\tRemote:%3d\n%s", divider,
                    registry.getContacts().size(), remoteRegistry.getContacts().size(), divider));
        } else {
            consolePrinter.print("Your contact list is empty");
        }
    }
}













