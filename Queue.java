public class Queue<T> {


    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node tail, head; // pointers to front and rear
    private int size;

    // Constructor
    public Queue() {
        head = tail = null;
        size = 0;
    }

    public void enqueue(T data){//important for test
        Node newNode= new Node(data);
        if(tail != null){
            tail.next = newNode;
        }
        tail = newNode;
        if (head==null)
            head=newNode;
        size++;
    }

    public T dequeue(){//important for test
        if (head==null) return null;
        T data= head.data;
        head=head.next;
        if(head==null)
            head=null;
        size--;
        return data;
    }

    public boolean isEmpty(){
        return size==0;

    }

    public int getSize(){
        return size;
    }
}


