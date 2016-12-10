package model.commands;

import model.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CPing extends Command {

    public CPing(String trigger) {
        super("CPing", trigger);

        setUsage("/ping::pong");
    }

    public void execute(MessageReceivedEvent event) {
        setResponse("pong!");
    }
}
