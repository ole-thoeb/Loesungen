
public class Main4 {

	public static void main(String[] args) {
		//Harshad.ha(1000);
		Thread[] t=new Thread[4];
		for (int i=0;i<4;i++) {
			t[i]=new Thread(new Main4().new Harshad_m(1+i, 1_000_000));
		}
		for (int i=0;i<4;i++) {
			t[i].start();
		}
		/*
		Thread t1= new Thread(new Main4().new Harshad_m(1,200000));
		Thread t2= new Thread(new Main4().new Harshad_m(200001,400000));
		Thread t3= new Thread(new Main4().new Harshad_m(400001,800000));
		Thread t4= new Thread(new Main4().new Harshad_m(800001,1000000));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		}catch (Exception e) {}

*/
	}
		
	class Harshad_m implements Runnable{
		int start;
		int end;
		Harshad_m(int start, int end){
			this.start=start;
			this.end=end;
		}
		
		public void run(){
			int k=start;
			int n= end;
			
			
			for( ;k<=n; k+=4) {
			int tmp=k;
			int q=0;
			//for(int j=1;j<=tmp;j*=10)
			int j=1;
			while(tmp/(j*10)>0) {
				j*=10;
			}
			while(j>=1) {
				q+=tmp/j;
				if(j==1) {
					j--;
				}
//					System.out.println(j + " "+tmp +" "+ q);
				else {
				tmp=tmp%j;
				j/=10;
				}
			}
			if(k%q==0) {
				System.out.println(k);
			}
			
			}
			
			
			
		}
	}
	static class Harshad {
		static void ha (int n) {
			
			for(int h=1;h<=n; h++) {
			int tmp=h;
			int q=0;
			//for(int k=1;k<=tmp;k*=10)
			int k=1;
			while(tmp/(k*10)>0) {
				k*=10;
			}
			while(k>=1) {
				q+=tmp/k;
				if(k==1) {
					k--;
				}
//					System.out.println(k + " "+tmp +" "+ q);
				else {
				tmp=tmp%k;
				k/=10;
				}
			}
			if(h%q==0) {
				System.out.println(h);
			}
			
			}
			
		}
	}
}


