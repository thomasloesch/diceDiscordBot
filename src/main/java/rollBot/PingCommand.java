package rollBot;

import org.javacord.api.event.message.MessageCreateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingCommand {
    public static final String COMMAND_NAME = "ping";
    private Logger logger = LoggerFactory.getLogger(PingCommand.class);

    public boolean matchesPattern(String message) {
        return message.matches("/ping.*");
    }

    public void accept(MessageCreateEvent ctx) {
        logger.info("Ping command received!");
        ctx.getChannel().sendMessage("Pong!");
    }
}
