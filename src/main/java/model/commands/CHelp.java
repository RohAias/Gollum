package model.commands;

public class CHelp extends Command {

    public CHelp(String trigger) {
        super("CHelp", trigger);

        setUsage("/help::List the available commands.");
    }

    public void execute(String message) {
        /*
         * Respond with a list of available commands.
         */
        setResponse("");
    }
}
