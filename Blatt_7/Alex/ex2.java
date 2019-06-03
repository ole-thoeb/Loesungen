import java.util.Date;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

class DateiBeobachter implements Runnable {
    java.io.File data;
    long modification;

    public DateiBeobachter(String s) {
        FileUtis.writeStringtoFile(this.data, s);
        this.modification = this.data.lastModified();
    }

    public DateiBeobachter (java.io.File file) {
        this.data = file;
        this.modification = this.data.lastModified();
    }

    public void run() {
        int i=0;
        while(i<10) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ohno) {
                ohno.printStackTrace();
            }
            System.out.println(data.getName());
            if(this.modification != data.lastModified()) {
                System.out.println("Die Datei " + this.data.getName() + " wurde geaendert!");
                this.modification = data.lastModified();
            }
            i++;
        }

    }
}

public class ex2 {
    
    public static void main (String[] args) {
        String begin = "this is a test";
        String end = "file";
        File file = new File("testfile.txt");
        try {
            PrintWriter tofile = new PrintWriter("testfile.txt");
            tofile.write(begin);
            tofile.close();
        } catch (FileNotFoundException x) {
            System.out.println("File could not be found!");
        }


        Thread datawatch = new Thread(new DateiBeobachter(file));
        datawatch.start();

        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException x) {
            System.out.println("Timer got interrupted!");
        }

        try {
            PrintWriter tofile = new PrintWriter("testfile.txt");
            tofile.write(end);
            tofile.close();
        } catch (FileNotFoundException x) {
            System.out.println("File could not be found!");
        }
        
    }
}