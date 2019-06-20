public class Blatt9_3 {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>(1);
		for(int i = 2; i < 35; i++) {
			q.enqueue(i);
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(q.dequeue());
		}
	}
	public static class Queue<T>{
		private Node<T> last;
		private int count = 0;
		public Queue(T data) {
			this.last = new Node<T>(data);
			count++;
		}
		public void enqueue(T data) {
			if (this.count == 30) {
				System.out.println("Queue ist voll!");
			} else {				
				if(last == null) {
					this.last = new Node<T>(data);		
				} else {
					Node<T> new_last = new Node<T>(data);
					new_last.setPrior(last);
					last = new_last;
				}
				count++;
			}
		}
		public T dequeue() {
			Node<T> cursor = this.last;
			Node<T> prior_cursor = last;
			while(cursor.getPrior()!=null) {
				prior_cursor = cursor;
				cursor = cursor.getPrior();
			}
			T res = (T)cursor.getData();
			prior_cursor.setPrior(null);
			count--;
			return res;	
		}
	}
	public static class Node<T>{
		private T data;
		private Node<T> prior;
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		Node(T data){
			this.data = data;
		}
		public void setPrior(Node<T> prior) {
			this.prior = prior;
		}
		public Node<T> getPrior() {
			return this.prior;
		}
		
	}
}
