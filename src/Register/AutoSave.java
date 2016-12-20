package Register;

/**
 * Created by MacsMac on 2016-12-20.
 */
public class AutoSave {

    private RegistryPersister registryPersister = new RegistryPersister();

    public void autoSave() {
        Thread autoSaveThread = new Thread(() -> {
            while (true) {
                try {
                    synchronized (this) {
                        Thread.sleep(5000);
                        registryPersister.save();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Autosave failed");
                }
            }
        });
        autoSaveThread.start();
    }
}
