
public class Main1 {

	public static void main(String[] args){
		System.out.println("multi-thread");
		long time1=java.lang.System.currentTimeMillis();
		try {
		Primf_multi.prim(1,10000);}catch (Exception e) {}
		time1=java.lang.System.currentTimeMillis()-time1;
		System.out.println("\ntime passed: " + time1);
		
		
		long time2=java.lang.System.currentTimeMillis();
			System.out.println("\nsingle");
			Primfaktorzerlegung.primfz(1, 42);
			time2=java.lang.System.currentTimeMillis()-time2;
			System.out.println("\ntime passed: " + time2);

		System.out.println("multi time / single time: " + time1 +"/"+time2 + "\n\n");
		
		System.out.println("multi-thread");
		time1=java.lang.System.currentTimeMillis();
		try {
		Primf_multi.prim(1000000000,1000000010);}catch (Exception e) {}
		time1=java.lang.System.currentTimeMillis()-time1;
		System.out.println("\ntime passed: " + time1);
		
		
		time2=java.lang.System.currentTimeMillis();
			System.out.println("\nsingle");
			Primfaktorzerlegung.primfz(1000000000,1000000010);
			time2=java.lang.System.currentTimeMillis()-time2;
			System.out.println("\ntime passed: " + time2);
		
		System.out.println("multi time / single time: " + time1 +"/"+time2);
		
		System.out.println("Bei großen Zahlen können mehrere Threads sinnvoll sein. Bei kleinen Zahlen, auch wenn es viele sind, kann ein Thread hundertmal so schnell sein als die Implementierung mit zwei Threads.");
		
	}

}
