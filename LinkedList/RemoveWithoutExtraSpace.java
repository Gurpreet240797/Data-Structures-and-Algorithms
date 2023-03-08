package LinkedList;

class MyLinkedList {
    private Node head;
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

    public void removeDuplicates() {
        if (head == null) {
            System.out.println("Linked List is Empty!");
            return;
        }

        Node itr = head;
        Node current = head;

        while (itr != null) {
            while (current.next != null) {
                if (current.next.value == itr.value) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            itr = itr.next;
            current = itr;
        }
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

public class RemoveWithoutExtraSpace {
    public static void main(String args[]) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addToEnd(7);
        linkedList.addToEnd(2);
        linkedList.addToEnd(7);
        linkedList.addToEnd(7);
        linkedList.removeDuplicates();
        linkedList.showListContents();
    }
}
