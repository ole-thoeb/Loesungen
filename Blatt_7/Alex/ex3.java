/* a.
    Preorder: 10 - 5 - 3 - 4 - 7 - 12 - 15 - 13
    Postorder: 4 - 3 - 7 - 5 - 13 - 15 - 12 - 10
    Inorder: 3 - 4 - 5 - 7 - 10 - 12 - 13 - 15
*/

//b.
import java.util.LinkedList;

class TNode {
    private int data;
    private TNode leftchild, rightchild, parent;

    public TNode (int data) {
        this.data=data;
        this.leftchild=null;
        this.rightchild=null;
        this.parent=null;
    }

    public TNode (int data, TNode leftchild){
        this.data=data;
        this.leftchild=leftchild;
        this.rightchild=null;
        this.parent=null;
    }

    public TNode (int data, TNode leftchild, TNode rightchild) {
        this.data=data;
        this.leftchild=lefthild;
        this.rightchild=rightchild;
        this.parent=null;
    }

    public TNode (int data, TNode leftchild, TNode rightchild, TNode parent) {
        this.data=data;
        this.leftchild=lefthild;
        this.rightchild=rightchild;
        this.parent=parent;
    }

    

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data=data;
    }

    public TNode getLeftChild() {
        return this.leftchild;
    }

    public TNode getRightChild() {
        return this.rightchild;
    }

    public void setLeftChild(TNode leftchild) {
        this.leftchild=leftchild;
    }

    public void setRightChild(TNode rightchild) {
        this.rightchild=rightchild;
    }

    public void setChildren(TNode leftchild, TNode rightchild) {
        this.leftchild=leftchild;
        this.rightchild=rightchild;
    }

    public TNode getParent() {
        return this.parent;
    }

    public void setParent (TNode parent) {
        this.parent=parent;
    }

}

class Baum {
    private TNode root;

    public Baum (int data) {
        this.root = new Tnode(data);
    }

    public Baum (TNode root) {
        this.root=root;
    }

    public void SetRoot (TNode root) {
        this.root=root;
    }

    public TNode getRoot() {
        return this.root;
    }

    public int getRootData() {
        return this.root.getData();
    }

    public void printPreorder(TNode current) {
        System.out.println(current.getData());
        if(current.getLeftChild() != null) printPreorder(current.getLeftChild());
        if(current.getRightChild()!=null) printPreorder(current.getRightChild());
            
    }

    public void printPostorder(TNode current) {
        if(current.getLeftChild() != null) printPostorder(current.getLeftChild());
        if(current.getRightChild()!=null) printPostorder(current.getRightChild());
        System.out.println(current.getData());
        
    }

    public void printInorder(TNode current) {
        if(current.getLeftChild() != null) printInorder(current.getLeftChild());
        System.out.println(current.getData());
        if(current.getRightChild()!=null) printInorder(current.getRightChild());
    }

    public void printLevelOrder() {
        LinkedList<TNode> queue = new LinkedList();
        queue.add(this.root);
        while(!queue.isEmpty()) {
            System.out.println(queue.getFirst().getData());
            if(queue.getFirst().getLeftChild()!=null) queue.add(queue.getFirst().getLeftChild());
            if(queue.getFirst().getRightChild()!=null) queue.add(queue.getFirst().getRightChild());
            queue.pop();
        }
    }
}

public class ex3 {
    public static void main (String[] agrs) {
        //(Baum aus der Aufgabe)
        TNode root = new TNode(10);
        TNode five = new TNode(5);
        TNode three = new TNode(3);
        TNode four = new TNode(4);
        TNode seven = new TNode(7);
        TNode twelve = new TNode(12);
        TNode fifteen = new TNode(15);
        TNode thirteen = new TNode(13);

        root.setChildren(five,twelve);
        five.setChildren(three, seven);
        three.setRightChild(four);
        twelve.setRightChild(fifteen);
        fifteen.setLeftChild(thirteen);

        Baum tree = new Baum(root);

        System.out.println("Preorder-transversal:");
        tree.printPreorder(tree.getRoot());

        System.out.println("Postorder-transversal:");
        tree.printPostorder(tree.getRoot());

        System.out.println("Inorder-transversal:");
        tree.printInorder(tree.getRoot());

        System.out.println("Levelorder-transversal: ");
        tree.printLevelOrder();

    }
}