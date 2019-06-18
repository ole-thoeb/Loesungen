import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nr1 {

	public static void main(String[] args) {
		//int from = 1_000_000_000;
		//int to = 1_000_000_010;
		int from = 2;
		int to = 10_000_000;
		long startTime = System.currentTimeMillis();
		Map<Integer, List<Integer>> factors = Primfaktorzerlegung.dynamicFactoriseInterval(from, to);
		//System.out.println(factors);
		System.out.println("time:" + (System.currentTimeMillis() - startTime));
		
		startTime = System.currentTimeMillis();
		Thread even = new FactoriserThread(from, to, 2);
		Thread odd = new FactoriserThread(from + 1, to, 2);
		even.start();
		odd.start();
		try {
			even.join();
			odd.join();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("time:" + (System.currentTimeMillis() - startTime));
	}

	static class Primfaktorzerlegung {
		private Primfaktorzerlegung() {}

		static List<Integer> factorise(int n) {
			List<Integer> factors = new ArrayList<Integer>();
			for (int i = 2; n > 1; i++) {
				while (n % i == 0) {
					factors.add(i);
					n = n / i;
				}
			}
			return factors;
		}

		static Map<Integer, List<Integer>> factoriseInterval(int from, int to) {
			Map<Integer, List<Integer>> factorMap = new HashMap<>();
			for (int i = from; i <= to; i++) {
				factorMap.put(i, factorise(i));
			}
			return factorMap;
		}

		static Map<Integer, List<Integer>> dynamicFactoriseInterval(int from, int to) {
			Map<Integer, List<Integer>> cache = new HashMap<>(to, 1);
			Map<Integer, List<Integer>> factorMap = new HashMap<>();
			for (int i = from; i <= to; i++) {
				factorMap.put(i, dynamicFactorise(i, cache));
			}
			return factorMap;
		}

		static List<Integer> dynamicFactorise(int n, Map<Integer, List<Integer>> cache) {
			List<Integer> cachedResult = cache.get(n);
			if (cachedResult != null) {
				return cachedResult;
			}
			double max = Math.sqrt(n);
			for (int i = 2; i < max; i++) {
				if (n % i == 0) {
					ArrayList<Integer> factors = new ArrayList<>();
					factors.add(i);
					int remainder = n / i;
					factors.addAll(new ArrayList<Integer>(dynamicFactorise(remainder, cache)));
					cache.put(n, factors);
					return factors;
				}
			}
			ArrayList<Integer> prime = new ArrayList<>(1);
			prime.add(n);
			cache.put(n, prime);
			return prime;
		}

		static Map<Integer, List<Integer>> primeCacheFactoriseInterval(int from, int to) {
			List<Integer> primes = new ArrayList<>();
			Map<Integer, List<Integer>> factorMap = new HashMap<>();
			for (int i = from; i <= to; i++) {
				factorMap.put(i, primeCacheFactorise(i, primes));
			}
			//System.out.println(primes);
			return factorMap;
		}

		static List<Integer> primeCacheFactorise(int n, List<Integer> primes) {
			List<Integer> factors = new ArrayList<Integer>();
			for (int i = 0; i < primes.size() && n > 1; i++) {
				int prime = primes.get(i);
				if (n % prime == 0) {
					while (n % prime == 0) {
						factors.add(i);
						n = n / prime;
					}
				}
			}
			if (factors.isEmpty()) {
				factors.add(n);
				primes.add(n);
			}
			return factors;
		}
	}

	static class FactoriserThread extends Thread {
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
	}
}