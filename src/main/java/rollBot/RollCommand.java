package rollBot;

import com.darichey.discord.CommandContext;
import rollBot.model.DiceBag;
import rollBot.model.DiceProvider;
import rollBot.model.StringDiceProvider;

import java.util.List;
import java.util.function.Consumer;

public class RollCommand implements Consumer<CommandContext> {
    public static final String COMMAND_NAME = "roll";

    @Override
    public void accept(CommandContext ctx) {
        List<String> arguments = ctx.getArgs();

        String allArguments = "";

        for (String a : arguments) {
            allArguments += a;
        }

        DiceProvider diceProvider = new StringDiceProvider(allArguments);

        DiceBag bag = new DiceBag(diceProvider);

        ctx.getChannel().sendMessage(String.format("Result: %s", bag.roll()));
    }
}
