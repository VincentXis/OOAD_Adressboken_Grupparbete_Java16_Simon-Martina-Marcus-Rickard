package application;

public class CommandLineInterface implements InputHandler {

    private CommandInterpreter commandInterpreter = new CommandInterpreter();

    private Console console = new Console();

    public void runCommandLineInterface() {
        console.registerInputHandler(this);
    }


    @Override
    public void handle(CommandLine commandLine) {


    }
}
