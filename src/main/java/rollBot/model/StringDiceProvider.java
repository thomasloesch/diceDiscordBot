package rollBot.model;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class StringDiceProvider implements DiceProvider {
	
	private String diceStr;
	
	public StringDiceProvider() { }
	
	public StringDiceProvider(String s) {
		this();
		setString(s);
	}

	public void setString(String s) {
		if(StringUtils.isBlank(s)) throw new IllegalArgumentException("String cannot be null or empty.");
		
		diceStr = s;
	}
	
	public Die[] getDice() {
		return generateDiceArr();
	}
	
	private Die[] generateDiceArr() {
		if (diceStr == null) throw new IllegalStateException("String has not been set yet.");
		
		ArrayList<Die> dice = new ArrayList<Die>();
		
		String[] tokens = StringUtils.split(diceStr, ' ');
		
		for(String s : tokens) {
			if(s.charAt(0) != 'd') {
				String[] splitStr = StringUtils.split(s, 'd');
				// TODO - Make these tryParse instead for safety (either that or sanitize inputs)
				int count = Integer.parseInt(splitStr[0]);
				int sides = Integer.parseInt(splitStr[1]);
				
				for (int i = 0; i < count; i++) {
					dice.add(new Die(sides)); // TODO - Probably don't need to initialize n times here...
				}
			}
			else {
				dice.add(new Die(s));
			}
		}
		
		Die[] retval = new Die[dice.size()];
		
		return dice.toArray(retval);
	}
}
