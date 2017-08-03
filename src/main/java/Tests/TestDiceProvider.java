package Tests;

import rollBot.model.Die;
import rollBot.model.DiceProvider;

public class TestDiceProvider implements DiceProvider {
	private Die[] diceArr;
	
	public TestDiceProvider(Die[] dice) {
		diceArr = dice;
	}

	public Die[] getDice() {
		return diceArr;
	}
}
