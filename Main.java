import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static class LinkedQueue<T> {//empty queue
        private class Node {// empty list
            T data;
            Node next;
            Node(T data){
                this.data=data;
                this.next=null;
            }

        }
        private Node head;// uses head tail and size
        private Node tail;
        private int size;

        public LinkedQueue(){
            head=tail=null;
            size=0;
        }
        public void enqueue(T data){// queue adds from the back
            Node newNode=new Node(data);//makes node
            if(tail!=null){//if not empty
                tail.next=newNode;//adds new data to end
                tail=newNode;//makes newest data back of queue(line)
            } else{//if list is empty front is the same as back
                head=newNode;
                tail=newNode;
            }
            size++;
        }
        public T dequeue() {
            if (head == null) {//if queue empty
                throw new RuntimeException("Queue is empty");
            }
            T dataremoved = head.data;//making sure we are mpving head
            head = head.next;//assigning new head
            if(head==null){
                tail=null;
            }
            size--;
            return dataremoved;
        }
        public void enqeue(T data){
            Node newNode=new Node(data);
            if(tail!=null) {
                tail.next = newNode;
                tail = newNode;
            }
            if (head==null){
                head=tail;
            }
            size++;

        }
        public T dequeu(){
            if (head==null) {
                tail=null;
                throw new RuntimeException("Queue is empty");
            }
            T dataremoved=head.data;
            head=head.next;
            size--;
            return dataremoved;
        }

        public void enq(T data){
            Node newNode=new Node(data);
            if(tail!=null){
                newNode.next=tail;
                tail=newNode;
            }
            if(head==null){
                head=tail;
            }
        }
        public T deq(){
            if (head==null) {
                tail=null;
                throw new RuntimeException("Queue is empty");
            }
            T data=head.data;
            head=head.next;
            size--;
            return data;
        }



    }



}
