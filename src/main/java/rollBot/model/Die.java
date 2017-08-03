package rollBot.model;

public class Die {
	private int sides;
	
	public Die(int s) {
		setSides(s);
	}
	
	public int getSides() { return sides; }
	
	public void setSides(int s) {
		if(s < 0) throw new IllegalArgumentException(String.format("%s is smaller than 0", s));
		
		sides = s;
	}
	
	public String toString() {
		return String.format("d%s", sides);
	}
}
