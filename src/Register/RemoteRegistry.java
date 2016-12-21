package Register;

import java.util.ArrayList;

public class RemoteRegistry {

    ArrayList<Contact> remoteContactList = new ArrayList<Contact>();


    public ArrayList<Contact> getContacts() {
        return remoteContactList;
    }

    public ArrayList<Contact> search(String term) {
        ArrayList<Contact> searchResult = new ArrayList<>();
        for (Contact contact : remoteContactList) {
            if (contact.getFirstName().toLowerCase().startsWith(term.toLowerCase()) ||
                    contact.getLastName().toLowerCase().startsWith(term.toLowerCase())) {
                searchResult.add(contact);
            }
        }
        return searchResult;
    }

    public void add(String id, String firstName, String lastName, String email) {
        remoteContactList.add(new RemoteContact(id, firstName, lastName, email));
    }

}
