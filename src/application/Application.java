package application;

public class Application {

    private CommandLineInterface cli = new CommandLineInterface(this);


    public void start() {
        cli.runCommandLineInterface();
    }
    public void quit(){

    }

}
