
public class Blatt4_2_main {

	public static void main(String[] args) {
		Student student = new Student();
		
		//a)		
		Cauliflower essen1 = new Cauliflower();
		student.eat(essen1);
		/*
		 * Ausgabe: "I don�t like Blumenkohl an Gorgonzolaso�e"
		 * "I dont' like", denn basierend auf Parameter-Typ wird
		 * Student.eat(Cauliflower Cauliflower) aufgerufen
		 * "Blumenkohl an Gorgonzolaso�e", denn
		 * Cauliflower.getMeal() wird aufgerufen
		 */
		
		//b)
		Spaghetti essen2 = new Spaghetti();
		student.eat(essen2);
		/*
		 * Ausgabe: "I like Spaghetti Bologneser Art"
		 * "I like", denn basierend auf Parameter-Typ wird
		 * Student.eat(Food food) aufgerufen
		 * "Spaghetti Bologneser Art", denn
		 * Spaghetti.getMeal wird aufgerufen
		 */
		
		//c)
		Food essen = new Cauliflower();
		student.eat(essen);
		/*
		 * Ausgabe: "I like Blumenkohl an Gorgonzolaso�e"
		 * "I like", denn essen ist als Objekt Food deklariert
		 * "Blumenkohl an Gorgonzolaso�e", denn
		 * essen ist vom Subtyp Cauliflower
		 */
	}

}
