package LinkedList;

import java.util.NoSuchElementException;

class DoubleLinkedList {
    class Node {
        private int value;
        private Node next;
        private Node prev;

        Node () {this(0, null, null);}

        Node (int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public int size () {
        return size;
    }

    public int getItemAt(int index) {
        if (index > size - 1) {
            System.out.println("ERROR: No such Element Exception.");
            throw new NoSuchElementException();
        }

        Node itr = head;
        int i = 0;
        while (i != index) {
            i += 1;
            itr = itr.next;
        }

        return itr.value;
    }

    public void addAtEnd(int val) {
        if (head == null) {
            head = new Node();
            head.value = val;
            head.next = head.prev;
            head.prev = head.next;
            tail = head;
            size += 1;
            return;
        }

        Node temp = new Node();
        temp.value = val;
        tail.next = temp;
        temp.prev = tail;
        temp.next = head;
        head.prev = temp;
        tail = temp;
        size += 1;
    }

    public void addToStart(int val) {
        Node temp = new Node();
        temp.value = val;
        temp.next = head;
        head.prev = temp;
        tail.next = temp;
        temp.prev = tail;
        head = temp;
        size += 1;
    }

    public void insertAt(int index, int val) {
        if (index > size-1) {
            System.out.println("ERROR: No such Element Exception.");
            throw new NoSuchElementException();
        }

        if (index == size-1) {
            addAtEnd(val);
            return;
        }

        if (index == 0) {
            addToStart(val);
            return;
        }

        Node itr = head;
        int i = 0;
        while (i != index-1) {
            itr = itr.next;
            i += 1;
        }

        Node temp = new Node();
        temp.value = val;
        temp.next = itr.next;
        itr.next.prev = temp;
        temp.prev = itr;
        itr.next = temp;
    }

    public void showContents() {
        Node itr = head;

        while (itr != tail) {
             System.out.println(itr.value);
             itr = itr.next;
        }
        System.out.println(tail.value);
    }

}
public class DoubleList {
    public static void main (String args[]) {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.addAtEnd(2);
        doubleList.addAtEnd(3);
        doubleList.addAtEnd(5);
        doubleList.insertAt(0, 1);
        doubleList.insertAt(3, 4);
        doubleList.insertAt(1, 7);
        doubleList.showContents();
    }
}
