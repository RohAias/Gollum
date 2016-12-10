package controller;

import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import model.commands.CHelp;
import model.commands.CPing;
import model.commands.Command;


public class ChatListener extends ListenerAdapter {
    private static final Logger L = Logger.getLogger(ChatListener.class.getName());
    private List<Command> commands;

    public ChatListener() {
        commands = new ArrayList<>();

        // Add all of the active commands
        commands.add(new CHelp("/help"));
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
        User author = event.getAuthor();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String msg = message.getContent();

        {
            /* FIXME Everything in this block should be in a function.
             * - Each method should do one thing, and one thing only. The body of a method
             *   shouldn't contain logic for more than one thing you want to do.
             * - The reason behind that is because it makes the code more maintainable
             *   each body of logic you create should be testable on it's own without
             *   relying on other pieces of code ( or at least the minimum amount of other code ).
             */

            if (event.isFromType(ChannelType.TEXT)) {
                Guild guild = event.getGuild();
                TextChannel textChannel = event.getTextChannel();
                Member member = event.getMember();
                String name = member.getEffectiveName();

                System.out.printf("(%s)[%s]<%s>: %s\n", guild.getName(),
                        textChannel.getName(), name, msg);
            } else if (event.isFromType(ChannelType.PRIVATE)) {

                System.out.printf("[PRIV]<%s>: %s\n", author.getName(), msg);
            } else if (event.isFromType(ChannelType.GROUP)) {
                Group group = event.getGroup();
                String groupName = group.getName() != null ? group.getName() : "";

                System.out.printf("[GRP: %s]<%s>: %s\n", groupName,
                        author.getName(), msg);
            }
        }

        // FIXME Write this in a way that we don't have to come back and maintain this code.
        // ( it involves looping through the "commands" variable )
        //Where we want to call /help command.
        if (msg.contains("/help")) {

        }
    }
}
