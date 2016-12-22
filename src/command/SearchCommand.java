package command;

import Register.Registry;
import Register.RemoteRegistry;
import contact.Contact;
import application.Console;
import application.ConsolePrinter;
import command.commandUtilityClasses.ContactFormatter;
import command.commandUtilityClasses.ContactListSorter;

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

    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private List<String> parameters;
    private List<Contact> searchResult = new ArrayList<>();

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

    private void getSearchResult() {
        searchResult.addAll(registry.search(parameters.get(0)));
        try {
            searchResult.addAll(remoteRegistry.search(parameters.get(0)));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Something went wrong when trying to add the remote contacts ", e);
        }
        searchResult = cls.sort(searchResult);
    }

    private void showSearchResult() {
        String divider = "----------------------------------------";
        consolePrinter.print(String.format("Showing matches to search query: %s\n%s", parameters.get(0), divider));

        if (!searchResult.isEmpty()) {
            searchResult.forEach(contact -> consolePrinter.print(cf.format(contact)));

            consolePrinter.print(String.format("%s\nFound\tLocal:%3d\tRemote:%3d\n%s",
                    divider, registry.search(parameters.get(0)).size(), remoteRegistry.search(parameters.get(0)).size(), divider));
        } else {
            consolePrinter.print("No matches found");
        }
        log.fine(searchResult.size() + "contact/s found");
    }

    @Override
    public String getName() {
        return "Search";
    }

    @Override
    public String getDescription() {
        return "Search for contacts";
    }

    public void execute() throws InvalidParameterException {
        if (validate()) {
            getSearchResult();
            showSearchResult();
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
