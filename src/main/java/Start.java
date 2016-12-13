import controller.ChatListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class Start {

    public static void main(String[] args) {

        JDA jda;

        try {
            jda = new JDABuilder(AccountType.BOT)
                    .addListener(new ChatListener()).setToken(//add token here)
                    .buildBlocking();
            jda.setAutoReconnect(true);
        } catch (LoginException e) {
            System.err.println("Authentication Failed...");
        } catch (InterruptedException e) {
            System.err.println("Initialization Terminated...");
        } catch (RateLimitedException e) {
            System.err.println("Too many Login requests.");
        }
    }
}
