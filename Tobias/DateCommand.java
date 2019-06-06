import java.util.Calendar;

public class DateCommand implements Runnable {
	public void run(){
		for (int i=0;i<10;i++) {
			try {
				Thread.sleep(new java.util.Random().nextInt(1000));
			} catch (Exception e) {}
			System.out.println(Calendar.getInstance().getTime());
		}
	}
}
