package rollBot;

import org.javacord.api.event.message.MessageCreateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DingCommand {
    public static final String COMMAND_NAME = "ding";
    private Logger logger = LoggerFactory.getLogger(DingCommand.class);

    public boolean matchesPattern(String message) {
        return message.matches("/ding.*");
    }

    public void accept(MessageCreateEvent ctx) {
        logger.info("Ding command received!");
        ctx.getChannel().sendMessage("Dong!");
    }
}
