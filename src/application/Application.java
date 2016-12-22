package application;

import java.util.logging.Logger;

public class Application {
    private static final Logger log = Logger.getLogger(Application.class.getName());

    public void start() {
        log.info("Application started");
        new CommandLineInterface(this);
    }

    public void quit() {
        log.info("Quitting application");
        System.exit(0);
    }

}
