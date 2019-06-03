//a.
//  man kann Threads in Java entweder über die Schnittstelle des Interfaces Runnable implementieren oder 
//  die Klasse Thread erweitern (da Thread selbst ebenfalls Runnable implementiert), also entweder
//      public class MytThread implements Runnable{}    | Vorteil: Einfachvererbung ist nicht aufgebraucht, die Klasse kann, falls gewuenscht, noch erben
//                      oder
//      public class MyThread extends Thread{}          | Vorteil: direkt erkennbar und nicht 'verwechselbar', dass es sich um einen Thread handelt. Man kann direkt ohne Umwege einen Constructor aufrufen.

//b. + c.
import java.util.Date;
import java.util.Random;

public class ex1 {
    public static void main(String args[]) {
        Thread t1 = new Thread(new DateCommand());
        t1.start();
        Thread t2 = new Thread(new CounterCommand());
        t2.start();
    }
}

class DateCommand implements Runnable {
    Date currentdate = new Date();
    Random r = new Random();
    public void run() {
        for(int i=0; i<10; i++) {
            try {
                Thread.sleep(r.nextInt(1000));
            } catch (InterruptedException ohno) {
                ohno.printStackTrace();
            }
            System.out.println(currentdate);
        }
    }
}

class CounterCommand implements Runnable {
    Random r = new Random();
    public void run() {   
        for(int i=0; i<10; i++) { 
            try {
                Thread.sleep(r.nextInt(1000));
            } catch (InterruptedException whyudothis) {
                whyudothis.printStackTrace();
            }
            System.out.println(i);
        }
    }
}