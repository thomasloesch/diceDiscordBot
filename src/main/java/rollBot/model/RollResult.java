package rollBot.model;

import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class RollResult {
    private List<Roll> rollList;

    public RollResult() {
        rollList = new ArrayList<>();
    }

    public int getTotal() {
        int total = 0;

        for(Roll r : rollList) {
            total += r.actual;
        }

        return total;
    }

    public void addRoll(int actual, int max) {
        Roll roll = new Roll(actual, max);
        rollList.add(roll);
    }

    private class Roll {
        public int actual;
        public int max;

        public Roll(int _actual, int _max) {
            actual = _actual;
            max = _max;
        }
    }
}
