import java.util.Random;

public class Main2 {
	static double approxPI(long iterationen){
		long treffer=0;
		Random rn=new Random();
		for (long i=0; i<iterationen;i++) {
		if ((Math.pow(rn.nextDouble(), 2)+Math.pow(rn.nextDouble(), 2)) <=1) {
			treffer++;
		}
		}
		return 4 * (double) treffer/iterationen;

		
	}
	public static void main(String[] args) {
		System.out.println(approxPI(1000000));
	}

}
