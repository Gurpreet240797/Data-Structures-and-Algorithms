package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        int arrLength = arr.length;
        if (arrLength < 2) return;

        int mid = arrLength/2;
        int[] left = new int[mid];
        int[] right = new int[arrLength - mid];

        for (int i = 0; i < mid; i++) left[i] = arr[i];

        for (int i = mid; i < arrLength; i++) right[i - mid] = arr[i];

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;

        int x = 0;
        int y = 0;
        int z = 0;


        while (x < leftLength && y < rightLength) {
            if (left[x] <= right[y]) arr[z++] = left[x++];
            else arr[z++] = right[y++];
        }

        while (x < leftLength) arr[z++] = left[x++];
        while (y < rightLength) arr[z++] = right[y++];
    }
}
