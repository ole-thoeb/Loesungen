
public class Primfaktorzerlegung {

	public static void primfz(int a, int b){
		//spezialfälle
		for(int j=a; j<=b; j++) {
			int k=j;
			for(int i=2; i<=k; ) {
				if(k%i==0) {
					System.out.print(i);
					if(i<k){
						System.out.print(" · ");
					}
					k=k/i;

				}
				if (k%i!=0) {
					i++;
				}
			
			}
			System.out.println();
		}
	}


}
