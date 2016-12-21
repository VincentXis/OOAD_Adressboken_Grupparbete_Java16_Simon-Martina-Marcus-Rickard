package application;

public class Application {

    private CommandLineInterface cli;
    public Application(){
        this.cli = new CommandLineInterface();
    }

    public void start() {
        cli.runCommandLineInterface();
    }

    public void quit() {
        System.exit(0);
    }

}
