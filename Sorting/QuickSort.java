package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        // https://www.freecodecamp.org/news/quick-sort-algorithm-time-complexity-with-cpp-and-java-code/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, arr.length - 1);
        System.out.print(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr,partition + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int x = low-1;
        int pivot = arr[high];

        for (int y = low; y < high; y++) {
            if (arr[y] <= pivot) swap(arr, ++x, y);
        }

        swap(arr, x+1, high);
        return x+1;
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
