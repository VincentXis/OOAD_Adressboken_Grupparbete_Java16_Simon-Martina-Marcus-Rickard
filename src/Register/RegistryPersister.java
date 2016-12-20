package Register;

import java.io.*;
import java.util.ArrayList;

public class RegistryPersister {

    Registry registry;

    public RegistryPersister(Registry registry) {

        this.registry = registry;
    }

    public void save() {
        try (FileOutputStream fileOut = new FileOutputStream("contacts.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(registry.getContacts());
        } catch (IOException e) {
            System.out.println("Could not save local contacts");
        }
    }

    public void load() {
        ArrayList<Contact> contactList = new ArrayList<>();
        if (!(new File("contacts.ser").isFile())) {
            registry.load(contactList);
        } else {
            try (FileInputStream fileIn = new FileInputStream("contacts.ser");
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                contactList = (ArrayList<Contact>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Could not load local contacts");
            }
            registry.load(contactList);
        }
    }
}
