
public class Primf_multi extends Thread{
	int a;
	int b;
	
	Primf_multi(int a, int b){
		this.a=a; this.b=b;
	}

	public void run(){
		String temp="";
		//spezialfälle
		for(int j=a; j<=b; j+=2) {
			int k=j;
			for(int i=2; i<=k; ) {
				if(k%i==0) {
					//System.out.print(i);
					temp=temp + i;
					if(i<k){
						//System.out.print(" · ");
						temp=temp +" · ";
					}
					k=k/i;

				}
				if (k%i!=0) {
					i++;
				}

			}
			System.out.println(temp);
			temp="";
		}
	}

	public static void prim(int a, int b) throws Exception {
				
		//Thread t1= new Thread(primhalb(a, b));
		
		//Thread t2= new Thread(primhalb(a+1, b));
	
		Thread t1=new Thread(new Primf_multi(a,b));
		Thread t2=new Thread(new Primf_multi(a+1,b));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
