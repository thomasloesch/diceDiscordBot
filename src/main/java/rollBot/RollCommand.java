package rollBot;

import com.darichey.discord.CommandContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rollBot.model.*;

import java.util.List;
import java.util.function.Consumer;

public class RollCommand implements Consumer<CommandContext> {
    private static final int RESULT_LIMIT = 2000;
    public static final String COMMAND_NAME = "roll";
    Logger logger = LoggerFactory.getLogger(RollCommand.class);

    @Override
    public void accept(CommandContext ctx) {
        List<String> arguments = ctx.getArgs();

        StringBuilder allArguments = new StringBuilder();

        boolean verboseResult = true;

        for (String a : arguments) {
            if(a.startsWith("-")) {
                a = a.replaceFirst("-", "");
                if (a.equals("t")) {
                    verboseResult = false;
                }
            }
            else {
                allArguments.append(a + " ");
            }
        }

        logger.info("Roll Command recieved w/ args: " + allArguments);

        DiceProvider diceProvider = new StringDiceProvider(allArguments.toString());

        DiceBag bag = new DiceBag(diceProvider);
        RollResult result = bag.roll();
        String resultString = result.getResultString(verboseResult);

        if(resultString.length() > RESULT_LIMIT) {
            resultString = result.getResultString(false);
            resultString += " (Result was too large, terse output given instead)";
        }

        ctx.getChannel().sendMessage(String.format("Result: %s", resultString));
    }
}
