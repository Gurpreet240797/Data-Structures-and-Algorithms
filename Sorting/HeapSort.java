package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int arrLength = arr.length;

        for (int i=arrLength/2 - 1; i>=0; i--) heapify(arr, arrLength, i);
        for (int i=arrLength - 1; i>0; i--) {
            swap(arr, 0, i);
            heapify(arr, arrLength, i);
        }
    }

    public static void heapify(int[] arr, int arrLength, int index) {
        int smallest = index;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        if (left < arrLength && arr[left] < arr[smallest]) smallest = left;
        if (right < arrLength && arr[right] < arr[smallest]) smallest = right;

        if (smallest != index) {
            swap(arr, smallest, index);
            heapify(arr, arrLength, smallest);
        }
    }

    public static void swap(int[] arr, int smallest, int index) {
        int temp = arr[smallest];
        arr[smallest] = arr[index];
        arr[index] = temp;
    }
}
