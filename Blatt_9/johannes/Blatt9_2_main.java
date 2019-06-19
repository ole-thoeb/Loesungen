public class Blatt9_2_main {

	public static void main(String[] args) {	
		int first = 2;
		int last = 100000;
		int stepsize = 2;
		boolean print = false;
		//PZ f_naive = new PZ();
		
		long time_start = System.currentTimeMillis();
		//f_naive.factorize(false);
		//long time_end = System.currentTimeMillis() - time_start;
		
				
		PZ_smart f_smart = new PZ_smart();
		
		Thread f1 = new PZ_smart_Thread(print, f_smart, first, last, stepsize);
		Thread f2 = new PZ_smart_Thread(print, f_smart, first + 1, last, stepsize);
		time_start = System.currentTimeMillis();
		f1.start();
		f2.start();

		try {
			f1.join();
			f2.join();
			} catch(Exception e) {
			e.printStackTrace();
		}
		long time_threaded = System.currentTimeMillis() - time_start;
		
		//time_start = System.currentTimeMillis();
		//f_smart.factorize(false, first, last, 1);		
		//long time_end_smart = System.currentTimeMillis() - time_start;
		//System.out.println("Naive - Time needed: " + time_end + " milliseconds.");
		//System.out.println("Smart - Time needed: " + time_end_smart + " milliseconds.");
		System.out.println("Threaded - Time needed: " + time_threaded + " milliseconds.");
	}

}
