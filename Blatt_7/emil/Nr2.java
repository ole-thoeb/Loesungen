import java.io.File;

public class Nr2 {

	public static void main(String[] args) {
		new Thread(new DateiBeobachter("testFile.txt")).start();;
	}

	static class DateiBeobachter implements Runnable {

		private File file;

		DateiBeobachter(String fileName) {
			file = new File(fileName);
		}

		DateiBeobachter(File f) {
			file = f;
		}

		@Override
		public void run() {
			Long lastMod = file.lastModified();
			while (true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (lastMod != file.lastModified()) {
					System.out.println("File has changed.");
					lastMod = file.lastModified();
				}
			}
		}
	}
}