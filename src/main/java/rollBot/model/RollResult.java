package rollBot.model;

import java.util.ArrayList;
import java.util.List;

public class RollResult {
    private static final String DELIMITER = "+";

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
        addRoll(roll);
    }
    public void addRoll(Roll roll) {
        rollList.add(roll);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (rollList.size() == 1) {
            builder.append(rollList.get(0).toString());
        }
        else if (rollList.size() > 1) {
            for (Roll r : rollList){
                builder.append(r.toString());
                builder.append(" " + DELIMITER + " ");
            }

            int lastPos = builder.lastIndexOf(DELIMITER);
            builder.replace(lastPos, lastPos + 1, "="); // TODO - Make that shit a constant
            builder.append(getTotal());
        }

        return builder.toString();
    }
}
