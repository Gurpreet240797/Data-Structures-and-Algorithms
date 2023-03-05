package Recursion;

public class TargetSum {
    static int count = 0;
    public static void main(String args[]) {
        int target = 50;
        int[] nums = {10, 20, 30, 40};
        wrapperTargetSum(nums, target);
        System.out.println(count);
    }

    public static void wrapperTargetSum(int[] nums, int target) {
        helper(nums, 0, "", 0, target);
    }

    public static void helper(int[] nums, int index, String set, int sum, int target) {
        if(index == nums.length) {
            if (sum == target) {
                count += 1;
                System.out.println(set);
            }
            return;
        }

        helper(nums, index+1, set + nums[index] + " ", sum+nums[index], target);
        helper(nums, index+1, set, sum, target);
    }
}
