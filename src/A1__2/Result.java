package A1__2;

import java.util.ArrayList;

public class Result {
    private ArrayList<Integer> overallResult = new ArrayList<>();
    private int amount;
    private boolean allResultsReady = false;
    public Result(int _amount) {
        this.amount = _amount;
    }
    public synchronized void discardResult(int r) {
        this.overallResult.add(r);
        notify();
    }
    public synchronized int[] generateOverallResult() throws InterruptedException {
        while (this.amount < overallResult.size()) {
            wait();
        }
        return overallResult.stream().mapToInt(i -> i).toArray();
    }
}
