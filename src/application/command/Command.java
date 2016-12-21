package application.command;

/**
 * Created by PereZ on 2016-12-20.
 */
public interface Command {
    String getName();

    String getDescription();

    void execute();
}
