package rollBot.model;

public class Roll {
    private static String MAX_FORMAT = "**%s**";

    public int actual;
    public int max;

    public Roll() {}

    public Roll(int _actual, int _max) {
        actual = _actual;
        max = _max;
    }

    public String toString() {
        if(actual == max) {
            return String.format(MAX_FORMAT, actual);
        }
        else {
            return String.valueOf(actual);
        }
    }
}
