package Tests;

import rollBot.model.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DiceBagTests {
	private TestDiceProvider testDiceProvider;
	private final String MAX_ROLL_RESULT = "**20** + **20** = 40";
	private final Die[] DICE_ARR = new Die[] {
		new Die(1, 1),
		new Die(1, 1),
		new Die(1, 1)
		};

	private final Die[] DICE_ARR_TWENTY = new Die[] {
		new Die(1, 20),
		new Die(1, 20)
		};
	
	@Before
	public void beforeStep() {
		testDiceProvider = new TestDiceProvider(DICE_ARR);
	}
	

	@Test
	public void rollTest() {
		DiceBag bag = new DiceBag(testDiceProvider);
		
		RollResult testResult = bag.roll();
		
		Assert.assertTrue(testResult.getTotal() == 3);
	}

}
