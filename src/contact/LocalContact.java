package contact;

import contact.Contact;
import contact.ContactDetails;

import java.io.Serializable;
import java.util.UUID;

public class LocalContact implements Contact, Serializable {

    private UUID id;
    private ContactDetails contactDetails = new ContactDetails();

    public LocalContact(String firstName, String lastName, String email) {
        contactDetails.setFirstName(firstName);
        contactDetails.setLastName(lastName);
        contactDetails.setEmail(email);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getId() {
        return this.id.toString();
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
