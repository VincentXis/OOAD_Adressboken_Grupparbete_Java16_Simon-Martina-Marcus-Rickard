import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by MacsMac on 2016-12-20.
 */
public class Registry implements Serializable {

    private ArrayList<Contact> contactList = new ArrayList<>();

    public void addContact(String firstName, String lastName, String email) {
        contactList.add(new LocalContact(firstName, lastName, email));
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
