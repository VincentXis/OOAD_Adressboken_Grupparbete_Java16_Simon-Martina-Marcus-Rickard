package application.command;

import Register.Contact;

public class ContactFormatter {
    public String format(Contact contact){
        return String.format("ID: %s\nName: %s, %s\nEmail: %s", contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmail());
    }
}
