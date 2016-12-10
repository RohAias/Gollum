package model;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * A structure for a basic command.
 */
public abstract class Command {
    /**
     * A readable name for the command
     */
    private String name;

    /**
     * What the user sends to trigger this command
     */
    private String trigger;

    /**
     * Input from the user
     */
    private String[] parameters;

    /**
     * What the command will return when it is finished executing
     */
    private String response;

    /**
     * Whether or not command was successful
     */
    private boolean successful;

    /**
     * An explanation of how to use this command
     */
    private String usage;

    /**
     * Executes this command
     */
    public abstract void execute(MessageReceivedEvent event);

    public Command(String name, String trigger) {
        this.name = name;
        this.trigger = trigger;
        this.successful = false;
    }

    public String getName() {
        return name;
    }

    public String getTrigger() {
        return trigger;
    }

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public String getResponse() {
        return response;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
