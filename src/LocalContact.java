import java.util.UUID;

/**
 * Created by MacsMac on 2016-12-20.
 */
public class LocalContact implements Contact {

    UUID id;
    ContactDetails contactDetails = new ContactDetails();

    public LocalContact(String firstName, String lastName, String email){
        contactDetails.setFirstName(firstName);
        contactDetails.setLastName(lastName);
        contactDetails.setEmail(email);
    }

    public void setId(UUID id){
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return contactDetails.getFirstName();
    }

    @Override
    public String getLastName() {
        return contactDetails.getFirstName();
    }

    @Override
    public String getEmail() {
        return contactDetails.getEmail();
    }
}
