package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandLine {

    private static final Logger log = Logger.getLogger(CommandLine.class.getName());

    private String command;
    private List<String> parameters;

    private CommandLine(String command, List<String> parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    public static CommandLine parse(String userInput) {
        String inputCommand = "";
        List<String> inputParameters = new ArrayList<>();

        try {
            String[] parseInput = userInput.split(" ");

            inputCommand = parseInput[0];
            inputParameters.addAll(Arrays.asList(parseInput).subList(1, parseInput.length));
        } catch (ArrayIndexOutOfBoundsException e) {
            log.log(Level.SEVERE, "Invalid input", e);
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
