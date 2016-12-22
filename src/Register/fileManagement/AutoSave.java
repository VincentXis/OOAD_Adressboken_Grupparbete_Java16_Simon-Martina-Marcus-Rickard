package Register.fileManagement;

/**
 * Created by MacsMac on 2016-12-20.
 */
public class AutoSave {

    private RegistryPersister registryPersister;

    public AutoSave(RegistryPersister registryPersister) {
        this.registryPersister = registryPersister;
    }

    public void autoSave() {
        new Thread(() -> {
            while (true) {
                try {
                    synchronized (this) {
                        Thread.sleep(5_000);
                        registryPersister.save();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Auto-save failed");
                }
            }
        }).start();
    }
}