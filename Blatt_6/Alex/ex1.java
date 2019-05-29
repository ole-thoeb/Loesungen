public class ex1 {
    public static void main (String args[]) {
        testClass.testroutine();
    }
}

class DoubleNode {
    private double data;
    private DoubleNode next;

    public DoubleNode () {
        this.data=0;
        this.next=null;
    }

    public DoubleNode (double data) {
        this.data=data;
        this.next=null;
    }

    public DoubleNode (double data, DoubleNode next) {
        this.data=data;
        this.next=next;
    }

    double getData () {
        return this.data;
    }

    DoubleNode getNext() {
        return this.next;
    }

    void setData(double data) {
        this.data=data;
    }

    void setNext(DoubleNode next) {
        this.next=next;
    }
}

class DoubleList {
    private DoubleNode head;

    public DoubleList() {
        this.head=null;
    }
    public DoubleList(DoubleNode head) {
        this.head=head;
    }

    public void add (double d) {
        DoubleNode toadd = new DoubleNode(d);
        if(this.head == null) {
            this.head = toadd;
            return;
        }
        DoubleNode current = this.head;
        while (current.getNext()!=null) current=current.getNext();
        current.setNext(toadd);
    }

    public void insertFirst (double d) {
        DoubleNode toadd = new DoubleNode(d,this.head);
        this.head=toadd;
    }

    public double get(int i) {
        if(this.head == null) return 0.1;
        DoubleNode current = this.head;
        for(int j=0; j<i; j++) {
            if(current.getNext() == null) return current.getData();
            else current=current.getNext();
        }
        return current.getData();
    }

    public String toString() {
        String list= "";
        if(this.head==null) return "List is empty";
        DoubleNode current = this.head;
        while (current != null) {
            list= list + current.getData() + ";";
            current = current.getNext();
        }
        return list;
    }

    public void remove (int i) {
        if(i<0) {
            System.out.println("could not remove negative index.");
        }
        if(this.head == null) {
            System.out.println("could not remove from empty list");
        }
        if(i==0 && this.head.getNext()!=null) {
            DoubleNode newhead = this.head;
            newhead= newhead.getNext();
            this.head=newhead;
            return;
        }
        DoubleNode last = this.head;
        DoubleNode current = last.getNext();
        for(int j=1; j<i; j++) {
            if(current.getNext()==null) {
                System.out.println("could not remove. index too high");
                return;
            }
            current= current.getNext();
            last=last.getNext();
        }
        if(current.getNext()==null) {
            last.setNext(null);
            return;
        }
        else {
            DoubleNode skip = current.getNext();
            last.setNext(skip);
        }
    }
}

class testClass {
        public static void testroutine() {
            DoubleList testlist = new DoubleList();
            testlist.add(1);
            testlist.add(2);
            testlist.add(3);
            System.out.println("erstellte Liste nach add: " + testlist.toString());
            testlist.insertFirst(4);
            testlist.insertFirst(5);

            System.out.println("erstellte Liste: " + testlist.toString());
            testlist.remove(2);
            testlist.remove(0);
            testlist.remove(2);

            System.out.println("nach remove: " + testlist.toString());

            System.out.println("erster Wert: " + testlist.get(0));
        }
}