import java.util.ArrayList;

public class Blatt9_8 {
	public static void main(String[] args) {
		ArrayList<?> list=new ArrayList<Pikachu>();
		//kein Problem, logisch
		
		ArrayList<? extends Printable> list2=new ArrayList<Pikachu>();
		//kein Problem, Klasse Pikachu ist printable (also Teil von <? extends Printable>)
			
		//ArrayList<? super Printable> list3=new ArrayList<Pikachu>();
		//geht nicht, Klasse ist kein Supertyp von Printable 
		
		ArrayList<? super Pikachu> list4=new ArrayList<Pikachu>();
		//das sollte gehen, denn jede Klasse sollte seine eigene Supertyp-Klasse erfüllen?
		
		//ArrayList<? super Object> list5=new ArrayList<Pichu>();
		//geht nicht, Klasse Pichu ist kein Supertyp von Object 
		
		ArrayList<? extends Object> list6=new ArrayList<Pichu>();
		//sollte gehen, Pichu ist Suptyp von Object
		
		ArrayList<? extends Raichu> list7=new ArrayList<Pichu>();
		//geht wegen doppelter Vererbung (?)
		
		ArrayList<? super Raichu> list8=new ArrayList<Raichu>();
		//das sollte gehen, denn jede Klasse sollte seine eigene Supertyp-Klasse erfüllen? (vgl. oben)
		
		ArrayList<? super Pikachu> list9=new ArrayList<Raichu>();
		//geht, Pikachu Subtyp von Raichu
		
		ArrayList<? super Raichu> list10=new ArrayList<Object>();
		//sollte gehen, object ist Supertyp von allem.
	}
	public interface Printable {
		public void print();
		}
	public class Raichu { }
	public class Pikachu extends Raichu implements Printable{
		public void print() { }
	}
	public class Pichu extends Pikachu { }
}
