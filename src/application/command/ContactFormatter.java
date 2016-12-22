package application.command;

import Register.contact.Contact;

public class ContactFormatter {

    public String format(Contact contact) {
        return String.format("ID: %s\nName: %s, %s\nEmail: %s\n",
                contact.getId(),
                contact.getFirstName().substring(0, 1).toUpperCase() + contact.getFirstName().substring(1).toLowerCase(),
                contact.getLastName().substring(0, 1).toUpperCase() + contact.getLastName().substring(1).toLowerCase(),
                contact.getEmail().toLowerCase());
    }
}
