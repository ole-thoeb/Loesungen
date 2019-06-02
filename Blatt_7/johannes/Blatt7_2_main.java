import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
public class Blatt7_2_main {

	public static void main(String[] args) {
		File f = new File("test.txt");	
		
		//diese Konstruktion des Writers kennt die Methode "append"
		try(PrintWriter writer = new PrintWriter(new FileWriter(f,true))) 
		{
		    writer.append(System.lineSeparator() + "Start des Programms");
		} 
		catch (Exception e) {}

        
		Thread t = new Thread(new DateiBeobachter(f));
		t.start();
        
		int i = 0;
		//zufällige Dateiveränderungen während der 5 Sek. Laufzeit.
		while(i < 5000) {
			int j = new java.util.Random().nextInt(3000);
	        try {Thread.sleep(j);} catch (Exception e) { }
			try(PrintWriter writer = new PrintWriter(new FileWriter(f,true))) 
			{
			    writer.append(System.lineSeparator() + "Nächste Zeile");
			} 
			catch (Exception e) {}
			i += j;
		}
	}

}
