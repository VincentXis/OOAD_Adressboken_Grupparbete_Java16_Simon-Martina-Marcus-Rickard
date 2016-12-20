package Register;

import java.util.List;

public class RemoteCatalogueFactory implements RemoteCatalogueProxy {

    private int defaultPort;

    public RemoteCatalogueFactory(int port){
        this.defaultPort = port;
    }

    public void create(String host){
        AtomicRemoteCatalogueProxy atomicRemoteCatalogueProxy= new AtomicRemoteCatalogueProxy(host, defaultPort);
        atomicRemoteCatalogueProxy.getContacts();
    }

    @Override
    public List<String> getContacts() {
        return null;
    }
}
