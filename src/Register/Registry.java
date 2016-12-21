package Register;

import application.Console;
import application.ConsolePrinter;

import java.util.ArrayList;

public class Registry {

    private ArrayList<Contact> contactList = new ArrayList<>();
    private UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();
    private ConsolePrinter consolePrinter = new Console();

    public void addContact(String firstName, String lastName, String email) {
        LocalContact contact = new LocalContact(firstName, lastName, email);
        contact.setId(uniqueIdGenerator.generateUUID());
        contactList.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return contactList;
    }

    public void deleteContact(String id) {
        String name;
        for (Contact contact : contactList) {
            if (contact.getId().toString().equals(id)) {
                name = contact.getFirstName();
                contactList.remove(contact);

                consolePrinter.print(name + " was deleted");
                return;
            }
        }
        consolePrinter.print("No contacts found matching id: " + id);
    }

    public ArrayList<Contact> search(String term) {
        ArrayList<Contact> searchResult = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getFirstName().startsWith(term) || contact.getLastName().startsWith(term)) {
                searchResult.add(contact);
            }
        }
        return searchResult;
    }

    public void load(ArrayList<Contact> contacts) {
        contactList = contacts;
    }


}
