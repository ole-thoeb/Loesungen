
//Bei Modifikation gab das Programm die folgenden Male eine Modifikation an. Für eine einzelne Benachrichtigung wurde der Wert last_mod neu gesetzt.
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
public class A02a {
	public static void main(String[] args) {
		File f=new File("test.txt");

		try(PrintWriter writer=new PrintWriter(new FileWriter(f,true)))
		{
			writer.append("\nStart des Programms");
		}catch(Exception e) {}

		
		DateiBeobachter d=new DateiBeobachter(f); 
		
		
		d.run();
	}
}

 class DateiBeobachter implements Runnable{
	File file;
	long last_mod;
	public void run() {
		for (int i=0;i<10;i++) {
			System.out.println(this.file.getName());
			if(this.last_mod!=this.file.lastModified()) {
				System.out.println("File has been modified");
				this.last_mod=this.file.lastModified();
			}
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}
	DateiBeobachter(String s) {
		File f=new File(s);
		this.file=f;
		this.last_mod=this.file.lastModified();
		
	}
	DateiBeobachter(java.io.File f){
		this.file=f;
		this.last_mod=f.lastModified();
	}
}