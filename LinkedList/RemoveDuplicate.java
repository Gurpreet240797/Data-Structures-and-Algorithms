package LinkedList;
import java.util.HashMap;

class IntLinkedList {
    class Node {
        int value;
        Node next;

        Node() {
            this(0, null);
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node head;

    public void addLast(int val) {
        if (head == null) {
            head = new Node(val, null);
            return;
        }

        Node itr = head;
        while (itr.next != null) {
            itr = itr.next;
        }
        itr.next = new Node(val, null);
        return;
    }

    public void showContents() {
        if (head == null) {
            System.out.println("EMPTY LIST!");
            return;
        }

        Node itr = head;
        while (itr != null) {
            System.out.println(itr.value);
            itr = itr.next;
        }
    }
}

public class RemoveDuplicate {
    public static void main (String args[]) {
        IntLinkedList myList = new IntLinkedList();
        myList.addLast(7);
        myList.addLast(2);
        myList.addLast(7);
        myList.addLast(1);

        IntLinkedList.Node itr = myList.head;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(itr.value, 1);

        while (itr.next != null) {
            if (map.containsKey(itr.next.value)) {
                itr.next = itr.next.next;
            } else {
                map.put(itr.next.value, 1);
            }
            itr = itr.next;
        }

        myList.showContents();

    }
}
