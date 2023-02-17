package BinarySearch;

public class FindMin {
    public static void main (String args[]) {
        int[] nums = {3,4,5,1,2};
        //[4,5,6,7,0,1,2]      [11,13,15,17]

        int result = FindMinWrapper(nums, 0, nums.length-1);
        System.out.println(result);
    }

    public static int FindMinWrapper(int nums[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left)/2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                return FindMinWrapper(nums, mid+1, right);
            } else {
                return FindMinWrapper(nums, left, mid-1);
            }
        } else {
            return nums[left];
        }
    }
}
