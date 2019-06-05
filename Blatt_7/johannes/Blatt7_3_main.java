/* Nr. a)
 * PreOrder: { 10 5 3 4 7 12 15 13 }
 * PostOrder: { 4 3 7 5 13 15 12 10 }
 * InOrder: { 3 4 5 7 10 12 13 15 }
 */

import java.util.LinkedList;
class TNode{
	private int i;
	private TNode left;
	private TNode right;
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public TNode getLeft() {
		return left;
	}
	public void setLeft(TNode left) {
		this.left = left;
	}
	public TNode getRight() {
		return right;
	}
	public void setRight(TNode right) {
		this.right = right;
	}

	public TNode(int i) {
		this.setI(i);
		this.setLeft(null);
		this.setRight(null);
	}
}

class Baum {
    private TNode root;
    public Baum (TNode root) {
        this.root = root;
    }
    
    public TNode getRoot() {
    	return this.root;
    }
    
    public String printPre(TNode current, String strPre) {
    	strPre = strPre + " " + current.getI();
        if(current.getLeft() != null) strPre = printPre(current.getLeft(), strPre);
        if(current.getRight()!=null) strPre = printPre(current.getRight(), strPre);
        return strPre;
    }

    public String printPost(TNode current, String strPost) {   	
        if(current.getLeft() != null) strPost = printPost(current.getLeft(), strPost);     
        if(current.getRight()!= null) strPost = printPost(current.getRight(), strPost);
        strPost = strPost + " " + current.getI();
        return strPost;
    }

    public String printIn(TNode current, String strIn) {
        if(current.getLeft() != null) strIn = printIn(current.getLeft(), strIn);     
        strIn = strIn + " " + current.getI();
        if(current.getRight() != null) strIn = printIn(current.getRight(), strIn);
        return strIn;
    }
    
    public String printLevel(String strLevel) {
        LinkedList<TNode> queue = new LinkedList<TNode>();
        queue.add(this.root);
        while(!queue.isEmpty()) {
        	strLevel = strLevel + " " + queue.getFirst().getI();
            if(queue.getFirst().getLeft()!=null) queue.add(queue.getFirst().getLeft());
            if(queue.getFirst().getRight()!=null) queue.add(queue.getFirst().getRight());      
            queue.pop();
        }
       
        return strLevel;
    }
}

public class Blatt7_3_main {
	public static void main(String[] args) {		
		TNode ten = new TNode(10);
		TNode five = new TNode(5);
		TNode three = new TNode(3);
		TNode seven = new TNode(7);
		TNode four = new TNode(4);
		TNode twelve = new TNode(12);
		TNode fifteen = new TNode(15);
		TNode thirteen = new TNode(13);
		
		ten.setLeft(five);
		ten.setRight(twelve);
		five.setLeft(three);
		five.setRight(seven);
		three.setRight(four);
		twelve.setRight(fifteen);
		fifteen.setLeft(thirteen);
		
		Baum root = new Baum(ten);
		
		//PreOrder
		String strPre = "{";
		strPre = root.printPre(root.getRoot(), strPre);
		System.out.println("PreOrder: " + strPre + " }");
		
		//PostOrder
		String strPost = "{";
		strPost = root.printPost(root.getRoot(), strPost);
		System.out.println("PostOrder: " + strPost + " }");
		
		//InOrder
		String strIn = "{";
		strIn = root.printIn(root.getRoot(), strIn);
		System.out.println("InOrder: " + strIn + " }");
		
		//LevelOrder
		String strLevel = "{";
		strLevel = root.printLevel(strLevel);
		System.out.println("LevelOrder: " + strLevel + " }");
	}
}
