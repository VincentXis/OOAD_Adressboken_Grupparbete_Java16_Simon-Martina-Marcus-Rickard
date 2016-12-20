package Register;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by MacsMac on 2016-12-20.
 */
public class Registry {

    private ArrayList<Contact> contactList = new ArrayList<>();
    private UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();

    public void addContact(String firstName, String lastName, String email) {
        LocalContact contact = new LocalContact(firstName, lastName, email);
        contact.setId(uniqueIdGenerator.generateUUID());
        contactList.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return contactList;
    }

    public void deleteContact(String id) {
        boolean foundMatch = false;
        String name;
        for (Contact contact : contactList) {
            if (contact.getId().toString().equals(id)) {
                name = contact.getFirstName();
                contactList.remove(contact);
                foundMatch = true;
                System.out.println(name + "was deletet");
            }
        }
        if (!foundMatch) {
            System.out.println("No contact found");
        }
    }


    public ArrayList<Contact> search(String term) {
        ArrayList<Contact> searchResult = new ArrayList<>();
        for (Contact contact : contactList){
            if (contact.getFirstName().startsWith(term) || contact.getLastName().startsWith(term)){
                searchResult.add(contact);
            }
        }
        return searchResult;
    }

    public void load(ArrayList<Contact> contacts){
        contactList = contacts;
    }


}
