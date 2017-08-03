package Tests;

import junit.framework.Assert;

import org.junit.Test;

import rollBot.model.Die;

public class DiceTests {

	@Test
	public void testDice() {
		Die testDie;
		
		testDie = new Die(4);
		
		Assert.assertNotNull(testDie);
	}

	@Test
	public void testToString() {
		Die testDie;
		
		testDie = new Die(4);
		
		Assert.assertEquals("d4", testDie.toString());
	}

}
