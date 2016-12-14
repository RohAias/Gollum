import controller.ChatListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Properties;

public class Gollum {
    private Properties settings;

    public Gollum() {
        loadSettings();

        JDA jda;

        try {
            jda = new JDABuilder(AccountType.BOT)
                    .addListener(new ChatListener())
                    .setToken(settings.getProperty("token"))
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

    private void loadSettings() {
        try {
            settings = new Properties();

            settings.load(getClass().getResourceAsStream("/settings.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
