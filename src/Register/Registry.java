package Register;

import contact.Contact;
import contact.LocalContact;
import application.Console;
import application.ConsolePrinter;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Registry {

    private static final Logger log = Logger.getLogger(Registry.class.getName());

    private ArrayList<Contact> contactList = new ArrayList<>();
    private UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();
    private ConsolePrinter consolePrinter = new Console();

    public void addContact(String firstName, String lastName, String email) {
        LocalContact contact = new LocalContact(firstName, lastName, email);
        contact.setId(uniqueIdGenerator.generateUUID());
        contactList.add(contact);
        log.fine(String.format("Contact: %s, %s has been added", firstName, lastName));
    }

    public ArrayList<Contact> getContacts() {
        return contactList;
    }

    public void deleteContact(String id) {
        String name;
        for (Contact contact : contactList) {
            if (contact.getId().equals(id)) {
                name = contact.getFirstName();
                contactList.remove(contact);
                consolePrinter.print(name + " was deleted");
                log.fine("Contact with id: " + id + " was deleted");
                return;
            }
        }
        consolePrinter.print("No contacts found matching id: " + id);
        log.fine("No contact with id: " + id + "was found");
    }

    public ArrayList<Contact> search(String query) {
        ArrayList<Contact> searchResult = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getFirstName().toLowerCase().startsWith(query.toLowerCase()) ||
                    contact.getLastName().toLowerCase().startsWith(query.toLowerCase())) {
                searchResult.add(contact);
            }
        }
        return searchResult;
    }

    public void load(ArrayList<Contact> contacts) {
        contactList = contacts;
    }


}
