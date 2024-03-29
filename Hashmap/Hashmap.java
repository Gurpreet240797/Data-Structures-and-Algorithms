package Hashmap;

// Using Separate Chaining Technique for avoiding hash collision
// methods - add, remove, get, size, isEmpty
// helper- getBucketIndex, hashcode

import java.util.HashMap;
import java.util.Objects;

class MyHashMap<k, v> {
    class Node<k, v> {
        k key;
        v value;
        final int hashcode;
        Node next;

        Node(k key, v value, int hashcode) {
            this.key = key;
            this.value = value;
            this.hashcode = hashcode;
        }
    }

    private Node<k, v>[] bucketArr;
    private int numBuckets;
    private int size;

    MyHashMap() {
        numBuckets = 10;
        size = 0;
        bucketArr = new Node[numBuckets];
        for (int i=0; i<numBuckets; i++) {
            bucketArr[i] = null;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int hashCode(k key) {
        return Objects.hashCode(key);
    }

    public int getBucketIndex(k key) {
        int hashcode = hashCode(key);
        int index = hashcode % numBuckets;
        index = index < 0 ? index * -1 : index;
        return index;
    }

    public v remove(k key) {
        // For the key find the bucket and hashcode for the key
        // Then have two pointers for traveling.
        // Stop the while loop until you find the value and hashcode
        // check for base cases for head null or prev null

        int bucket = getBucketIndex(key);
        int hashcode = hashCode(key);

        Node<k, v> head = bucketArr[bucket];
        Node<k, v> prev = null;

        if (head == null) {
            return null;
        }

        while(head != null) {
            if (head.key.equals(key) && hashcode == head.hashcode) {
                break;
            }
            prev = head;
            head = head.next;
        }

        v response = null;
        response = head.value;
        if (prev != null) {
            prev.next = head.next;
        } else {
            bucketArr[bucket] = head.next;
        }
        size -= 1;
        return response;
    }

    public v get(k key) {
        int bucket = getBucketIndex(key);
        int hashcode = hashCode(key);

        Node<k, v> head = bucketArr[bucket];

        while (head != null) {
            if (head.key.equals(key) && hashcode == hashCode(key) ) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void add(k key, v value) {
        // Find the bucket and hashcode for the key to add
        // make a head node that points to the bucket
        // if the key is present in the bucket list replace the value
        // otherwise increase the size and make a new node
        // point head to bucket and new node next to head
        // check for load factor (1 * size) / numBucket
        // if more than 0.7 the make new bucket and put the values

        int bucket = getBucketIndex(key);
        int hashcode = hashCode(key);
        Node<k, v> head = bucketArr[bucket];

        while (head != null) {
            if (head.key.equals(key) && hashcode == head.hashcode) {
                head.value = value;
            }
            head = head.next;
        }

        size += 1;
        Node<k, v> newNode = new Node<k, v>(key, value, hashcode);
        head = bucketArr[bucket];
        newNode.next = head;
        bucketArr[bucket] = newNode;

        if ((1 * size) / numBuckets >= 0.7) {
            Node<k, v>[] temp = new Node[numBuckets*2];
            size = 0;
            for (int i=0; i<numBuckets; i++) {
                bucketArr[i] = null;
            }

            for (Node<k,v> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}

public class Hashmap {
    public static void main(String args[]) {
        //https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
    }
}
