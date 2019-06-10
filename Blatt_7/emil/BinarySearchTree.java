import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchTree<T> {

	private TNode<T> root;

	BinarySearchTree() {
	}

	void insert(T value, int key) {
		if (root != null) root.insert(new TNode<T>(value, key));
		else root = new TNode<T>(value, key);
	}

	void preorder() {
		if (root != null) {
			root.preorder();
			System.out.println();
		}
	}
	
	void inorder() {
		if (root != null) {
			root.inorder();
			System.out.println();
		}
	}
	
	void postorder() {
		if (root != null) {
			root.postorder();
			System.out.println();
		}
	}

	void levelorder() {
		LinkedList<TNode<T>> queue = new LinkedList<>();
		queue.push(root);
		while (!queue.isEmpty()) {
			TNode<T> node = queue.pop();
			if (node != null) {
				System.out.print(node.getValue() + ", ");
				queue.addLast(node.getLeft());
				queue.addLast(node.getRight());
			}
			//Iterator<TNode<T>> iter = queue.iterator();
			//while (iter.hasNext()) {
			//	TNode<T> node = iter.next();
			//	if (node != null) {
			//		System.out.print(node.getValue() + ", ");
			//		
			//	}
			//}
		}
		System.out.println();
	}

	private static class TNode<T> {
		private T value;
		private int key;
		private TNode<T> left;
		private TNode<T> right;

		TNode(T value, int key) {
			this.value = value;
			this.key = key;
		}

		TNode(T value, int key, TNode<T> left, TNode<T> right) {
			this.value = value;
			this.key = key;
			this.left = left;
			this.right = right;
		}

		int getKey() {
			return key;
		}

		void setValue(T value) {
			this.value = value;
		}

		T getValue() {
			return value;
		}
		
		void setLeft(TNode<T> left) {
			this.left = left;
		}

		TNode<T> getLeft() {
			return left;
		}

		void setRight(TNode<T> right) {
			this.right = right;
		}

		TNode<T> getRight() {
			return right;
		}

		void insert(TNode<T> value) {
			if (value.getKey() > getKey()) {
				if (getRight() == null) {
					setRight(value);
				} else {
					getRight().insert(value);
				}
			} else {
				if (getLeft() == null) {
					setLeft(value);
				} else {
					getLeft().insert(value);
				}
			}
		}

		void preorder() {
			System.out.print(value);
			System.out.print(", ");
			if (getLeft() != null) getLeft().preorder();
			if (getRight() != null) getRight().preorder();
		}

		void inorder() {
			if (getLeft() != null) getLeft().inorder();
			System.out.print(value);
			System.out.print(", ");
			if (getRight() != null) getRight().inorder();
		}

		void postorder() {
			if (getLeft() != null) getLeft().postorder();
			if (getRight() != null) getRight().postorder();
			System.out.print(value);
			System.out.print(", ");
		}
	}
}