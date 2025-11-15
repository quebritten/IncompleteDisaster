import java.util.Stack;

public class Tester {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack);
        System.out.print(stack.push(4));
        System.out.println(stack);
        System.out.print(stack.push(3));
        System.out.println(stack);
        System.out.print(stack.push(2));
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
