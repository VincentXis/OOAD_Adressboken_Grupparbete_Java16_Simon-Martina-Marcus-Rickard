package application;

import java.util.logging.Logger;

public class Application {
    private static final Logger log = Logger.getLogger(Application.class.getName());
    private CommandLineInterface cli;
    public Application(){
        this.cli = new CommandLineInterface();
    }

    public void start() {
        log.info("Application started");
        cli.runCommandLineInterface();
    }

    public void quit() {
        log.info("Quitting application");
        System.exit(0);
    }

}
