package Register.contact;

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
        return id.toString();
    }

    @Override
    public String getFirstName() {
        return contactDetails.getFirstName();
    }

    @Override
    public String getLastName() {
        return contactDetails.getLastName();
    }

    @Override
    public String getEmail() {
        return contactDetails.getEmail();
    }
}
