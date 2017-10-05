package rollBot.model;

import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.Random;

public class DiceBag {
	private ArrayList<Die> diceArr;
	private Random rand;
	
	public DiceBag() {}
	
	public DiceBag(DiceProvider diceProvider) {
		this();
		setDiceProvider(diceProvider);
	}
	
	public void setDiceProvider(DiceProvider diceProvider) {
		diceArr = new ArrayList<Die>();
		
		for(Die d : diceProvider.getDice()) {
			diceArr.add(d);
		}
	}
	
	public RollResult roll() {
		RollResult result = new RollResult();
		
		for(Die d : diceArr) {
			result.addRoll(d.roll());
		}

		return result;
	}
}
