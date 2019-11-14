package rollBot;

import org.javacord.api.event.message.MessageCreateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rollBot.model.DiceBag;
import rollBot.model.DiceProvider;
import rollBot.model.RollResult;
import rollBot.model.StringDiceProvider;

import java.util.Arrays;
import java.util.List;

public class RollCommand {
    private static final int RESULT_LIMIT = 2000;
    public static final String COMMAND_NAME = "roll";
    private static final String ERROR_EMOJI_NAME = "❌";
    Logger logger = LoggerFactory.getLogger(RollCommand.class);

    public boolean matchesPattern(String message) {
        return message.matches("/roll .*");
    }

    public void accept(MessageCreateEvent ctx) {
        List<String> arguments = Arrays.asList(ctx.getMessage().getContent().split(" "));

        StringBuilder allArguments = new StringBuilder();

        boolean verboseResult = true;

        for (String a : arguments) {
            if (a.startsWith("-")) {
                a = a.replaceFirst("-", "");
                if (a.equals("t")) {
                    verboseResult = false;
                }
            }
            else if (a.equals("/roll") || a.equals(" ")) { continue; }
            else {
                allArguments.append(a + " ");
            }
        }

        logger.info("Roll Command recieved w/ args: " + allArguments);
        try {
            DiceProvider diceProvider = new StringDiceProvider(allArguments.toString());

            DiceBag bag = new DiceBag(diceProvider);
            RollResult result = bag.roll();
            String resultString = result.getResultString(verboseResult);

            if (resultString.length() > RESULT_LIMIT) {
                resultString = result.getResultString(false);
                resultString += " (Result was too large, terse output given instead)";
            }

            ctx.getChannel().sendMessage(String.format("Result: %s", resultString));
        } catch (Exception e) {
            e.printStackTrace();
            ctx.getMessage().addReaction(ERROR_EMOJI_NAME);
        }
    }
}
