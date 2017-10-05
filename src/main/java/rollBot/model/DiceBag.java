package rollBot.model;

import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceBag {
	private ArrayList<Die> diceArr;
	
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
			List<Roll> results = d.roll();
			for(Roll r : results)
				result.addRoll(r);
		}

		return result;
	}
}
