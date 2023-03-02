package Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    static List<String> result = new ArrayList<>();
    static Stack<String> stack = new Stack<>();

    public static void main (String args[]) {
        int n = 2;
        generateParenthesis(0, 0, n);
        for (String i : result) {
            System.out.println(i);
        }
    }

    public static void generateParenthesis(int open, int close, int n) {
        // Adding opening brackets when open < n
        // Adding closing brackets when close < open
        // Return when open == close == n
        if (open == close && close == n) {
            String parenthesis = "";
            for (String p : stack) {
                parenthesis = parenthesis + p;
            }
            result.add(parenthesis);
            return;
        }

        if (open < n) {
            stack.add("(");
            generateParenthesis(open+1, close, n);
            stack.pop();
        }

        if (close < open) {
            stack.add(")");
            generateParenthesis(open, close+1, n);
            stack.pop();
        }
    }
}
