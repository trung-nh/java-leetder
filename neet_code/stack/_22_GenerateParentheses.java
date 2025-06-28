package neet_code.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _22_GenerateParentheses {
    public static void main(String[] args) {

    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        current.append('(');

        helper(result, current, 1, 0, n);

        return result;
    }

    private static void helper(List<String> result, StringBuilder current, int currentOpening, int currentClosing, int pairs) {
        if (currentOpening == pairs) {
            StringBuilder permutation = new StringBuilder(current);
            int postfixCount = pairs - currentClosing;

            while (postfixCount > 0) {
                permutation.append(")");
                postfixCount--;
            }

            result.add(String.valueOf(permutation));
        } else {
            current.append('(');
            helper(result, current, currentOpening + 1, currentClosing, pairs);
            current.deleteCharAt(current.length() - 1);

            if (currentOpening > currentClosing) {
                current.append(')');
                helper(result, current, currentOpening, currentClosing + 1, pairs);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
