package controller;

import model.Command;
import model.commands.CHelp;
import model.commands.CPing;
import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class ChatListener extends ListenerAdapter {
    private static final Logger L = Logger.getLogger(ChatListener.class.getName());
    private List<Command> commands;

    public ChatListener() {
        commands = new ArrayList<>();

        // Add all of the active commands
        commands.add(new CHelp("/help", commands));
        commands.add(new CPing("/ping"));
    }

    @Override
    public void onReady(ReadyEvent event) {
        L.info("ChatListener is enabled.");
    }

    /**
     * Handle all commands for the bot
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        logMessage(event);

        String message = event.getMessage().getContent();
        for (int i = 0; i < commands.size(); i++) {
            Command c = commands.get(i);

            if (message.equals(c.getTrigger())) {
                c.execute(event);
            }
        }
    }

    private void logMessage(MessageReceivedEvent event) {
        User author = event.getAuthor();
        Message message = event.getMessage();
        String msg = message.getContent();

        if (event.isFromType(ChannelType.TEXT)) {
            TextChannel textChannel = event.getTextChannel();
            Member member = event.getMember();
            String name = member.getEffectiveName();

            L.info(String.format("[%-5s][%-18s]<%s>: %s\n",
                    "CHAN",
                    textChannel.getName(),
                    name,
                    msg)
            );
        } else if (event.isFromType(ChannelType.PRIVATE)) {

            L.info(String.format("[%-5s]<%s>: %s\n",
                    "PRIV",
                    author.getName(),
                    msg));

        } else if (event.isFromType(ChannelType.GROUP)) {
            Group group = event.getGroup();
            String groupName = group.getName() != null ? group.getName() : "";

            L.info(String.format("[%-5s][%s]<%s>: %s\n",
                    "GROUP",
                    groupName,
                    author.getName(),
                    msg));
        }
    }
}
