package client;

import application.commandLineInterface.console.Console;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {

    private static final Logger log = Logger.getLogger(Console.class.getName());
    private CatalogueClient catalogueClient = new CatalogueClient();

    public AtomicRemoteCatalogueProxy(String host, int port) {
        catalogueClient.setHost(host);
        catalogueClient.setPort(port);
    }

    public List<String> getContacts() {
        log.info("Connecting to server");
        catalogueClient.connect();
        catalogueClient.sendRequest("getall");
        String response = catalogueClient.waitForResponse();
        List<String> catalogueContacts = Arrays.asList(response.split("\\n"));

        catalogueClient.disconnect();

        return catalogueContacts;
    }

}
