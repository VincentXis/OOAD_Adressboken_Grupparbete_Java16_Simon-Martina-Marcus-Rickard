import application.Application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

/**
 * Created by MacsMac on 2016-12-21.
 */
public class Main {

    public static void main(String[] args) {
        loggerSetup();
        new Application().start();
    }
    private static void loggerSetup() {
        String loggingFilePath = "src/logs/logging.properties";
        try (FileInputStream is = new FileInputStream(loggingFilePath)) {
            LogManager.getLogManager().readConfiguration(is);
        } catch (IOException e) {
            throw new RuntimeException("Could not load log properties.", e);
        }
    }
}
