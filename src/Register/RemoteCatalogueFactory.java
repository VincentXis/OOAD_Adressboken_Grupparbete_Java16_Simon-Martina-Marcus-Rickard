package Register;

import java.util.List;

public class RemoteCatalogueFactory implements RemoteCatalogueProxy {

    private int defaultPort;

    public RemoteCatalogueFactory(int port){

        this.defaultPort = port;
    }

    private void create(String host){

    }

    @Override
    public List<String> getContacts() {
        return null;
    }
}
