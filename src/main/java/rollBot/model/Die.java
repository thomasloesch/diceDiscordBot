package rollBot.model;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Random;

public class Die {
    private static final String REGEX_STR = "^\\d+d\\d+";
    private static final Random rand = new Random(new java.util.Date().getTime());

	private int sides;
	private int num;
	
	public Die(int n, int s) {
	    setNum(n);
		setSides(s);
	}
	public Die(String str) {
		setString(str);
	}
	
	public int getSides() { return sides; }

	public void setNum(int n) {
        if(n < 0) throw new IllegalArgumentException(String.format("Num is too small: %s is smaller than 0", n));

        num = n;
    }

	public void setSides(int s) {
		if(s < 0) throw new IllegalArgumentException(String.format("Sides is too small: %s is smaller than 0", s));
		
		sides = s;
	}

	public void setString(String str) {
        if(!str.matches(REGEX_STR))
            throw new IllegalArgumentException(String.format("Input '%s' does not match expression %s.", str, REGEX_STR));

		int intVal = 0;

		String[] intValueStrings = str.split("d");
		int numVal = Integer.parseInt(intValueStrings[0]);
        int sidesVal = Integer.parseInt(intValueStrings[1]);
		setNum(numVal);
		setSides(sidesVal);
	}

	public RollResult roll() {
	    RollResult result = new RollResult();

	    for(int i = 0; i < num; i++) {
            result.addRoll(rand.nextInt(sides) + 1, sides);
        }

        return result;
    }
	
	public String toString() {
		return String.format("%sd%s", num, sides);
	}
}
