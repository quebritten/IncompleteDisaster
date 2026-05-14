import java.util.LinkedList;
import java.util.Queue;

public class Tester extends Main {

    public static void main(String[] args) {
        Main.LinkedQueue<Integer> queue = new LinkedQueue<>();

        System.out.println(queue);
        queue.enqueue(10);
        System.out.println(queue);
        queue.enqueue(20);
        System.out.println(queue);
        queue.enqueue(30);
        System.out.println(queue);
        queue.enqueue(10);
        System.out.println(queue);
        queue.enqueue(20);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);


    }
}
