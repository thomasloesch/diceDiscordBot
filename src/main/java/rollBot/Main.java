package rollBot;
import com.darichey.discord.Command;
import com.darichey.discord.CommandListener;
import com.darichey.discord.CommandRegistry;
import sx.blah.discord.api.*;
import sx.blah.discord.api.events.EventDispatcher;

public class Main {
    private static final String DEFAULT_COMMAND_PREFIX = "!";

    public static void main(String[] args) {
        IDiscordClient client = createClient(args[0], true);
        EventDispatcher dispatcher = client.getDispatcher();
        //dispatcher.registerListener(new InterfaceListener());
        //dispatcher.registerListener(new AnnotationListener());

        CommandRegistry registry = createCommandRegistry();
        CommandListener cmdListener = new CommandListener(registry);
        dispatcher.registerListener(cmdListener);

    }

    private static IDiscordClient createClient(String token, boolean login){
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.withToken(token);
        try {
            if(login) {
                return clientBuilder.login();
            } else {
                return clientBuilder.build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static CommandRegistry createCommandRegistry() {
        CommandRegistry registry = new CommandRegistry(DEFAULT_COMMAND_PREFIX);
        populateCommandRegistry(registry);
        return registry;
    }

    private static void populateCommandRegistry(CommandRegistry registry) {
        Command ping = Command.builder()
                .onCalled(new PingCommand())
                .build();

        registry.register(ping, PingCommand.COMMAND_NAME);

        Command roll = Command.builder()
                .onCalled(new RollCommand())
                .build();

        registry.register(roll, RollCommand.COMMAND_NAME);
    }
}
