package rollBot;

import com.darichey.discord.CommandContext;

import java.util.function.Consumer;

public class PingCommand implements Consumer<CommandContext> {
    public static final String COMMAND_NAME = "ping";

    @Override
    public void accept(CommandContext ctx) {
        ctx.getChannel().sendMessage("Pong!");
    }
}
