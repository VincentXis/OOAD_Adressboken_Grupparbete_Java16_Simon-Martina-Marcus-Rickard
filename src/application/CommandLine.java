package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandLine {

    private String command;
    private List<String> parameters;

    private CommandLine(String command, List<String> parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    public static CommandLine parse(String userInput) {
        String[] parseInput = userInput.split(" ");

        String inputCommand = parseInput[0];
        List<String> inputParameters = new ArrayList<>();
        try {
            inputParameters.addAll(Arrays.asList(parseInput).subList(1, parseInput.length));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return new CommandLine(inputCommand, inputParameters);
    }

    public String getCommand() {
        return command;
    }

    public List<String> getParameters() {
        return parameters;
    }
}
