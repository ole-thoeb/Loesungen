public class Nr2 {

	class R {}
	class E extends R {}
	class B extends R {}
	class G extends B {}
	class U {}

	public static <T> T bar(T x, T y) {
		return x;
	}

	public static void main(String[] args) {

		Object o;
		R r = new R();
		E e = new E();
		B b = new B();
		G g = new G();
		U u = new U();
		R[] x;
		E[] y;
		
		//r = bar(r,b); //ja bar returnt R (größter gemeinsamer typ ist R)
		//r = bar(b,r); //ja bar returnt R (größter gemeinsamer typ ist R)
		//r = bar(e,g); //ja bar returnt R (größter gemeinsamer typ ist R)
		//r = bar(b,g); //ja bar returnt B subtyp von R (größter gemeinsamer typ ist B)
		//e = bar(r,b); //nein bar returnt R (größter gemeinsamer typ ist R)
		//u = bar(u,r); //nein bar returnt Object (größter gemeinsamer typ ist Object)
		//o = bar(e,u); //ja bar returnt Object (größter gemeinsamer typ ist Object)
		//b = bar(e,g); //nein bar returnt R (größter gemeinsamer typ ist R)
		//x = bar(new E[2], new B[4]); //ja bar returnt R[] und arrays sind raw types
		//y = bar(new E[4], new B[11]); //nein bar returnt R[] (größter gemeinsamer typ)
		//o = bar(new G[8], new U[5]); object kann man alles zuweisen
	}
}