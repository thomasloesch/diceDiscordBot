package Tests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import rollBot.model.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringDiceProviderTests {
	private final String testStr = "1d4 1d6 2d8";
	private final List<String> testList = Arrays.asList(testStr.split(" "));

	@Test
	public void TestStrConstuctor() {
		StringDiceProvider testProvider = new StringDiceProvider(testStr);

		assertNotNull(testProvider);
	}

	@Test
	public void TestGetDice() {
		// TODO - Rewrite this test
		StringDiceProvider testProvider = new StringDiceProvider(testList);
		
		Die[] testArr = testProvider.getDice();
		
		assertEquals(4, testArr.length);
	}

}
