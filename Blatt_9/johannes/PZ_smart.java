import java.util.ArrayList;
public class PZ_smart extends PZ{
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
