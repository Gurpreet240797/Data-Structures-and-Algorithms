package Stack;

class MyStack {
    private int max = 30;
    private char[] arr = new char[max];
    private int top;

    MyStack() {
        top = -1;
    }

    boolean push(char x) {
        if (top == max - 1) {
            System.out.println("Stack Overflow.");
            return false;
        } else {
            arr[++top] = x;
            System.out.println("Added Element " + x);
            return true;
        }
    }

    char pop() {
        if (top < 0) {
            System.out.println("Stack Underflow.");
            return 0;
        } else {
            char x = arr[top--];
            return x;
        }
    }

    char peek() {
        if (top < 0) {
            System.out.println("Stack Underflow.");
            return 0;
        } else {
            char x = arr[top];
            return x;
        }
    }

    int size() {
        if (top < 0) {
            return 0;
        } else {
            return top+1;
        }
    }

    boolean isEmpty () {
        if (top < 0) {
            return true;
        } else {
            return false;
        }
    }
}

public class isValidParentheses {
    public static void main (String args[]) {
        String input = "(((";
        boolean response = isValid(input);

        if (response) {
            System.out.println("Valid Parentheses!");
        } else {
            System.out.println("Not Valid Parentheses!");
        }
    }

    public static boolean isValid (String input) {
        MyStack mystack = new MyStack();
        for (char i=0; i<input.length(); i++) {
            switch(input.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    mystack.push(input.charAt(i));
                    break;
                case '}':
                    if (mystack.isEmpty() || mystack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (mystack.isEmpty() || mystack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (mystack.isEmpty() || mystack.pop() != '(') {
                        return false;
                    }
                    break;
            }
        }
        return mystack.isEmpty();
    }
}
