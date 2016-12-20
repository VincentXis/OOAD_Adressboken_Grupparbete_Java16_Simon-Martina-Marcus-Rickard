import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Created by MacsMac on 2016-12-20.
 */
public class RegistryPersister {

    Registry registry = new Registry();

    public void save(){

    }

    public void load(){
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
