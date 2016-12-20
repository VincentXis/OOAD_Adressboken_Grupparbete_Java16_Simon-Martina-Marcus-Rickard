package application;

public class Application {
    private InputHandler cli = new CommandLineInterface();
    private Console console = new Console(cli);
}
