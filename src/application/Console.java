package application;

import java.util.Scanner;

public class Console implements ConsolePrinter {
    private CommandLine commandLine;

    public Console(InputHandler commandLineInterface) {
        registerInputHandler(commandLineInterface);
    }

    private void inputListener(InputHandler inputHandler) {
        String userInput;
        while (true) {
            userInput = readUserInput();
            commandLine = CommandLine.parse(userInput);
            inputHandler.handle(commandLine);
        }
    }

    private void registerInputHandler(InputHandler inputHandler) {
        inputListener(inputHandler);
    }


    @Override
    public void print(String output) {
        System.out.println(output);
    }


    private String readUserInput() {
        return new Scanner(System.in).nextLine();
    }
}
