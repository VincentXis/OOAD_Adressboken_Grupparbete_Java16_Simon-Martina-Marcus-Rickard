package application.command;

import Register.Registry;
import Register.RemoteRegistry;
import Register.contact.Contact;
import application.Console;
import application.ConsolePrinter;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by PereZ on 2016-12-20.
 */
public class SearchCommand implements Command {

    private static final Logger log = Logger.getLogger(SearchCommand.class.getName());

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

    public SearchCommand() {}

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
            try {
                searchResult.addAll(remoteRegistry.search(parameters.get(0)));
            } catch (Exception e) {
                log.log(Level.SEVERE, "ERROR ", e);
            }
            searchResult = cls.sort(searchResult);

            if (!searchResult.isEmpty()) {
                for (Contact contact : searchResult) {
                    consolePrinter.print(cf.format(contact));
                }
                consolePrinter.print(String.format("Local contacts: %d\nExternal contacts: %d",
                        registry.search(parameters.get(0)).size(),
                        remoteRegistry.search(parameters.get(0)).size())
                );
            } else {
                consolePrinter.print("No search result found for: " + parameters.get(0));
            }
            log.fine(searchResult.size() + "contact/s found");
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
