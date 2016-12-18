package model.commands;


import model.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by Marc on 12/17/2016.
 */
public class CLogoff extends Command {

    public CLogoff(String trigger) {
        super("CLogoff", trigger);

        setUsage("/logoff");
    }

    @Override
    public void execute(MessageReceivedEvent event) {

    }

}
