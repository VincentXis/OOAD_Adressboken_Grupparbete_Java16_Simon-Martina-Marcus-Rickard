package Register;

import contact.Contact;
import contact.RemoteContact;

import java.util.ArrayList;

public class RemoteRegistry {

    private ArrayList<Contact> remoteContactList = new ArrayList<Contact>();

    public ArrayList<Contact> getContacts() {
        return remoteContactList;
    }

    public ArrayList<Contact> search(String query) {
        ArrayList<Contact> searchResult = new ArrayList<>();
        for (Contact contact : remoteContactList) {
            if (contact.getFirstName().toLowerCase().startsWith(query.toLowerCase()) ||
                    contact.getLastName().toLowerCase().startsWith(query.toLowerCase())) {
                searchResult.add(contact);
            }
        }
        return searchResult;
    }

    public void add(String id, String firstName, String lastName, String email) {
        remoteContactList.add(new RemoteContact(id, firstName, lastName, email));
    }

}
