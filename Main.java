import java.util.Stack;

public class Main {
    public class LinkedStack<T>{// generic LS implement
        private class Node{
            T data;// takes Data as input
            Node next;
            Node(T data){
                this.data = data;//instantiating
                this.next = null;
            }
        }
        private Node top;
        private int size;

        public LinkedStack(){
            top = null;
            size=0;
        }
        public void push(T data) {
            Node newNode = new Node(data);// makes new node
            newNode.next = top;// add new Node assign it to the top NN always top
            top = newNode;// assigns new node as top
            size++;//increases size by 1
        }
        public T pop() {//no param for pop it is showing cur top then removing it
            if (top == null) {// if empty stop
                throw new RuntimeException("Stack Empty");
            }
            T data = top.data;//making sure you are at top
            top=top.next;//going down the stack
            size--;//decreases by 1
            return data;// returning old top which is data
        }
        public void psh(T data){
            Node newNode= new Node(data);
            newNode.next=top;
            top=newNode;
            size++;

        }

        public T pp(){
            if(top==null){
                throw new RuntimeException("Stack Empty");
            }
            T data= top.data;
            top=top.next;
            size--;
            return data;
        }



    }

}
