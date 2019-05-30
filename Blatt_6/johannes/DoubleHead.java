
public class DoubleHead{
	private DoubleNode head;
	
	void add(double d) {
		DoubleNode newNode = new DoubleNode(d);
		if (head == null) {
			head = newNode;
		} else {
			DoubleNode cursor = head;
			while (cursor.getNext() != null) {
				cursor = cursor.getNext();
			}
			cursor.setNext(newNode);
		}
	}
	
	public void insertFirst(double d) {
		DoubleNode newNode = new DoubleNode(d);
		newNode.setNext(head);
		head = newNode;
	}
	
	public double get(int i) {
		DoubleNode cursor = head;
		if(i<0) {
			System.out.println("Index zu klein gew�hlt - get(int i) liefert kein Ergebnis");
			System.out.println("Stattdessen wird eine freundliche 42 ausgegeben");
			return 42;
		}
		for(int j = 0; j < i; j++) {
			if(cursor.getNext() != null) {
				cursor = cursor.getNext();
			} else {
				System.out.println("Index zu gro� gew�hlt - get(int i) liefert kein Ergebnis");
				System.out.println("Stattdessen wird eine freundliche 42 ausgegeben");
				return 42;
			}
		}
		return cursor.getD();
	}
	
	public void remove(int i) {
		DoubleNode cursor = head;
		DoubleNode prior = head;
		if(i<0) {
			System.out.println("Index zu klein gew�hlt - remove(int i) wird nicht ausgef�hrt");
		} else if(i == 0){
			if(cursor.getNext() == null) {
				head.setD(1000000);
				System.out.println("Liste enth�lt ein Element. Wert kann nicht auf 'null' gesetzt werden. Setze stattdessen auf 1.000.000");
			} else {
				head = head.getNext();
			}
				
		} else {
			for(int j = 0; j < i; j++) {
				if(cursor.getNext() != null) {
					prior = cursor;
					cursor = cursor.getNext();
				} else {
					System.out.println("Index zu gro� gew�hlt - remove(int i) wird nicht ausgef�hrt");
				}
			}
			if (cursor.getNext() == null) {
				prior.setNext(null);
			} else {
				prior.setNext(cursor.getNext());
			}
		}
	}
	
	public String toString() {
		String res = "";
		DoubleNode cursor = head;
		while (cursor != null) {
			res = res + cursor.getD() + "; ";
			cursor = cursor.getNext();
		}
		return res;
	}
}
