
public class Blatt6_1_main {

	public static void main(String[] args) {
		DoubleHead head = new DoubleHead();
		head.add(2);
		head.add(3);
		head.add(4);
		head.insertFirst(1);
		head.insertFirst(0);
		head.remove(2);
		head.remove(0);
		head.remove(2);
		System.out.println(head.get(0));
		System.out.println(head.toString());
		
	}

}
