import java.io.*;
public class Blatt6_2 {
	static public class Hamburger extends Fastfood {
		//a)
		//void eat() { }
		//Läuft - keine Neudeklaration, wird von Fastfood übernommen
		
		//b)
		//void eat() throws Exception { }
		//Läuft nicht - Exception ist Supertyp von IOException also insb. kein Subtyp
		
		//c)
		//void eat(int y) throws Exception { }
		//Läuft - im Gegensatz zu b) wird die Methode aus Fastfood nicht überschrieben
		
		//d)
		//void eat() throws FileNotFoundException { }
		//Läuft - FileNotFoundException ist Subklasse von IOException
		
		//e)
		//void eat() throws RuntimeException { }
		//Läuft - Begründung aus Oracle Docs:
		/*RuntimeException and its subclasses are unchecked exceptions. 
		 * Unchecked exceptions do not need to be declared in a method or constructor's throws clause if 
		 * they can be thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.
		 */
	}
	static class Fastfood {
		void eat() throws IOException { }
	}
	static public class Maincl {
		public static void main(String[] args) throws IOException {
			Hamburger c = new Hamburger();
			c.eat();
		}
	}
}
