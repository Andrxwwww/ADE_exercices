import java.util.Random;
public class InsertionUpdated {
    //A TABELA ESTÁ NO FINAL
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            Comparable v = a[i];
            int j;
            for (j = i ; j > 0 && less(v, a[j - 1]); j--) {
                a[j] = a[j-1];
            }
            a[j] = v;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    Comparable[] randomArr(int n){
        Comparable[] f = new Comparable[n];
        Random rand = new Random();
        for (int i = 0; i<f.length ; i++) {
            f[i]= rand.nextInt(10000);
        }
        return f;
    }



    public static void main(String[] args) {

        InsertionUpdated IU = new InsertionUpdated();

        long PreviousElapsedTime = 0;

        Comparable[] arr5000 = IU.randomArr(5000);
        Comparable[] arr10000 = IU.randomArr(10000);
        Comparable[] arr20000 = IU.randomArr(20000);
        Comparable[] arr40000 = IU.randomArr(40000);
        Comparable[] arr80000 = IU.randomArr(80000);
        Comparable[] arr160000 = IU.randomArr(160000);

        Comparable[][] arrays = {arr5000, arr10000, arr20000, arr40000, arr80000, arr160000};

        for (Comparable[] arr : arrays) {

            long start = System.currentTimeMillis();

            IU.sort(arr);

            long end = System.currentTimeMillis();

            long elapsedTime = end - start;

            if (PreviousElapsedTime != 0 ){
                double ratio =  (elapsedTime / (double) PreviousElapsedTime);
                double ratioinLog = (double) Math.log(ratio)/Math.log(2);
                System.out.println("arr" + "-" + elapsedTime + "ms-" + ratio + "-" +ratioinLog);
            }else{
                System.out.println("arr" + "-" + elapsedTime + "ms-" );
            }
            PreviousElapsedTime = elapsedTime;

        }
    }
}

/*

+-----------+---------+-------+-----------+
|   arrN    |  Time   | ratio | lg(ratio) |
+-----------+---------+-------+-----------+
| arr5000   | 22ms    |       |           |
| arr10000  | 70ms    |  3.18 |      1.67 |
| arr20000  | 290ms   |  4.14 |      2.05 |
| arr40000  | 1224ms  |  4.22 |      2.08 |
| arr80000  | 6381ms  |  5.21 |      2.38 |
| arr160000 | 26246ms |  4.11 |      2.04 |
+-----------+---------+-------+-----------+

Como podemos verificar o lg(ratio) tende para ~~2 logo a sua ordem de eficiÊncia é de cerca O(N²) se nao estiver ordenada
comparadamente com a teórica O(N²/4) conluimos que a empirica e a teorica sao maioritariamente idênticas.
*/