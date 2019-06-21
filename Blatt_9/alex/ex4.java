import java.lang.Math;

public class ex4 {
    public static void main(String[] args) {
        int[] q1 = new int[250000];
        int[] q2 = new int[250000];
        int[] q3 = new int[250000];
        int[] q4 = new int[250000];

        //init arrays
        for(int i=1; i<=1000000;i++) {
            if(i<=250000) q1[i-1]=i;
            else if (i<=500000) q2[i-250000-1]=i;
            else if (i<=750000) q3[i-500000-1]=i;
            else if (i<=1000000) q4[i-750000-1]=i;
        }

        HarshadThread h1 = new HarshadThread(q1);
        HarshadThread h2 = new HarshadThread(q2);
        HarshadThread h3 = new HarshadThread(q3);
        HarshadThread h4 = new HarshadThread(q4);

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 = new Thread(h3);
        Thread t4 = new Thread(h4);

        long before = System.currentTimeMillis();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        while(t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive()){}
        
        long time = System.currentTimeMillis() - before;
        System.out.println("Done in " + time + "ms");
    }
}

class Harshad {
    static boolean isHarshad(int x) {
        if ((x % Harshad.crossSum(x)) == 0) return true;
        else return false;
    }

    static int crossSum(int x) {
        int sum=0;
        while(x > 0) {
            sum+= x % 10;
            x/= 10;
        }
        return sum;
    }
}

class HarshadThread implements Runnable {
    int[] data;

    public HarshadThread(int[] data) {
        this.data = data;
    }

    public void run() {
        for(int e : data) {
            HarshadThread.isHarshad(e);
        }
    }

    static boolean isHarshad(int x) {
        if ((x % Harshad.crossSum(x)) == 0) return true;
        else return false;
    }
}