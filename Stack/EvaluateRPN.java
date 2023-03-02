package Stack;

import java.util.Stack;

public class EvaluateRPN {
    public static void main(String args[]) {
        String[] tokens = {"2","1","+","3","*"};
        int result = evalRPN(tokens);
        System.out.println(result);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String t : tokens) {
            if ("+-*/".contains(t)) {
                stack.push(evaluate(stack.pop(), stack.pop(), t));
            } else {
                stack.push(Integer.parseInt(t));
            }
        }

        return stack.pop();
    }

    public static int evaluate(int b, int a, String operator) {
        if ("+".equals(operator)) return a+b;
        else if ("-".equals(operator)) return a-b;
        else if ("*".equals(operator)) return a*b;
        else return a/b;
    }
}
