import java.lang.Math;
import java.util.ArrayList;

public class ex1 {
    public static void main(String[] args) {
        ArrayList<Integer> gerade,ungerade;
        gerade = new ArrayList<Integer>();
        ungerade = new ArrayList<Integer>();
        for(int i=2; i<100000; i++){
            if(i % 2 ==0) gerade.add(i);
            else ungerade.add(i);
        }

        int[] e,u;
        e= new int[gerade.size()];
        u= new int[ungerade.size()];

        for(int i=0; i<gerade.size();i++) e[i] = gerade.get(i);
        for(int i=0; i<ungerade.size();i++) u[i] = ungerade.get(i);

        PrimThread even, uneven;
        even = new PrimThread(e);
        uneven = new PrimThread(u);


        //taking time
        long before = System.currentTimeMillis();

        even.start();
        uneven.start();


        while(even.isAlive() || uneven.isAlive()) {}

        long after = System.currentTimeMillis();

        long diff= after-before;

        
        System.out.println("\nelapsed time with threads: " + diff + "ms");


        
        before = System.currentTimeMillis();

        for(int element: e) Primfaktor.printPrimfaktoren(element);
        for(int element: u) Primfaktor.printPrimfaktoren(element);

        after=System.currentTimeMillis();
        diff= after-before;

        System.out.println("\nelapsed time without threads: " + diff + "ms");

    }
}

class Primfaktor {
    public static void allbetween(int a, int b) {
        if(a>b) {
            System.err.println("can't find primalfactors between " + a + " and " + b + " because " + a + " > " +  b);
        }
        else {
            for(int i=a; i<=b;i++) {
                System.out.println("\nPrimfaktoren von " + i + ":");
                Primfaktor.printPrimfaktoren(i);
            }
        }
    }

    static void printPrimfaktoren(int a) {
        int loca = a;
        if (a==1) {
            //System.out.println("1");
            return;
        }
        for(int i=2; i<=a;i++) {
            if(loca % i == 0) {
                loca /= i;
                //if(loca == 1) System.out.println(i);
                //else System.out.print(i + " * ");
                i=1;
            }
        }
    }
}

class PrimThread extends Thread {
    int[] arr;

    public PrimThread (int[] arr) {
        this.arr=arr;
    }


    public void run() {
        for(int number : arr) {
            PrimThread.printPrimfaktoren(number);
        }
    }

    static void printPrimfaktoren(int a) {
        int loca = a;
        //System.out.println("\nPrimfaktoren von " + a + ":");
        if (a==1) {
            System.out.println("1");
            return;
        }
        for(int i=2; i<=a;i++) {
            if(loca % i == 0) {
                loca /= i;
                //if(loca == 1) System.out.println(i);
                //else System.out.print(i + " * ");
                i=1;
            }
        }
    }
}