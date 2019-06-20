public class Blatt9_4 {
	public static void main(String[] args) throws Exception{
		int start = 1;
		long end = 1_000_000_000;
		int thread_count = 16;
		Thread myThreads[] = new Thread[thread_count];
		for(int i = 0; i < thread_count; i++) {
			myThreads[i] = new Harshad_Thread(start + i, end, thread_count);
		}
		
		long s = System.currentTimeMillis();		
		for(int i = 0; i < thread_count; i++) {
			myThreads[i].start();
		}
		for(int i = 0; i < thread_count; i++) {
			myThreads[i].join();
		}
		System.out.println(System.currentTimeMillis() - s);
	}
	public static long quersumme(long zahl) {
		if (zahl <= 9) return zahl;
		return zahl%10 + quersumme(zahl/10);
	}
	public static class Harshad_Thread extends Thread{
		private int start;
		private long end;
		private int stepsize;
		public Harshad_Thread(int start, long end, int stepsize) {
			this.start = start;
			this.end = end;
			this.stepsize = stepsize;
		}
		public void run(){
			for(int i = this.start; i <= this.end; i += stepsize) {
				if(i%quersumme(i)==0) {
					//System.out.println(i);
				}
			}
		}
	}
}
	