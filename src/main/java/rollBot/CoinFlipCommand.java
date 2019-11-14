package rollBot;

import org.javacord.api.event.message.MessageCreateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class CoinFlipCommand {
    public static final String COMMAND_NAME = "coinflip";
    Logger logger = LoggerFactory.getLogger(CoinFlipCommand.class);

    private static Random rand = new Random();

    private static final String HEAD_MSG = "Heads!";
    private static final String TAIL_MSG = "Tails!";

    public boolean matchesPattern(String message) {
        return message.matches("/coinflip.*");
    }

    public void accept(MessageCreateEvent commandContext) {
        logger.info("Coin flip command received!");

        int result = rand.nextInt(2);

        if(result == 0) {
            commandContext.getChannel().sendMessage(HEAD_MSG);
        } else {
            commandContext.getChannel().sendMessage(TAIL_MSG);
        }
    }
}
