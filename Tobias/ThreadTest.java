/*Die Möglichkeiten sind 
 	implements Runnable
		wegen Implementierung kann man weiterhin von einer Klasse erben.
		
		

	extends Thread
		Nützliche bestehende Funktionen wie interrupt() und yield()
*/

public class ThreadTest {
	public static void main(String args[]){
		Thread t1 = new Thread(new DateCommand());
		t1.start();
		Thread t2 = new Thread(new CounterCommand());
		t2.start();
		
//Die Threads liefen parallel, was daran gesehen werden kann, dass nicht alle Ausgaben eines Threads auf die des anderen gefolgt sind
/* Die einzelnen Ausgaben kommen in zufälliger Reihenfolge
0
1
Thu Jun 06 22:03:00 CEST 2019
2
3
Thu Jun 06 22:03:01 CEST 2019
4
Thu Jun 06 22:03:02 CEST 2019
5
Thu Jun 06 22:03:03 CEST 2019
6
Thu Jun 06 22:03:03 CEST 2019
7
8
9
Thu Jun 06 22:03:04 CEST 2019
Thu Jun 06 22:03:04 CEST 2019
Thu Jun 06 22:03:05 CEST 2019
Thu Jun 06 22:03:05 CEST 2019
Thu Jun 06 22:03:05 CEST 2019
 
		 * */
	}
}