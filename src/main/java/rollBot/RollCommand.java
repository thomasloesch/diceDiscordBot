package rollBot;

import com.darichey.discord.CommandContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rollBot.model.*;

import java.util.List;
import java.util.function.Consumer;

public class RollCommand implements Consumer<CommandContext> {
    public static final String COMMAND_NAME = "roll";
    Logger logger = LoggerFactory.getLogger(RollCommand.class);

    @Override
    public void accept(CommandContext ctx) {
        List<String> arguments = ctx.getArgs();

        StringBuilder allArguments = new StringBuilder();

        for (String a : arguments) {
            allArguments.append(a + " ");
        }

        logger.info("Roll Command recieved w/ args: " + allArguments);

        DiceProvider diceProvider = new StringDiceProvider(allArguments.toString());

        DiceBag bag = new DiceBag(diceProvider);
        RollResult result = bag.roll();

        ctx.getChannel().sendMessage(String.format("Result: %s", result.getResultString(true)));
    }
}
