package contact;

import contact.Contact;
import contact.ContactDetails;

public class RemoteContact implements Contact {

    private String id;
    private ContactDetails contactDetails = new ContactDetails();

    public RemoteContact(String id, String firstName, String lastName, String email) {
        this.id = id;
        contactDetails.setFirstName(firstName);
        contactDetails.setLastName(lastName);
        contactDetails.setEmail(email);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.contactDetails.getFirstName();
    }

    @Override
    public String getLastName() {
        return this.contactDetails.getLastName();
    }

    @Override
    public String getEmail() {
        return this.contactDetails.getEmail();
    }
}
