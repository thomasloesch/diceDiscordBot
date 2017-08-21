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
		int total = 0;
		
		for(Die d : diceArr) {
			total += rand.nextInt(d.getSides()) + 1;
		}

		throw new NotImplementedException("Not complete yet.");

	}
}
