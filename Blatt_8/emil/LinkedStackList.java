import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedStackList<T> implements StackList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	LinkedStackList() {}

	LinkedStackList(Collection<? extends T> c) {
		addAll(c);
	}

	@Override
	public boolean remove(Object o) {
		for (Node<T> cur = head; cur != null; cur = cur.getNext()) {
			if (o == cur.getValue() || (o != null && o.equals(cur.getValue()))) {
				unLink(cur);
				return true;
			}
		}
		return false;
	}

	private T unLink(Node<T> node) {
		if (node == head) {
			head = node.getNext();
		} else {
			node.getPrevious().setNext(node.getNext());
		}
		if (node == tail) {
			tail = node.getPrevious();
		} else {
			node.getNext().setPrevious(node.getPrevious());
		}
		size--;
		return node.getValue();
	}

	private void linkBefore(T value, Node<T> before) {
		Node<T> node = new Node<>(before.getPrevious(), value, before);
		before.setPrevious(node);
		if (before == head) {
			head = node;
		}
		size++;
	}

	private void linkLast(T value) {
		Node<T> newNode = new Node<>(null, value, null);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			Node<T> oldTail = tail;
			oldTail.getNext().setNext(newNode);
			newNode.getPrevious().setNext(oldTail);
			tail = newNode;
		}
		size++;
	}

	@Override
	public int lastIndexOf(Object o) {
		Node<T> cur = tail;
		int index = size() -1;
		while (cur != null) {
			if (o == cur.getValue() || (o != null && o.equals(cur.getValue()))) {
				return index;
			}
			cur = cur.getPrevious();
			index--;
		}
		return -1;
	}

	@Override
	public int indexOf(Object o) {
		Node<T> cur = head;
		int index = 0;
		while (cur != null) {
			if (o == cur.getValue() || (o != null && o.equals(cur.getValue()))) {
				return index;
			}
			cur = cur.getNext();
			index++;
		}
		return -1;
	}

	@Override
	public T set(int index, T element) {
		//checkIndex(index);
		/*if (index == size()) {
			add(element);
			return null;
		} else {*/
			//Node<T> cur = head;
			//for (int i = 0; i < index; i++) {
			//	cur = cur.getNext();
			//}
			//T oldValue = cur.getValue();
			//cur.setValue(element);
			//return oldValue;
		//}
		Node<T> node = nodeAt(index);
		T oldValue = node.getValue();
		node.setValue(element);
		return oldValue;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean removed = false;
		for (Node<T> cur = head; cur != null; cur = cur.getNext()) {
			if (!c.contains(cur.getValue())) {
				removed = true;
				unLink(cur);
			}
		}
		return removed;
	}

	@Override
	public T remove(int index) {
		return unLink(nodeAt(index));
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean removed = false;
		for (Object o : c) {
			if (remove(o)) {
				removed = true;
			}
		}
		return removed;
	}

	@Override
	public boolean contains(Object o) {
		for (Node<T> cur = head; cur != null; cur = cur.getNext()) {
			if (o == cur.getValue() || (o != null && o.equals(cur.getValue()))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;
	}

	@Override
	public Iterator<T> iterator() {
		return listIterator();
	}

	@Override
	public ListIterator<T> listIterator() {
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return null;
	}

	private Node<T> nodeAt(int index) {
		checkElementIndex(index);
		Node<T> cur = head;
		for (int i = 0; i < index; i++) {
			System.out.println(i);
			cur = cur.getNext();
		}
		return cur;
	}

	private class ListIter implements ListIterator<T> {

		private int nextIndex;
		private Node<T> lastReturned;
		private Node<T> next;

		ListIter(int index) {
			checkElementIndex(index);
			nextIndex = index;
			next = nodeAt(index);
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastReturned = next;
			next = next.getNext();
			nextIndex++;
			return lastReturned.getValue();
		}

		@Override
		public boolean hasPrevious() {
			return next.getPrevious() != null;
		}

		@Override
		public T previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			next = next.getPrevious();
			lastReturned = next;
			nextIndex--;
			return lastReturned.getValue();
		}

		@Override
		public int nextIndex() {
			return nextIndex;
		}

		@Override
		public int previousIndex() {
			return nextIndex - 1;
		}

		@Override
		public void remove() {
			if (lastReturned == null) throw new IllegalStateException();
			unLink(lastReturned);
			//were traversing backwards
			if (lastReturned == next) {
				next = lastReturned.getPrevious();
			} else {
				nextIndex--;
			}
			lastReturned = null;
		}

		@Override
		public void set(T e) {
			if (lastReturned == null) throw new IllegalStateException();
			lastReturned.setValue(e);
		}

		@Override
		public void add(T e) {
			if (next == null) {
				linkLast(e);
			} else {
				linkBefore(e, next);
			}
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return tail == null && head == null;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size()];
		int i = 0;
		for (Node<T> cur = head; cur != null; cur = cur.getNext()) {
			arr[i] = cur.getValue();
			i++;
		}
		return arr;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <E> E[] toArray(E[] a) {
		if (a.length < size()) {
			a = (E[]) Array.newInstance(a.getClass().getComponentType(), size());
		}
		Object[] arr = a;
		int i = 0;
		for (Node<T> cur = head; cur != null; cur = cur.getNext()) {
			arr[i] = cur.getValue();
			i++;
		}
		
		if (a.length > size) a[size] = null;

		return a;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		if (c.isEmpty()) return false;
		for (T element : c) {
			add(element);
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		checkPositionIndex(index);
		if (c.isEmpty()) return false;
		if (index == size()) return addAll(c);
		Node<T> successor = nodeAt(index);
		Node<T> predecessor = successor.getPrevious();
		for (T element : c) {
			Node<T> node = new Node<>(predecessor, element, null);
			predecessor.setNext(node);
			predecessor = node;
		}
		predecessor.setNext(successor);
		successor.setPrevious(predecessor);
		size += c.size();
		return true;
	}

	@Override
	public T get(int index) {
		checkElementIndex(index);
		return nodeAt(index).getValue();
	}
	
	@Override
	public boolean add(T e) {
		linkLast(e);
		return true;
	}

	@Override
	public void add(int index, T element) {
		checkPositionIndex(index);
		if (index == size()) add(element);
		else linkBefore(element, nodeAt(index));
	}

	@Override
	public LinkedStackList<T> subList(int fromIndex, int toIndex) {
		checkElementIndex(fromIndex);
		checkElementIndex(toIndex);
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException("fromIndex(" + fromIndex + ") is greater than toIndex(" + toIndex + ")");
		}
		if (fromIndex == toIndex) return new LinkedStackList<T>();

		LinkedStackList<T> retList = new LinkedStackList<>();
		Node<T> cur = nodeAt(fromIndex);
		for (int i = fromIndex; i <= toIndex; i++) {
			retList.add(cur.value);
			cur = cur.getNext();
		}
		return retList;
	}

	@Override
	public void push(T element) {
		add(0, element);
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return unLink(head);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append('(');
		for (Node<T> cur = head; cur != null; cur = cur.getNext()) {
			buffer.append(cur.getValue().toString());
			if (cur.getNext() != null) buffer.append(", ");
		}
		buffer.append(')');
		return buffer.toString();
	}

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size();
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size();
	}
	
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size();
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
    }

	private void checkPositionIndex(int index) {
		if (!isPositionIndex(index)) {
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}

	private static final class Node<T> {
		private Node<T> next;
		private Node<T> previous;
		private T value;

		Node(Node<T> previous, T value, Node<T> next) {
			this.previous = previous;
			this.value = value;
			this.next = next;
		}

		void setNext(Node<T> next) {
			this.next = next;
		}

		Node<T> getNext() {
			return next;
		}
		
		void setPrevious(Node<T> previous) {
			this.previous = previous;
		}

		Node<T> getPrevious() {
			return previous;
		}

		void setValue(T value) {
			this.value = value;
		}

		T getValue() {
			return value;
		}
	}
}