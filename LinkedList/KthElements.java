package LinkedList;

class Linked {
    private Node head;
    private int size = 0;

    public void addToEnd(int val) {
        if (head == null) {
            head = new Node(val, null);
            size += 1;
            return;
        }

        Node itr = head;
        while(itr.next != null) {
            itr = itr.next;
        }
        itr.next = new Node(val, null);
        size += 1;
        return;
    }

    public void showListContents() {
        if (head == null) {
            System.out.println("Linked List is Empty.");
            return;
        }

        Node itr = head;
        while (itr != null) {
            System.out.println(itr.value);
            itr = itr.next;
        }
    }

    public void kthElement(int k) {
        if (head == null) {
            System.out.println("No Element in the LinkedList.");
            return;
        }

        int ignoreElement = size - k + 1;
        Node itr = head;

        while (itr != null) {
            if (ignoreElement == 1) {
                System.out.println(itr.value);
            } else {
                ignoreElement--;
            }
            itr = itr.next;
        }
    }

    class Node {
        private int value;
        private Node next;

        Node() { this(0, null); }
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

public class KthElements {
    public static void main(String args[]) {
        Linked linkedList = new Linked();
        linkedList.addToEnd(7);
        linkedList.addToEnd(2);
        linkedList.addToEnd(7);
        linkedList.addToEnd(7);
        linkedList.showListContents();

        System.out.println();
        linkedList.kthElement(2);
    }
}
