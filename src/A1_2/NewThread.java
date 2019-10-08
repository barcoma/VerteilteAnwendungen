package A1_2;

public class NewThread extends Thread  {

    private int n;
    private F f;
    private Result r;

    NewThread(F _f, int _n, Result _r){
        this.n = _n;
        this.f= _f;
        this.r = _r;
    }

    public void run() {
        System.out.println("Thread running" + n);
        try {
            r.addResult(f.f(n));
        } catch (InterruptedException e) {
            System.out.print("Error");
        }
    }
}
