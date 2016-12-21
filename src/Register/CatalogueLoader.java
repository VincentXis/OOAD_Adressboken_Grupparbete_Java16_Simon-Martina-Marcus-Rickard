package Register;

public class CatalogueLoader {

    public void run(){
        RemoteCatalogueFactory remoteCatalogueFactory = new RemoteCatalogueFactory(1616);
        new Thread(() -> {
            remoteCatalogueFactory.create("localhost");
        }).start();
    }
}
