package Heap;

class Heap {
    private int[] heapArr;
    private int capacity;
    private int currentHeapSize;

    Heap() {this(0);}
    Heap(int capacity) {
        this.capacity = capacity;
        heapArr = new int[capacity];
        currentHeapSize = 0;
    }

    public int getMin() {
        return heapArr.length > 0 ? heapArr[0] : -1;
    }

    public void decreaseKey(int i) {
        int parent = (i - 1)/2;
        while (i != 0 && heapArr[i] < heapArr[parent]) {
            int temp = heapArr[parent];
            heapArr[parent] = heapArr[i];
            heapArr[i] = temp;
            i = parent;
            parent = (i - 1)/2;
        }
    }

    public void insertKey(int value) {
        if (heapArr.length == currentHeapSize) {
            int[] newArr = new int[currentHeapSize*2];
            for(int i=0; i<currentHeapSize; i++) {
                newArr[i] = heapArr[i];
            }
            heapArr = newArr;
        }

        heapArr[currentHeapSize] = value;
        decreaseKey(currentHeapSize);
        currentHeapSize += 1;
    }
}

public class MinHeap {
    public static void main(String args[]) {
        Heap minHeap = new Heap(7);
        minHeap.insertKey(2);
        minHeap.insertKey(4);
        minHeap.insertKey(5);
        minHeap.insertKey(6);
        minHeap.insertKey(7);
        minHeap.insertKey(1);
        minHeap.insertKey(8);
        minHeap.insertKey(3);
    }
}
