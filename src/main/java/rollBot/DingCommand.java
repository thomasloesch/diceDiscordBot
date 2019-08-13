package rollBot;

import com.darichey.discord.CommandContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class DingCommand implements Consumer<CommandContext> {
    public static final String COMMAND_NAME = "ding";
    private Logger logger = LoggerFactory.getLogger(DingCommand.class);

    @Override
    public void accept(CommandContext ctx) {
        logger.info("Ding command received!");
        ctx.getChannel().sendMessage("Dong!");
    }
}
