package rollBot.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringDiceProvider implements DiceProvider {
	
	private List<String> diceList;
	
	public StringDiceProvider() { }
	
	public StringDiceProvider(String s) {
		this();
		setString(s);
	}

	public StringDiceProvider(List<String> list) {
		this();
		setList(list);
	}

	public void setString(String s) {
		if(StringUtils.isBlank(s)) throw new IllegalArgumentException("String cannot be null or empty.");
		
		diceList = splitString(s);
	}

	public void setList(List<String> list) {
		if(list == null) throw new IllegalArgumentException("List cannot be null.");

		diceList = list;
	}
	
	public Die[] getDice() {
		return generateDiceArr();
	}

	private List<String> splitString (String str) {
		return Arrays.asList(str.split(" "));
	}
	
	private Die[] generateDiceArr() {
		if (diceList == null) throw new IllegalStateException("String has not been set yet.");
		
		ArrayList<Die> dice = new ArrayList<Die>();
		
		for(String s : diceList) {
			if(s.charAt(0) != 'd') {
				String[] splitStr = StringUtils.split(s, 'd');
				// TODO - Make these tryParse instead for safety (either that or sanitize inputs)
				int count = Integer.parseInt(splitStr[0]);
				int sides = Integer.parseInt(splitStr[1]);

				dice.add(new Die(count, sides));
			}
			else {
				dice.add(new Die(s));
			}
		}
		
		Die[] retval = new Die[dice.size()];
		
		return dice.toArray(retval);
	}
}
