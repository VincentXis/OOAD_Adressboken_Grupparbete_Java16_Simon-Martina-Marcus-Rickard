package application;

import java.util.Scanner;
import java.util.logging.Logger;

public class Console implements ConsolePrinter {

    private static final Logger log = Logger.getLogger(Console.class.getName());

    public void registerInputHandler(InputHandler inputHandler) {
        inputListener(inputHandler);
    }

    private void inputListener(InputHandler inputHandler) {
        String userInput;
        while (true) {
            userInput = readUserInput();
            log.fine("User input: " + userInput);
            CommandLine commandLine = CommandLine.parse(userInput);
            inputHandler.handle(commandLine);
        }
    }

    @Override
    public void print(String output) {
        System.out.println(output);
    }

    private String readUserInput() {
        return new Scanner(System.in).nextLine();
    }
}
