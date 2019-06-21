import java.lang.Math;
import java.util.Random;

public class ex2 {
    public static void main(String[] args) {
        System.out.println(ex2.Pi(100));
        System.out.println(ex2.Pi(1000));
        System.out.println(ex2.Pi(100000));
        System.out.println(ex2.Pi(1000000000));
    }

    static double Pi (int x) {
        Random r= new Random();
        double dotx,doty;
        int in,out;
        in=out=0;
        for(int i=0; i<=x;i++) {
            dotx=r.nextDouble();
            doty=r.nextDouble();
            if(ex2.isIn(dotx,doty)) in++;
            else out++;
        }

        double ratio = (double) in*4/(in+out);
        return ratio;

    }

    static boolean isIn (double x, double y) {
        double funcy = x*x + y*y;
        if(funcy<=1) return true;
        else return false;
    }
}