
public class PZ {
	/*private int first;
	private int last;
	public PZ(int first, int last) {
		this.first = first;
		this.last = last;
	}*/
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
