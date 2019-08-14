package rollBot;

import com.darichey.discord.Command;
import com.darichey.discord.CommandListener;
import com.darichey.discord.CommandRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.cli.*;
import sx.blah.discord.api.*;
import sx.blah.discord.api.events.EventDispatcher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String DEFAULT_COMMAND_PREFIX = "/";
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    private static Options options = populateOptions();

    public static void main(String[] args) {
        logger.info("Starting bot...");

        String token = "";

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("t")) {
                token = cmd.getOptionValue("t");
            } else if (cmd.hasOption("f")) {
                try (BufferedReader fileReader
                             = new BufferedReader(new FileReader(cmd.getOptionValue("f")))) {
                    token = fileReader.readLine();
                } catch (IOException e) {
                    exitWithErrorMessage("There was an error attempting to read the given file...", e);
                }
            } else {
                printUsage();
                System.exit(0);
            }
        } catch (ParseException e){
            exitWithErrorMessage("There was an error attempting to parse the command line arguments...", e);
        }

        logger.info("Creating client with token {}", token);
        IDiscordClient client =  BotUtils.getBuiltDiscordClient(token);
        EventDispatcher dispatcher = client.getDispatcher();
        //dispatcher.registerListener(new InterfaceListener());
        //dispatcher.registerListener(new AnnotationListener());

        CommandRegistry registry = createCommandRegistry();
        CommandListener cmdListener = new CommandListener(registry);
        dispatcher.registerListener(cmdListener);

        client.login();
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
        
        Command ding = Command.builder()
                .oncCalled(new DingCommand())
                .build();
        
        registry.register(ding, DingCommand.COMMAND_NAME);
        
        Command roll = Command.builder()
                .onCalled(new RollCommand())
                .build();

        registry.register(roll, RollCommand.COMMAND_NAME);

        Command coin = Command.builder()
                .onCalled(new CoinFlipCommand())
                .build();

        registry.register(coin, CoinFlipCommand.COMMAND_NAME);
    }

    private static Options populateOptions() {
        Options options = new Options();

        options.addOption("t", "token", true, "Bot token string.");
        options.addOption("f", "file", true, "Path to a file containing the bot token string.");

        return options;
    }

    private static void exitWithErrorMessage(String message, Exception e) {
        logger.error(message, e);
        logger.error("Exiting.");
        System.exit(1);
    }

    private static void printUsage() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "diceDiscordBot", options );
    }
}
