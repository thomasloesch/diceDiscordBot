package rollBot.model;

import java.util.ArrayList;
import java.util.Random;

public class DiceBag {
	private ArrayList<Die> diceArr;
	private Random rand;
	
	public DiceBag() {	
		rand = new Random(new java.util.Date().getTime());
	}
	
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
	
	public int roll() {
		int total = 0;
		
		for(Die d : diceArr) {
			total += rand.nextInt(d.getSides()) + 1;
		}
		
		return total;
	}
}
