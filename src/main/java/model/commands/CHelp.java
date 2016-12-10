package model.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CHelp extends Command {

    public CHelp(String trigger) {
        super("CHelp", trigger);

        setUsage("/help::List the available commands.");
    }

    /**
     * Respond with a list of available commands.
     *
     * @param event the event that triggered this command
     */
    public void execute(MessageReceivedEvent event) {
        // TODO set the response and respond to the user.
        setResponse("");
    }
}
