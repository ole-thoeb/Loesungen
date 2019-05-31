import java.util.Scanner;
class NumberTooSmallException extends Exception {
	public NumberTooSmallException(String message) {
		super(message);
	}
}

class NumberTooBigException extends RuntimeException{
	public NumberTooBigException(String message) {
		super(message);
	}	
}

public class Blatt6_3_main {	
	public static void main(String[] args) throws NumberTooSmallException {
		System.out.println("Bitte Zahl angeben (Test > 5:");
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		s.close();
		if(i>5) {throw new NumberTooBigException("Zahl > 5");}
		if(i<5) {throw new NumberTooSmallException("Zahl < 5");}
		
	}
}

/*Anmerkungen Checked/Unchecked:
* Checked: 
* - Überprüft beim Kompilieren
* - muss im Methoden-Header angegeben werden ("throws ...")
* Unchecked:
* - Überprüft zur Laufzeit
* - muss nicht angegebem werden
*/