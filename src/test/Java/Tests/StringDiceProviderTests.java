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

		Die[] testArr = testProvider.getDice();
		assertEquals(3, testArr.length);
	}

	@Test
	public void TestNoLeadingNumber() {
		StringDiceProvider testProvider = new StringDiceProvider("d20");

		assertNotNull(testProvider);
	}

	@Test
	public void TestGetDice() {
		// TODO - Rewrite this test
		StringDiceProvider testProvider = new StringDiceProvider(testList);
		
		Die[] testArr = testProvider.getDice();

		assertEquals(2, testArr[2].getNum());
	}

}
