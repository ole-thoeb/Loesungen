/* a)
 * Erste Möglichkeit: implementing interface Runnable:
 * 	"public class DateCommand implements Runnable {}"
 * Vorteil: Implementation, keine Extension also kann die Klasse
 * weiterhin von einer weiteren Klasse erben "...extends Superclass" 
 * 
 * Zweite Möglichkeit: extending Thread:
 *  "public class MultithreadingDemo extends Thread{}" 
 * 	Vorteil: Eingebaute Funktionalitäten yield(), interrupt() etc.
 * 
 * 
 */

public class ThreadTest {

	public static void main(String args[]){
		Thread t1 = new Thread(new DateCommand());
		t1.start();
		Thread t2 = new Thread(new CounterCommand());
		t2.start();
	}
}

/* Beispielausgabe:
0
Sun Jun 02 15:38:12 CEST 2019
Sun Jun 02 15:38:12 CEST 2019
Sun Jun 02 15:38:12 CEST 2019
1
Sun Jun 02 15:38:12 CEST 2019
2
3
Sun Jun 02 15:38:13 CEST 2019
4
5
Sun Jun 02 15:38:13 CEST 2019
6
7
Sun Jun 02 15:38:14 CEST 2019
Sun Jun 02 15:38:14 CEST 2019
8
9
Sun Jun 02 15:38:15 CEST 2019
Sun Jun 02 15:38:16 CEST 2019

Anmerkung: Logischerweise hängt der Output an den eingebauten, zufälligen Verzögerungen. Die beiden Threads laufen parallel, was zuerst
ausgegeben wird, hängt an den zufälligen sleep-Zeiten.
*/