package application;

import java.util.Scanner;

public class Console implements ConsolePrinter {

    public void registerInputHandler(InputHandler inputHandler) {
        inputListener(inputHandler);
    }

    private void inputListener(InputHandler inputHandler) {
        String userInput;
        while (true) {
            userInput = readUserInput();
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
