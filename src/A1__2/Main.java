package A1__2;

public class Main {

    public static int amountOfCalculations = 10;

    public static void main(String[] args) {
        F f = new Y();
        int[] arr = execute(f, amountOfCalculations);
        if (arr != null) {
            for (int value : arr) {
                System.out.println(value);
            }
        }
    }
    public static int[] execute(F f, int n) {
        Result r = new Result(amountOfCalculations);
        for (int i = 0; i < n; i++) {
            NewThread t = new NewThread(i, f, r);
            t.start();
        }
        try {
            return r.generateOverallResult();
        } catch (InterruptedException e) {
            return null;
        }
    }
}