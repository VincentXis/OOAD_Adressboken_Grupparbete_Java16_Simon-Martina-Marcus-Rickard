package Register.contact;

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
