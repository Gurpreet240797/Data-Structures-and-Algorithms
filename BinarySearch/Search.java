package BinarySearch;

public class Search {
    public static void main (String args[]) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        int start = searchWrapper(nums, 0, nums.length-1, target);

        int left = 0;
        int right = nums.length-1;
        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        int result = searchHelper(nums, left, right, target);
        System.out.println(result);
    }

    public static int searchHelper(int nums[], int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left)/2;

            if (target == nums[mid]) {
                return mid;
            }

            if (nums[mid] > target) {
                return searchHelper(nums, left, mid-1, target);
            } else {
                return searchHelper(nums, mid+1, right, target);
            }
        }
        return -1;
    }
    public static int searchWrapper(int nums[], int left, int right, int target) {
        if (left < right) {
            int pivot = left + (right - left)/2;

            if (nums[pivot] == target) {
                return pivot;
            }

            if (nums[pivot] > nums[right]) {
                return searchWrapper(nums,pivot+1, right, target);
            } else {
                return searchWrapper(nums, left, pivot, target);
            }
        }
        return left;
    }
}
