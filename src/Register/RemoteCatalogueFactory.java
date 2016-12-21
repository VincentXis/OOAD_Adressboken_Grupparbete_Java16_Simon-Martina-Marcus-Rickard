package Register;

import java.util.List;

public class RemoteCatalogueFactory {

    private int defaultPort;



    public RemoteCatalogueFactory(int port){
        this.defaultPort = port;
    }

    public void create(String host){
        AtomicRemoteCatalogueProxy atomicRemoteCatalogueProxy = new AtomicRemoteCatalogueProxy(host, defaultPort);
        atomicRemoteCatalogueProxy.getContacts();
    }

}
