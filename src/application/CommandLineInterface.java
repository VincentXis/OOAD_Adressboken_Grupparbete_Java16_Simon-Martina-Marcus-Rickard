package application;

import Register.Registry;
import Register.RemoteRegistry;
import application.command.Command;

public class CommandLineInterface implements InputHandler {
    private Registry registry = new Registry();
    private RemoteRegistry remoteRegistry = new RemoteRegistry();

    private CommandInterpreter commandInterpreter = new CommandInterpreter(registry,remoteRegistry);

    private Console console = new Console();

    public void runCommandLineInterface() {
        console.registerInputHandler(this);
    }

    @Override
    public void handle(CommandLine commandLine) {
        try {
            Command command = commandInterpreter.interpret(commandLine);
            command.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
