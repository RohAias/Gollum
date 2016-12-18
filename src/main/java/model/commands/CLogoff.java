package model.commands;

import model.Command;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CLogoff extends Command {
    private JDA jda;

    public CLogoff(String trigger, JDA jda) {
        super("CLogoff", trigger);

        this.jda = jda;
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        setResponse("Logging off");
        respond(event);

        jda.shutdown(true);
    }
}
