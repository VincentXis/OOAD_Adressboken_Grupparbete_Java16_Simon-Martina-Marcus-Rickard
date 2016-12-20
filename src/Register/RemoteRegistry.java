package Register;

import java.util.ArrayList;

/**
 * Created by martina on 2016-12-20.
 */
public class RemoteRegistry {

    ArrayList<Contact> remoteContactList = new ArrayList<Contact>();


    public ArrayList<Contact> getContacts() {
        return remoteContactList;
    }

    public ArrayList<Contact> search(String term) {
        ArrayList<Contact> searchResult = new ArrayList<>();
        for (Contact contact : remoteContactList) {
            if (contact.getFirstName().startsWith(term) || contact.getLastName().startsWith(term)) {
                searchResult.add(contact);
            }
        }
        return searchResult;
    }

    public void add(String id, String firstName, String lastName, String email) {
        remoteContactList.add(new RemoteContact(id, firstName, lastName, email));
    }

}