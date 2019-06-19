
public class PZ_smart_Thread extends Thread {
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

/*static class FactoriserThread extends Thread {
	private int increment;
	private int from;
	private int to;

	FactoriserThread(int from, int to, int increment) {
		this.increment = increment;
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		Map<Integer, List<Integer>> factorMap = new HashMap<>();
		for (int i = from; i <= to; i+= increment) {
			factorMap.put(i, Primfaktorzerlegung.factorise(i));
		}
		//System.out.println(factorMap);
	}
}*/