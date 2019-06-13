package ex3;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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


interface Stacks extends List<String> {
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

	@Override
	public int size() {
		return this.data.size();
	}

	@Override
	public boolean isEmpty() {
		return this.data.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(String e) {
		this.push(e);
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String set(int index, String element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<String> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<String> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}


}