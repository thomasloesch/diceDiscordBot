package Tests;

import junit.framework.Assert;

import org.junit.Test;

import rollBot.model.Die;

public class DiceTests {

	@Test
	public void TestDice() {
		Die testDie;
		
		testDie = new Die(4);
		
		Assert.assertNotNull(testDie);
	}
	
	@Test
	public void TestDiceStr() {
		Die testDie;
		
		testDie = new Die("d4");
		
		Assert.assertNotNull(testDie);
	}

	@Test
	public void TestToString() {
		Die testDie;
		
		testDie = new Die(4);
		
		Assert.assertEquals("d4", testDie.toString());
	}

}
