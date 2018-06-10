package rollBot;

import com.darichey.discord.CommandContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.function.Consumer;

public class CoinFlipCommand implements Consumer<CommandContext> {
    public static final String COMMAND_NAME = "coinflip";
    Logger logger = LoggerFactory.getLogger(CoinFlipCommand.class);

    private static Random rand = new Random();

    private static final String HEAD_MSG = "Heads!";
    private static final String TAIL_MSG = "Tails!";

    @Override
    public void accept(CommandContext commandContext) {
        int result = rand.nextInt(2);

        if(result == 0) {
            commandContext.getChannel().sendMessage(HEAD_MSG);
        } else {
            commandContext.getChannel().sendMessage(TAIL_MSG);
        }
    }
}
