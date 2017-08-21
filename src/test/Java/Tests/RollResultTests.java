package Tests;

import org.junit.Test;
import rollBot.model.RollResult;

import static org.junit.Assert.*;

public class RollResultTests {

    @Test
    public void TestConstructor() {
        RollResult testResult = new RollResult();

        assertNotNull(testResult);
    }

    @Test
    public void TestGetTotal() {
        RollResult testResult = new RollResult();
        testResult.addRoll(10, 20);
        testResult.addRoll(10, 20);

        int testValue = testResult.getTotal();

        assertEquals(20, testValue);
    }

    @Test
    public void TestToString() {
        RollResult testResult = new RollResult();
        testResult.addRoll(10, 20);
        testResult.addRoll(10, 20);

        String testValue = testResult.toString();

        assertEquals("10 + 10 = 20", testValue);
    }

    @Test
    public void TestToStringMax() {
        RollResult testResult = new RollResult();
        testResult.addRoll(10, 10);
        testResult.addRoll(10, 10);

        String testValue = testResult.toString();

        assertEquals("**10** + **10** = 20", testValue);
    }
}
