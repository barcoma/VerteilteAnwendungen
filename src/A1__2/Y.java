package A1__2;

import java.util.Random;

public class Y implements F{
    private int n = new Random().nextInt(100);
    public int f(int x) {
        n = n + x;
        return n;
    }
}
