	class Auto{}
	class Pkw extends Auto{}
public class Test {

	public static void main(String[] args) {
		Auto a=new Auto();

		Pkw p=new Pkw();
		
		Auto b=(Auto) p;
		Pkw c=(Pkw) a;

	}

}
