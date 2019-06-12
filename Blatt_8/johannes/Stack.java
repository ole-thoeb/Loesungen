import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public class Stack<E> implements iStack<E> {
	    private List<E> data;

	    public Stack () {
	        List<E> list = new ArrayList<E>();
	        this.data = list;
	    }
	    
	    public void push (E x) {
	        this.data.add(0,x);
	    }

	    public E pop() {
	        if(this.data.size() == 0) {
				System.out.println("Liste ist leer, return null");
	            return null;
	        }
	        E res = this.data.get(0);
	        this.data.remove(0);
	        return res;
	    }

	    public void print() {
	        System.out.print("\nStack: ");
	        if(this.data.size() == 0) {
	            System.out.print(" Ist leer.");
	            return;
	        }
	        else {
	        	System.out.print("( ");
	            for(int i = 0; i < this.data.size(); i++) {
	            	if(i != this.data.size() - 1) {
	            		System.out.print(this.data.get(i) + ", ");
	            	} else {
	            		System.out.print(this.data.get(i));
	            	}
	            		
	            }
	        	System.out.print(" )");
	        }
	    }

	    
	    //ab hier alles automatisch von eclipse generiert
		@Override
		public boolean add(Object e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void add(int index, Object element) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean addAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int index, Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object get(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean removeAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object set(int index, Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public List subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray(Object[] a) {
			// TODO Auto-generated method stub
			return null;
		}
}