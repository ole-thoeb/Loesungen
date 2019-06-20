import java.util.Random;
public class Blatt9_2 {
	public static double approxPi(long tries) {
		long hits = 0;
		Random r = new Random();
		for(long i = 0; i < tries; i++) {
			double x = r.nextDouble();
			double y = r.nextDouble();
			if (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= 1) {hits++;}
			
			//Test
			//System.out.println("(x, y, betrag) = (" + x + " " + y + " " + Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) + ")");
		}
		return 4*((double)hits/(double)tries);
	}
	
	public static void main(String[] args) {
		long tries = 1_000_000;
		System.out.println("Pi = " + approxPi(tries));		
	}
	
}
