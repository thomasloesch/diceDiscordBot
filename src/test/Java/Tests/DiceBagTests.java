package Tests;

import rollBot.model.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiceBagTests {
	private TestDiceProvider testDiceProvider;
	private final Die[] diceArr = new Die[] {
		new Die(1),
		new Die(1),
		new Die(1)
		};
	
	@Before
	public void beforeStep() {
		testDiceProvider = new TestDiceProvider(diceArr);
	}
	

	@Test
	public void rollTest() {
		DiceBag bag = new DiceBag(testDiceProvider);
		
		int testVal = bag.roll();
		
		Assert.assertTrue(testVal == 3);
	}

}
