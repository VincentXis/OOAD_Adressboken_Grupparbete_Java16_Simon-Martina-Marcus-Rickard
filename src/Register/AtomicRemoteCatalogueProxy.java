package Register;

import java.util.Arrays;
import java.util.List;

public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {

    private CatalogueClient catalogueClient = new CatalogueClient();

    AtomicRemoteCatalogueProxy(String host, int port) {

        catalogueClient.setHost(host);
        catalogueClient.setPort(port);
    }

    public List<String> getContacts() {

        catalogueClient.connect();
        catalogueClient.sendRequest("getall");
        String response = catalogueClient.waitForResponse();
        List<String> catalogueContacts = Arrays.asList(response.split("\\n"));

        catalogueClient.disconnect();

        return catalogueContacts;
    }

}
