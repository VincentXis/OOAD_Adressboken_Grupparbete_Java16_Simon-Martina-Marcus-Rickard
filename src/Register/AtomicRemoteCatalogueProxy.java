package Register;

import java.util.ArrayList;
import java.util.List;

public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {

    private CatalogueClient catalogueClient = new CatalogueClient();

    AtomicRemoteCatalogueProxy(String host, int port) {

        catalogueClient.setHost(host);
        catalogueClient.setPort(port);
    }

    public List<String> getContacts() {

        List<String> catalogueContacts = new ArrayList<>();

        catalogueClient.connect();
        catalogueClient.sendRequest("getall");
        String response = catalogueClient.waitForResponse();
        String[]
        catalogueClient.disconnect();

        return catalogueContacts;
    }

}
