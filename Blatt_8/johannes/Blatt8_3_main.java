public class Blatt8_3_main {
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.print();
        s.push("Apfel");
        s.print();
        s.push("Orange");
        s.print();
        s.push("Erdbeere");
        s.print();
        s.push("Kirsche");
        s.print();

        s.pop();
        s.print();
        s.pop();
        s.print();
        s.pop();
        s.print();
        s.pop();
        s.print();
        
        Stack<Integer> s_int = new Stack<Integer>();
        s_int.push(4);
        s_int.push(3);
        s_int.push(2);
        s_int.push(1);
        s_int.print();
        s_int.pop();
        s_int.pop();
        s_int.print();
        
    }	
}