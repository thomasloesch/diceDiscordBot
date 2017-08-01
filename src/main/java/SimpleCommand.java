import com.sun.org.apache.xalan.internal.xsltc.runtime.MessageHandler;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.modules.IModule;

public class SimpleCommand implements IModule {

    private String moduleName = "SimpleCommand";
    private String moduleVersion = "1.0";
    private String moduleMinimumVersion = "2.3.8";
    private String author = "Ziggli";
    public static IDiscordClient client;

    public boolean enable(IDiscordClient dClient) {
        client = dClient;
        EventDispatcher dispatcher = client.getDispatcher();
        dispatcher.registerListener(new MessageHandler());
        return true;
    }

    public void disable() {

    }

    public String getName() {
        return moduleName;
    }

    public String getAuthor() {
        return author;
    }

    public String getVersion() {
        return moduleVersion;
    }

    public String getMinimumDiscord4JVersion() {
        return moduleMinimumVersion;
    }
}
