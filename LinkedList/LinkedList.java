package LinkedList;

class IntList {
    class Node {
        private int value;
        private Node next;

        Node() {
            this(0, null);
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;

    IntList() {
        head = null;
    }

    public void addToStart(int val) {
        head = new Node(val, head);
    }

    public void addToEnd(int val) {
        if (head == null) {
            head = new Node(val, null);
            return;
        }

        Node itr = head;
        while(itr.next != null) {
            itr = itr.next;
        }
        itr.next = new Node(val, null);
        return;
    }

    public Node find(int val) {
        if (head == null) return null;
        if (head.value == val) return head;

        Node itr = head;
        while(itr != null) {
            if (itr.value == val) return itr;
            itr = itr.next;
        }
        return null;
    }

    public boolean insertAfter(int x, int y) {
        if (head == null) return false;

        Node itr = head;
        while (itr != null) {
            if (itr.value == x) {
                itr.next = new Node(y, itr.next);
                return true;
            }
            itr = itr.next;
        }
        return false;
    }

    public boolean insertBefore(int x, int y) {
        if (head == null) return false;
        if (head.value == x) {
            addToStart(y);
            return true;
        }

        Node itr = head;
        while (itr.next != null) {
            if (itr.next.value == x) {
                itr.next = new Node(y, itr.next);
                return true;
            }
            itr = itr.next;
        }
        return false;
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

    public int size() {
        int count = 0;
        Node itr = head;
        while (itr != null) {
            count += 1;
            itr = itr.next;
        }
        return count;
    }

    public boolean contains(int val) {
        if (find(val) == null) {
            return false;
        }
        return true;
    }

    public boolean replace(int x, int y) {
        if (head == null) return false;
        if (head.value == x) {
            head = new Node(y, head.next);
            return true;
        }

        Node itr = head;
        while (itr.next != null) {
            if (itr.next.value == x) {
                itr.next = new Node(y, itr.next.next);
                return true;
            }
            itr = itr.next;
        }
        return false;
    }
}

public class LinkedList {
    public static void main(String args[]) {
        IntList myList = new IntList();
        myList.addToStart(12);
        myList.addToEnd(14);
        myList.addToEnd(15);
        myList.addToEnd(16);
        myList.addToEnd(17);

        myList.showListContents();
        System.out.println();
        myList.replace(12, 1);
        myList.replace(16, 2);
        myList.replace(17, 3);

        System.out.println();
        myList.showListContents();
    }
}
