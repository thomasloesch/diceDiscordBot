package rollBot;

import com.darichey.discord.CommandContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class PingCommand implements Consumer<CommandContext> {
    public static final String COMMAND_NAME = "ping";
    Logger logger = LoggerFactory.getLogger(PingCommand.class);

    @Override
    public void accept(CommandContext ctx) {
        logger.info("Ping command received!");
        ctx.getChannel().sendMessage("Pong!");
    }
}
