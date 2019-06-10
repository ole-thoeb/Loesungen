import java.util.List;
import java.util.ArrayList;

public class ex3 {
    public static void main(String[] args) {
        Stack teststack = new Stack();
        teststack.print();
        teststack.push("Apfel");
        teststack.print();
        teststack.push("Orange");
        teststack.print();
        teststack.push("Erdbeere");
        teststack.print();
        teststack.push("Kirsche");
        teststack.print();

        teststack.pop();
        teststack.print();
        teststack.pop();
        teststack.print();
        teststack.pop();
        teststack.print();
        teststack.pop();
        teststack.print();
    }
}


interface Stacks extends List {
    public void push (String x);
    public String pop ();
}

class Stack implements Stacks {
    private List<String> data;

    public Stack () {
        List<String> list = new ArrayList<String>();
        this.data = list;
    }

    @Override
    public void push (String x) {
        this.data.add(0,x);
    }

    public String pop() { //pops and returns value
        if(this.data.size() == 0) { //Fall, dass versucht wird, ein Element zu entfernen, der Stack jedoch leer ist
			System.out.println("Could not pop, stack is empty, returns null!");
            return null;
        }
        String returnvalue = this.data.get(0);
        this.data.remove(0);
        return returnvalue;
    }

    public void print() {
        System.out.println("\nStack status: ");
        if(this.data.size() == 0) {
            System.out.println("-stack is empty-");
            return;
        }
        else {
            for(String element : this.data) {
                System.out.print(element + " | ");
            }
        }
    }


}