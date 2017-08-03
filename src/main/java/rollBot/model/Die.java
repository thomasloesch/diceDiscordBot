package rollBot.model;

public class Die {
	private int sides;
	
	public Die(int s) {
		setSides(s);
	}
	public Die(String str) {
		setSides(str);
	}
	
	public int getSides() { return sides; }
	
	public void setSides(int s) {
		if(s < 0) throw new IllegalArgumentException(String.format("%s is smaller than 0", s));
		
		sides = s;
	}
	public void setSides(String str) {
		int intVal = 0;
		
		String intStr = str.substring(1);
		intVal = Integer.parseInt(intStr);
		
		setSides(intVal);
	}
	
	public String toString() {
		return String.format("d%s", sides);
	}
}
