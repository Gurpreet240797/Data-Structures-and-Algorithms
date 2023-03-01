package Stack;
import java.util.EmptyStackException;

class Pair {
    private int minElement;
    private int element;

    Pair(int minElement, int element){
        this.minElement = minElement;
        this.element = element;
    }

    public int getMinElement() {
        return minElement;
    }

    public int getElement() {
        return element;
    }
}

class UserStack {
    private int max = 30;
    private Pair arr[] = new Pair[max];
    private int top;

    UserStack() {
        top = -1;
    }

    void push(Pair x) {
        if (top-1 == max) {
            throw new StackOverflowError();
        } else {
            arr[++top] = x;
        }
    }

    Pair pop() {
        if (top < 0) {
            throw new EmptyStackException();
        } else {
            return arr[top--];
        }
    }

    Pair peek() {
        if (top < 0) {
            throw new EmptyStackException();
        } else {
            return arr[top];
        }
    }

    boolean isEmpty () {
        return top < 0 ? true : false;
    }

    int size () {
        return top < 0 ? 0 : top+1;
    }
}

public class MinStack {
    UserStack stack;

    MinStack () {
        stack = new UserStack();
    }

    public void push (int val) {
        if (stack.isEmpty()) {
            Pair p = new Pair(val, val);
            stack.push(p);
        } else {
            Pair top = stack.peek();
            Pair p = null;
            if (val < top.getMinElement()) {
                p = new Pair(val, val);
            } else {
                p = new Pair(top.getMinElement(), val);
            }
            stack.push(p);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek().getElement();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek().getMinElement();
    }

    public static void main(String args[]) {
        MinStack minStack = new MinStack();
        minStack.push(-3);
        minStack.push(0);
        minStack.push(-2);
        System.out.println("MIN VALUE :: " + minStack.getMin());
        System.out.println("TOP VALUE :: " + minStack.top());
        minStack.pop();
        System.out.println("MIN VALUE :: " + minStack.getMin());
    }
}