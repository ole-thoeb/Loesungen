import java.util.Random;

public class Nr2 {

	public static void main(String[] args) {
		System.out.println(approxPi(100_000));
	}

	static double approxPi(int iterations) {
		Random rng = new Random();
		int pointsIn = 0;
		int pointsOut = 0;

		double pointX;
		double pointY;
		for (int i = 0; i < iterations; i++) {
			pointX = rng.nextDouble();
			pointY = rng.nextDouble();
			if (Math.sqrt(pointX * pointX + pointY * pointY) <= 1.0) {
				pointsIn++;
			} else {
				pointsOut++;
			}
		}
		return 4 * (double)pointsIn / (double)(iterations);
	}
}