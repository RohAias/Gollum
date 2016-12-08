package controller;

import model.commands.CHelp;
import model.commands.Command;
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
    public void onMessageReceived(MessageReceivedEvent event) {
//        if (event.getMessage())
    }
}
