package A1_2;

public class Main {

    public static void main(String[] args) {
        F f = new Y();
        int[] arr = execute(f, 10);
        for(int value : arr){
            System.out.println(+value);
        }
    }

    public static int[] execute(F f, int n) {

        Result r = new Result();
        for(int i = 0; i <= n; i++) {
            NewThread t = new NewThread(f, i, r);
            t.start();
        }

        return r.getOverallResult();
    }

}
