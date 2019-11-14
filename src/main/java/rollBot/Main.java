package rollBot;

import org.apache.commons.cli.*;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        PingCommand pingCommand = new PingCommand();
        DingCommand dingCommand = new DingCommand();
        RollCommand rollCommand = new RollCommand();
        CoinFlipCommand coinCommand = new CoinFlipCommand();

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        System.out.println("Bot started!");

        api.addMessageCreateListener(event -> {
            if (pingCommand.matchesPattern(event.getMessage().getContent())) {
                pingCommand.accept(event);
            }
            if (dingCommand.matchesPattern(event.getMessage().getContent())) {
                dingCommand.accept(event);
            }
            else if (rollCommand.matchesPattern(event.getMessage().getContent())) {
                rollCommand.accept(event);
            }
            else if (coinCommand.matchesPattern(event.getMessage().getContent())) {
                coinCommand.accept(event);
            }
        });
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
