
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spaces will be removed on input");
        System.out.print("Enter an infix expression: ");
        String input = scanner.nextLine();
        String infix = input.replaceAll(" ", "");//gets rid of empty spaces in input to simplify processing



        String postfix = LinkedStack.InfixToPostfixEvaluator.infixToPostfix(infix);
        int result = LinkedStack.InfixToPostfixEvaluator.evaluatePostfix(postfix);

        System.out.println("Infix Expression:   " + infix);
        System.out.println("Postfix Expression: " + postfix);
        System.out.println("Result:             " + result);
// test inputs to copy for option 1: (((1+2)-(3-4))/(6-5)) and 2 * 4 - 2 ^ 2 ^ 1

    }
}
