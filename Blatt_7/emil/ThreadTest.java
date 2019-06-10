import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

/**
 * a)
 * Runnable implementieren und an einen Thread übergeben
 * Thread extenden
 */

 public class ThreadTest {
	public static void main(String args[]){
		Thread t1 = new Thread(new DateCommand());
		t1.start();
		Thread t2 = new Thread(new CounterCommand());
		t2.start();
	}
	
	static class DateCommand implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(DateFormat.getInstance().format(Calendar.getInstance().getTime()));
			}
		}
	}
	
	static class CounterCommand implements Runnable {
		@Override
		public void run() {
			Random rand = new Random();
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(rand.nextInt(1000));
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
		}
	}
 }