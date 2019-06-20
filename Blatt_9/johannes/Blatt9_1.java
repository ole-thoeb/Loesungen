import java.util.ArrayList;
public class Blatt9_1 {
	public static void main(String[] args) {	
		int first = 2;
		int last = 100000;
		int stepsize = 2;
		boolean print = true;
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
	public static class PZ {
		public PZ() {}
		private void factorize(int input, boolean print) {
			String res_i = input + " = ( ";
			int j = 2;
			while (input > 1)  {

				if(input % j == 0) {
					res_i += j + " ";
					input = input / j;
				} else {j += 1;}
			} 
			res_i  = res_i + ")";
			if (print == true) {System.out.println(res_i);}	
		}

		public void factorize(boolean print, int first, int last, int stepsize) {
			for(int i = first; i <= last; i += stepsize) {
				factorize(i, print);
			}
		}
	}
	public static class PZ_smart extends PZ{
		private ArrayList<Integer> primes = new ArrayList<Integer>();
		public PZ_smart() {
			this.primes.add(2);
		}
		public void primes_add(int input) {
			this.primes.add(input);
		}
		
		private String factorize(int input, int o_input) {
			String res = "";
			if (input > 1) {					
				for(int i = 0; i<primes.size(); i++) {
					if(2*primes.get(i) > o_input && o_input != 2) {
						primes_add(o_input);
						res += o_input + " ";
						break;
					}
					if(input % primes.get(i) == 0) {
						res += primes.get(i) + " ";
						res += factorize(input/primes.get(i), input);
						break;
					}	
				}
				
			}
			return res;
		}
		
		public void factorize(boolean print, int first, int last, int stepsize) {
			for(int i = first; i <= last; i = i+stepsize) {
				String s = i + " = ( " + factorize(i, i) + ")";	
				if (print == true) {System.out.println(s);}
			}
			
		}
	}
	
	public static class PZ_smart_Thread extends Thread {
		PZ_smart f;
		int first;
		int last;
		int stepsize;
		boolean print;
		public PZ_smart_Thread(boolean print, PZ_smart f, int first, int last, int stepsize) {
			this.print = print;
			this.f = f;
			this.first = first;
			this.last = last;
			this.stepsize = stepsize;
		}
		public void run() {
			this.f.factorize(this.print, this.first, this.last, this.stepsize);
		}
	}

}
