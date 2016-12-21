package Register;

import java.util.List;

/**
 * Created by martina on 2016-12-20.
 */
public class CatalogueLoader {

    RemoteRegistry remoteRegistry;

    public CatalogueLoader(RemoteRegistry remoteRegistry){
        this.remoteRegistry = remoteRegistry;
    }

    public void run(){
        RemoteCatalogueFactory remoteCatalogueFactory = new RemoteCatalogueFactory(61616, this);
        new Thread(() -> {
            remoteCatalogueFactory.create("localhost");
        }).start();
    }

    public void loadRemoteContacts(List<String> remoteContacts){
        String[] parsedContactInfo;
        for (String rawContactData : remoteContacts){
            parsedContactInfo = rawContactData.split(" ");
        remoteRegistry.add(parsedContactInfo[0], parsedContactInfo[1], parsedContactInfo[2], parsedContactInfo[3]);
        }
    }
}
