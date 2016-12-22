package application;

import java.util.logging.Logger;

public class Application {
    private static final Logger log = Logger.getLogger(Application.class.getName());
    private CommandLineInterface cli;

    public Application(){
//        this.cli = new CommandLineInterface(this);
    }

    public void start() {
        log.info("Application started");
//        cli.runCommandLineInterface();
        new CommandLineInterface(this);
    }

    public void quit() {
        log.info("Quitting application");
        System.exit(0);
    }

}
