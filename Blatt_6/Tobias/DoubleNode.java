package blatt06;

public class DoubleNode {
	private double wert;
	private DoubleNode next;
	public double getWert() {
		return wert;
	}
	public void setWert(double wert) {
		this.wert = wert;
	}
	public DoubleNode getnext() {
		return next;
	}
	public void setnext(DoubleNode next) {
		this.next = next;
	}
	DoubleNode(){
	}
	DoubleNode(double wert){
		this.wert=wert;
	}
	
}
