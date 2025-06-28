package neet_code.stack;

import java.util.Stack;

public class _150_EvaluateReversePolishNotation {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            switch (c) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first - second);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first / second);
                }
                default -> stack.push(Integer.parseInt(c));
            }
        }

        return stack.peek();
    }
}
