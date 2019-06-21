public class ex3 {
    public static void main(String[] args) {
        Queue<Integer> myq = new Queue<Integer>();
        myq.enqueue(1);
        myq.enqueue(2);
        myq.enqueue(3);
        myq.enqueue(4);
        myq.enqueue(5);

        System.out.println("added 1...5 \nnow get first 4 elements:");
        for(int i=0; i<4;i++) System.out.print(myq.dequeue() + " | ");

        System.out.println("\nQueue has now length of: " + myq.size());
        System.out.println("Trying to add 30 elements...");
        for(int i=0; i<30; i++) {
            try {
                myq.enqueue(i);
            } catch (QueueTooLongException x) {
                x.printStackTrace();
            }
        }

        
    }
}



class Queue<T> {
    Node<T> head;
    int size;

    public Queue() {
        head=null;
        size=0;
    }

    public Queue(Node <T> head) {
        this.head=head;
        size=1;
    }

    public void enqueue (T data) {
        if(size==30){
            throw new QueueTooLongException();
        }
        Node<T> newnode = new Node<T>(data);
        size++;
        if(head==null) head=newnode;
        else {
            Node<T> curr= head;
            while(curr.getNext()!=null) curr=curr.getNext();
            curr.setNext(newnode);
        }
    }

    public T dequeue () {
        if(head==null) {
            System.err.println("Queue is empty, can't dequeue, returning null!");
            return null;
        }
        size--;
        Node<T> curr=head;
        head=head.getNext();
        return curr.getData();
    }

    public int size() {
        return this.size;
    }


    //inner class for each node
    private class Node<T> {
        T data;
        Node<T> next;
    
        public Node (T data) {
            this.data=data;
            this.next=null;
        }
    
        public Node (T data, Node<T> next) {
            this.data=data;
            this.next=next;
        }
    
        public Node<T> getNext() {
            return this.next;
        }
    
        public void setNext(Node<T> newnode) {
            this.next=newnode;
        }
    
        public T getData() {
            return this.data;
        }
    }
}

class QueueTooLongException extends RuntimeException {
    public String toString() {
        return "Queue too long!";
    }
}