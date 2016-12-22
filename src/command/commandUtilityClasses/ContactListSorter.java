package command.commandUtilityClasses;

import contact.Contact;

import java.util.Comparator;
import java.util.List;

public class ContactListSorter {

    public List<Contact> sort(List<Contact> sort) {
        sort.sort(Comparator.comparing(Contact::getFirstName, String.CASE_INSENSITIVE_ORDER));
        return sort;
    }
}
