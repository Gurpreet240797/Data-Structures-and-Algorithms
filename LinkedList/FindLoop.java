package LinkedList;

class Init {
    class Node {
        int value;
        Node next;
        boolean visited;

        Node() {this(0, null, false);}
        Node(int value, Node next, boolean visited) {
            this.value = value;
            this.next = next;
            this.visited = false;
        }
    }

    Node head;

    public void addToEnd(int val) {
        if (head == null) {
            head = new Node(val, null, false);
            return;
        }

        Node itr = head;
        while (itr.next != null) {
            itr = itr.next;
        }
        itr.next = new Node(val, null, false);
    }

    public void createLoop(int val) {
        Node itr = head;
        while (itr.next != null) {
            itr = itr.next;
        }
        itr.next = new Node(val, head, false);
    }

    public void showContents() {
        Node itr = head.next;
        System.out.println(head.value);
        while (itr != null) {
            if (itr.value != head.value) {
                System.out.println(itr.value);
                itr = itr.next;
            } else {
                itr = null;
            }
        }
    }

    public void detect() {
        Node itr = head;
        while (itr.next != null) {
            if (itr.visited == true) {
                System.out.println("CYCLE EXISTS");
                return;
            }
            itr.visited = true;
            itr = itr.next;
        }
        System.out.println("CYCLE DOES NOT EXISTS");
    }
}

public class FindLoop {
    public static void main (String args[]) {
        Init LinkedList = new Init();
        LinkedList.addToEnd(1);
        LinkedList.addToEnd(2);
        LinkedList.addToEnd(3);
        LinkedList.createLoop(4);
        LinkedList.showContents();
        LinkedList.detect();
    }
}

// 1-2-3-1
