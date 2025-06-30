package neet_code.stack;

import java.util.Stack;

public class _739_DailyTemperatures {
    public static void main(String[] args) {

    }

    // monotonic stack
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> monotonicDescStack = new Stack<>();
        int length = temperatures.length;
        int[] result = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            int current = temperatures[i];

            while (!monotonicDescStack.isEmpty() && current >= temperatures[monotonicDescStack.peek()]) {
                monotonicDescStack.pop();
            }

            if (!monotonicDescStack.isEmpty()) {
                result[i] = monotonicDescStack.peek() - i;
            }
            monotonicDescStack.push(i);
        }

        return result;
    }
}
