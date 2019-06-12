class R { }
class E extends R { }
class B extends R { }
class G extends B { }
class U { }

public class Blatt8_2_main {
	//public static class Foo {
		public static <T> T bar(T x, T y) {
			return x;
			}
		//}
	public static void main(String[] args) {
	
		Object o;
		R r = new R();
		E e = new E();
		B b = new B();
		G g = new G();
		U u = new U();
		R[] x;
		E[] y;
		
		//a:
		//r = bar(r,b);
		//wird akzeptiert
		//Beim Kompilieren: returnt R (kleinster gemeinsamer typ ist R)
		//Zur Laufzeit: r.getClass() = R, bar(r,b).getClass() = R
		
		//b:
		//r = bar(b,r);
		//wird akzeptiert
		//Beim Kompilieren: bar returnt R (kleinster gemeinsamer typ ist R)
		//Zur Laufzeit: r.getClass() = B, bar(b,r).getClass() = B
		
		//c:
		//r = bar(e,g);
		//wird akzeptiert
		//Beim Kompilieren: bar returnt R (kleinster gemeinsamer Typ ist R)
		//Zur Laufzeit: r.getClass() = E, bar(b,r).getClass() = E
		
		//d:
		//r = bar(b,g);
		//wird akzeptiert
		//Beim Kompilieren: bar returnt B (kleinster gemeinsamer typ ist B)
		//Zur Laufzeit: r.getClass() = B, bar(b,r).getClass() = B
		
		
		//e:
		//e = bar(r,b);
		//das geht nicht
		//Beim Kompilieren: bar(r,b) returns R, cannot convert from R to E
		
		//f:
		//u = bar(u,r);
		//das geht nicht
		//Beim Kompilieren: bar(r,b) returns Object (kleinster gemeinsamer Typ), cannot convert from R to E
		
		//g:
		//o = bar(e,u);
		//wird akzeptiert
		//Beim Kompilieren: bar returnt Object (kleinster gemeinsamer typ ist Object)
		//Zur Laufzeit: o.getClass() = E, bar(e,u).getClass() = E
		
		//h:
		//b = bar(e,g);
		//das geht nicht
		//Beim Kompilieren: bar(e,g) returns R (kleinster gemeinsamer Typ), cannot convert from R to B
		
		//x = bar(new E[2], new B[4]);
		//wird akzeptiert, 
		//Beim Kompilieren: bar() gibt ein Array aus R zurueck, da E<R und B<R (kleinster gemeinsamer Typ)
		
		//y = bar(new E[4],new B[11]);
		//das geht nicht
		//Beim Kompilieren: bar() gibt wieder ein Array aus R zurück, cannot convert from R[] to E[]
		
		 //o = bar(new G[8], new U[5]); 
		 //wird akzeptiert
		 //bar() gibt Array vom Typ Object zurück (kleinster gemeinsamer Typ, da G und U nicht verwandt).
		
		//Tests...
		//System.out.println(o.getClass());
		//System.out.println( bar(new G[8], new U[5]).getClass());
		//System.out.println(o.getClass());
	}
}
