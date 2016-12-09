package controller;

import model.commands.CHelp;
import model.commands.Command;
import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatListener extends ListenerAdapter {
    List<Command> commands;

    public ChatListener() {
        commands = new ArrayList<>();

        // Add all of the active commands
        commands.add(new CHelp("/help"));
    }

    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("Gollum Ready");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String msg = message.getContent();

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
}
