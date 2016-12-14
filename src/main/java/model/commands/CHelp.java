package model.commands;

import model.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;

public class CHelp extends Command {
    private List<Command> commands;

    public CHelp(String trigger, List<Command> commands) {
        super("CHelp", trigger);
        this.commands = commands;

        setUsage("/help::List the available commands.");
    }

    /**
     * Respond with a list of available commands.
     *
     * @param event the event that triggered this command
     */
    public void execute(MessageReceivedEvent event) {
        String response = "";

        for (int i = 0; i < commands.size(); i++) {
            Command currentCommand = commands.get(i);
            String usage = currentCommand.getUsage();

            response = response + '\n' + usage;
        }

        setResponse("```" + response + "```");

        respond(event);
    }
}
