
public class Nr3 {

	public static void main(String[] args) {
		LinkedStackList<String> list = new LinkedStackList<>();
		list.push("Apfel");
		System.out.println(list);
		list.push("Orange");
		System.out.println(list);
		list.pop();
		System.out.println(list);
		list.push("Erdbeere");
		System.out.println(list);
		list.push("Kiwi");
		System.out.println(list);
		list.pop();
		System.out.println(list);
		list.pop();
		System.out.println(list);
		list.pop();
		System.out.println(list);
		//list.pop();
		//System.out.println(list);
	}
}