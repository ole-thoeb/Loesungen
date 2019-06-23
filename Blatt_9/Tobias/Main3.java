
public class Main3 {

	public static void main(String[] args) {
		Queue<Integer> q= new Main3().new Queue<Integer>(5);
		q.enqueue(3);q.enqueue(2);q.enqueue(100);q.enqueue(5);
		q.print();
		System.out.println();
		System.out.println(q.dequeue());
		System.out.println();
		q.enqueue(42);
		q.print();

	}

	class Queue<E> {
		Node/* <E> */ tail;
		void print() {
			Node cur = tail;
			System.out.println(cur.wert + " ");
			while (cur.next != null) {
				cur = cur.next;
				System.out.println(cur.wert + " ");

			}
		
		}
		void enqueue(E wert) {
			if (tail == null) {
				tail = new Node(wert);
			}
			Node cur = tail;
			while (cur.next != null) {
				cur = cur.next;
			}
			cur.next = new Node(wert);
		}

		E dequeue() {
			if(tail==null) {
				throw new NullPointerException();
			}
			if (tail.next==null) {
				E temp=tail.wert;
				tail=null;
				return temp;
			}
			Node cur = tail;
			while (cur.next.next != null) {
				cur = cur.next;
			}

			E temp = (cur.next).wert;
			cur.next = null;
			return temp;
		}

		private class Node/* <E> */ {
			E wert;
			Node next;

			Node(E wert) {
				this.wert = wert;
			}
		}

		Queue() {
		}

		Queue(E wert) {
			tail = new Node(wert);
		}

	}

}