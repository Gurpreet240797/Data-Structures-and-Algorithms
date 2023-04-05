package Heap;

class MyMaxHeap {
    int[] arr;
    int size;
    int currentHeapSize;

    MyMaxHeap(int size) {
        arr = new int[size];
        this.size = size;
        currentHeapSize = 0;
    }

    public void insert(int value) {
        if (currentHeapSize == 0) {
            arr[currentHeapSize++] = value;
            return;
        }
        arr[currentHeapSize++] = value;
        decreaseKey(currentHeapSize-1);
    }

    private void decreaseKey(int index) {
        int parent = (index -1)/2;
        if (index > parent && arr[parent] < arr[index]) {
            swap(parent, index);
            decreaseKey(parent);
        }
    }

    private void swap(int i, int parent) {
        int temp = arr[parent];
        arr[parent] = arr[i];
        arr[i] = temp;
    }

    public int getMax() {
        return arr[0];
    }

    public void remove() {
        if (currentHeapSize == 0) return;

        currentHeapSize -= 1;
        swap(0, currentHeapSize);
        arr[currentHeapSize] = 0;
        increaseKey(0);
    }

    private void increaseKey(int parent) {
        int largest = parent;
        int left = (2 * parent) + 1;
        int right = (2 * parent) + 2;

        if (left < currentHeapSize && arr[left] > arr[largest]) largest = left;
        if (right < currentHeapSize && arr[right] > arr[largest]) largest = right;

        if (largest != parent) {
            swap(largest, parent);
            increaseKey(largest);
        }
    }
}

public class MaxHeap {
    public static void main(String[] args) {
        MyMaxHeap heap = new MyMaxHeap(6);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        System.out.println(heap.getMax());
        heap.remove();
        System.out.println(heap.getMax());
    }
}
