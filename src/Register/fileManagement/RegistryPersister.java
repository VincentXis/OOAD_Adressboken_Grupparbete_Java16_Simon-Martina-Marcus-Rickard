package Register.fileManagement;

import Register.Registry;
import Register.contact.Contact;
import application.*;
import application.Console;

import java.io.*;
import java.util.ArrayList;

public class RegistryPersister {
    private ConsolePrinter consolePrinter = new Console();

    private Registry registry;

    public RegistryPersister(Registry registry) {
        this.registry = registry;
        load();
    }

    public synchronized void save() {
        try (FileOutputStream fileOut = new FileOutputStream("contacts.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(registry.getContacts());
        } catch (IOException e) {
            consolePrinter.print("Could not save local contacts");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void load() {
        ArrayList<Contact> contactList = new ArrayList<>();
        if (!(new File("contacts.ser").isFile())) {
            registry.load(contactList);
        } else {
            try (FileInputStream fileIn = new FileInputStream("contacts.ser");
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                contactList = (ArrayList<Contact>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                consolePrinter.print("Could not lode local contacts");
            }
            registry.load(contactList);
        }
    }
}
