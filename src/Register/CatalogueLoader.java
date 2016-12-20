package Register;

/**
 * Created by martina on 2016-12-20.
 */
public class CatalogueLoader {

    CatalogueLoader catalogueLoader = new CatalogueLoader();

    public void run(){
        RemoteCatalogueFactory remoteCatalogueFactory = new RemoteCatalogueFactory(1616);
        new Thread(() -> {
            remoteCatalogueFactory.create("localhost");
        }).start();
    }
}
