import java.io.File;
public class DateiBeobachter implements Runnable {
    java.io.File file;
    long last_mod;
	public DateiBeobachter(String s){
		File f = new File(s);
		this.file = f;
        this.last_mod = this.file.lastModified();
	}
	public DateiBeobachter(java.io.File f){
        this.file = f;
        this.last_mod = f.lastModified();
	}
	public void run() {
		int i = 0;
		while (i < 10) {
			System.out.println("Dateiname: " + this.file.toString());
			if(this.last_mod != this.file.lastModified()) {
				System.out.println("Datei wurde geändert");
				this.last_mod = this.file.lastModified();
			}
			
			try {Thread.sleep(500);} catch (Exception e) {}
			i++;
		}
	}
}
