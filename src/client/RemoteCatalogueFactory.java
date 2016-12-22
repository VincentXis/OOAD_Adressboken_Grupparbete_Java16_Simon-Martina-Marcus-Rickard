package client;

import register.CatalogueLoader;

public class RemoteCatalogueFactory {

    private int defaultPort;
    private CatalogueLoader catalogueLoader;

    public RemoteCatalogueFactory(int port, CatalogueLoader catalogueLoader) {
        this.defaultPort = port;
        this.catalogueLoader = catalogueLoader;
    }

    public void create(String host) {
        AtomicRemoteCatalogueProxy atomicRemoteCatalogueProxy = new AtomicRemoteCatalogueProxy(host, defaultPort);
        catalogueLoader.loadRemoteContacts(atomicRemoteCatalogueProxy.getContacts());
    }

}
