package A1_2;

import java.util.ArrayList;

public class Result {

    private boolean allFinished = false;
    private ArrayList<Integer> results = new ArrayList<>();

    public synchronized void addResult(int r) throws InterruptedException
    {
        while(!allFinished) {
            wait();
            this.results.add(r);
        }
    }

    public synchronized int[] getOverallResult(){
        allFinished = true;
        while (allFinished){
            notifyAll();
        }
        return results.stream().mapToInt(i -> i).toArray();
    }

}