import java.util.ArrayList;
public class Blatt9_7 {
	public static void main(String[] args) {
		ArrayList<ArrayList<? extends Printable>> arr_arr = new ArrayList<ArrayList<? extends Printable>>();
		//ArrayList<? extends Printable> arr_test;
		
		ArrayList<Person> p_arr = new ArrayList<Person>();
		Person p1 = new Person("v1", "n1");
		Person p2 = new Person("v2", "n2");
		Person p3 = new Person("v3", "n3");
		p_arr.add(p1);
		p_arr.add(p2);
		p_arr.add(p3);
		
		ArrayList<Kartoffel> k_arr = new ArrayList<Kartoffel>();
		Kartoffel k1 = new Kartoffel(1.1);
		Kartoffel k2 = new Kartoffel(1.2);
		Kartoffel k3 = new Kartoffel(1.9);
		k_arr.add(k1);
		k_arr.add(k2);
		k_arr.add(k3);
		
		ArrayList<Pikachu> pi_arr = new ArrayList<Pikachu>();
		Pikachu pi1 = new Pikachu();
		Pikachu pi2 = new Pikachu();
		Pikachu pi3 = new Pikachu();
		pi_arr.add(pi1);
		pi_arr.add(pi2);
		pi_arr.add(pi3);
		
		arr_arr.add(p_arr);
		arr_arr.add(k_arr);
		arr_arr.add(pi_arr);
		
		print_all(arr_arr);
	}
	
	public static void print_all(ArrayList<ArrayList<? extends Printable>> arr_arr) {
		for(int i = 0; i < arr_arr.size(); i++){
			for(int j = 0; j < arr_arr.get(i).size(); j++) {
				Printable p = (Printable)arr_arr.get(i).get(j);
				p.print();		
			}
		}
	}
	
	interface Printable{
		public void print();
	}
	
	static class Person implements Printable{
		String nachname;
		String vorname;
		private String getNachname() {
			return nachname;
		}
		private void setNachname(String nachname) {
			this.nachname = nachname;
		}
		private String getVorname() {
			return vorname;
		}
		private void setVorname(String vorname) {
			this.vorname = vorname;
		}
		public Person(String vorname, String nachname) {
			this.vorname = vorname;
			this.nachname = nachname;
		}
		public void print() {
			System.out.println("Person: '" + this.getVorname() + " " + this.getNachname() + "'");
		}			
	}
	
	static class Kartoffel implements Printable{
		private double gewicht;
		private double getGewicht() {
			return gewicht;
		}
		private void setGewicht(double gewicht) {
			this.gewicht = gewicht;
		}
		public Kartoffel(double d) {
			this.gewicht = d;
		}
		public void print() {
			System.out.println("Kartoffel: " + this.getGewicht());
		}		
	}
	
	static class Pikachu implements Printable{
		public void print() {
			System.out.println("Pika Pika");
		}
	}
}
