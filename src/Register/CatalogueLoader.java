package Register;

import client.RemoteCatalogueFactory;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by martina on 2016-12-20.
 */
public class CatalogueLoader {

    private static final Logger log = Logger.getLogger(CatalogueLoader.class.getName());

    private RemoteRegistry remoteRegistry;

    public CatalogueLoader(RemoteRegistry remoteRegistry) {
        this.remoteRegistry = remoteRegistry;
    }

    public void run() {
        RemoteCatalogueFactory remoteCatalogueFactory = new RemoteCatalogueFactory(61616, this);
        new Thread(() -> {
            remoteCatalogueFactory.create("172.20.200.165");
        }).start();
    }

    public void loadRemoteContacts(List<String> remoteContacts) {
        String[] parsedContactInfo;
        for (String rawContactData : remoteContacts) {
            try {
                parsedContactInfo = rawContactData.split(" ");
                remoteRegistry.add(parsedContactInfo[0], parsedContactInfo[1], parsedContactInfo[2], parsedContactInfo[3]);
            } catch (ArrayIndexOutOfBoundsException e) {
                log.log(Level.SEVERE, "Could not create contacts from the remote catalogue data", e);
            }
        }
    }
}
