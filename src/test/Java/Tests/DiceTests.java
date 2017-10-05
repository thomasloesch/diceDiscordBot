package Tests;

import junit.framework.Assert;

import org.junit.Test;

import rollBot.model.Die;
import rollBot.model.Roll;

import static org.junit.Assert.*;

public class DiceTests {

	@Test
	public void TestDice() {
		Die testDie;
		
		testDie = new Die(1, 4);

		assertEquals("1d4", testDie.toString());
	}
	
	@Test
	public void TestDiceStr() {
		Die testDie;
		
		testDie = new Die("1d4");

		assertEquals("1d4", testDie.toString());
	}

	@Test
	public void TestDiceMultiple() {
		Die testDie;
		
		testDie = new Die(2, 4);
		
		assertEquals("2d4", testDie.toString());
	}

	@Test
	public void TestDiceRoll() {
		Die testDie = new Die(2, 4);

		Roll testResult = testDie.roll();

		assertNotNull(testResult);
	}

}
