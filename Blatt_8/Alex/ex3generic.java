package ex3generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ex3generic {
    public static void main(String[] args) {
        Stack<Integer> teststack = new Stack<Integer>();
        teststack.print();
        teststack.push(1);
        teststack.print();
        teststack.push(2);
        teststack.print();
        teststack.push(3);
        teststack.print();
        teststack.push(4);
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


interface Stacks<T> extends List<T> {
    public void push (T x);
    public T pop ();
}

class Stack<T> implements Stacks<T> {
    private List<T> data;

    public Stack () {
        List<T> list = new ArrayList<T>();
        this.data = list;
    }

    @Override
    public void push (T x) {
        this.data.add(0,x);
    }

    public T pop() { //pops and returns value
        T returnvalue = null;
    	try {
        	returnvalue = this.data.get(0);
        } catch (NullPointerException x) {
        	x.printStackTrace();
        	System.err.println("Stack is empty, access impossible.");
        }
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
            for(T element : this.data) {
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
	public Iterator<T> iterator() {
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
	public boolean add(T e) {
		this.push(e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
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
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index) {
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
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}


}
