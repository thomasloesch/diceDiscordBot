package rollBot.model;

public class Roll {
    private static String CRIT_FORMAT = "**%s**";

    public int actual;
    public int max;

    public Roll() {}

    public Roll(int _actual, int _max) {
        actual = _actual;
        max = _max;
    }

    public String toString() {
        if(actual == max || actual == 1) {
            return String.format(CRIT_FORMAT, actual);
        }
        else {
            return String.valueOf(actual);
        }
    }
}
