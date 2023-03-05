package Recursion;

public class MagicIndex {
    public static void main (String args[]) {
        int[] arr = {-1, 0, 1, 3, 5};
        int l = 0;
        int r = arr.length-1;
        int res = wrapperMagicIndex(l, r, arr);
        System.out.println(res);
    }

    public static int wrapperMagicIndex(int l, int r, int[] arr) {
        if ( l>= r) return -1;
        int pivot = l + (r - l)/2;
        if (arr[pivot] == pivot) return pivot;
        else if (arr[pivot] < pivot) return wrapperMagicIndex(pivot+1, r, arr);
        else return wrapperMagicIndex(l, pivot-1, arr);
    }
}
