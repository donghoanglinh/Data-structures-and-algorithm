/**
 * object for testing
 * have two property: name sorting and total run time
 */

public class dataTest {
    private String name;
    private long time;

    public dataTest(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

}
