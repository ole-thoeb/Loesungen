package Stack;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class StackImp<E> implements Stack<E> {
	private Node head;	
	public void push(E w) {
		Node newnode=new Node();
		newnode.wert=w;
		newnode.next=head;
		head=newnode;
		
	}
	public E pop(){
	////	try{
			//if(head!=null) {
				E w=head.wert;
				//if(head.next!=null) {
					head=head.next;
				//}
				return w;
			//}
		////}catch (NullPointerException e) {   }
		 
		
	}
	class Node{
		E wert;
		Node next;
	}
	@Override
	public boolean add(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void add(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int arg0, Collection arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object arg0) {
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
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object set(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void push() {
		// TODO Auto-generated method stub
		
	}
}
