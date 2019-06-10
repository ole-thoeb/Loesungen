/**
 * Preorder: 10, 5, 3, 4, 7, 12, 15, 13
 * Postorder: 4, 3, 7, 5, 13, 15, 12, 10
 * Inorder: 3, 4, 5, 7, 10, 12, 13, 15
 */

public class Nr3 {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(10, 10);
		tree.insert(5, 5);
		tree.insert(12, 12);
		tree.insert(3, 3);
		tree.insert(7, 7);
		tree.insert(15, 15);
		tree.insert(4, 4);
		tree.insert(13, 13);

		tree.preorder();
		tree.inorder();
		tree.postorder();
		tree.levelorder();
	}
}