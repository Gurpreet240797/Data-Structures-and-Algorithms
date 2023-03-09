package LinkedList;

class MyLinked {
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

    public void partition(int x) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node itr = head;
        Node headSmaller = null;
        Node smaller = null;
        Node headGreater = null;
        Node greater = null;

        while (itr != null) {
            if (itr.value >= x) {
                if (headGreater == null) {
                    headGreater = new Node(itr.value, null);
                    greater = headGreater;
                } else {
                    greater.next = new Node(itr.value, null);
                    greater = greater.next;
                }
            } else {
                if (headSmaller == null) {
                    headSmaller = new Node(itr.value, null);
                    smaller = headSmaller;
                } else {
                    smaller.next = new Node(itr.value, null);
                    smaller = smaller.next;
                }
            }
            itr = itr.next;
        }
        smaller.next = headGreater;
        head = headSmaller;
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

public class Partition {
    public static void main(String args[]) {
        MyLinked linkedList = new MyLinked();
        linkedList.addToEnd(3);
        linkedList.addToEnd(5);
        linkedList.addToEnd(8);
        linkedList.addToEnd(5);
        linkedList.addToEnd(10);
        linkedList.addToEnd(2);
        linkedList.addToEnd(1);
        linkedList.showListContents();
        linkedList.partition(5);

        System.out.println();
        linkedList.partition(5);
        linkedList.showListContents();
    }
}
