package blatt06;

public class DoubleList {
	private DoubleNode head;
	public void add(double d){
		//DoubleNode n=new DoubleNode();
		if (head == null) {
			insertFirst(d);
		}
		else {
			DoubleNode cursor=head;
			while(cursor.getnext()!=null)
			{
				cursor=cursor.getnext();
			}
			cursor.setnext(new DoubleNode());
			cursor.getnext().setWert(d);
		}
	}
	public void insertFirst(double d){
	/*	DoubleList newnode=new DoubleList();
		newnode.head.setWert(d);
		//PROBLEM
		if (head!=null) {
			
		}	
		this.head=newnode.head;
		*/
		DoubleNode newnode=new DoubleNode();
		if (head!=null) {
			DoubleNode oldnode=new DoubleNode();
			oldnode.setWert(head.getWert());
			if(head.getnext()!=null){
				oldnode.setnext(head.getnext());
			}
			head.setnext(oldnode);
		}	
		else {
		head=newnode;
		}
		head.setWert(d);
		
	}
	public String toString() {
/*
 	Rekursion funktioniert nicht, weil ich über die Nodes gehe, aber toString von der Liste kommt
		if (head==null) {
			return " ";
		}
		else if (head.getnext()==null){
			return "" + (head.getWert()) + "; ";
		}
		else {
			return ("" + (head.getWert()) + "; " + head.getnext().toString());
		}
*/		
	String listenString="";
	DoubleNode cursor=this.head;
		if(cursor==null){
			return listenString;
		}
		
		while(cursor!=null){
			listenString="" +  listenString + cursor.getWert();
			if (cursor.getnext()!=null) {
				listenString="" +  listenString + "; ";
			}
			cursor=cursor.getnext();
		}
		return listenString;
		
	}
	public void remove(int i) {
		if(this.head==null|| i<0) {
			throw new IndexOutOfBoundsException();
		}
		if (i==0) {
			head=head.getnext();
			return;
		}
		DoubleNode alt=null;
		DoubleNode cursor=head;
		for (int j=0;j<i;j++) {
			alt=cursor;
			cursor=cursor.getnext();
			if(cursor==null) {
				throw new IndexOutOfBoundsException();
			}
		}
		alt.setnext(cursor.getnext());

		
		
		
		
	}
	public void testClass(double a, double b, double c, double d, double e) {
		this.add(a);
		this.add(b);
		this.add(c);
		this.insertFirst(d);
		this.insertFirst(e);
		System.out.println(this.toString());
		this.remove(2);
		this.remove(0);
		this.remove(2);
		System.out.println(this.toString());
		System.out.println(this.head.getWert());
		
		
	}
}
