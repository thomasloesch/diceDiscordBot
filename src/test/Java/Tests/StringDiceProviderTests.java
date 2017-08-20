package Tests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import rollBot.model.*;

import org.junit.Test;

public class StringDiceProviderTests {
	private final String testStr = "d4 d6 2d8"; 

	@Test
	public void TestGetDice() {
		StringDiceProvider testProvider = new StringDiceProvider(testStr);
		
		Die[] testArr = testProvider.getDice();
		
		Assert.assertTrue(testArr.length == 4);
	}

}
