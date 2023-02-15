package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ProductExceptSelf {
    public static void main (String args[]) {
        int[] nums = {1,2,3,4};

        int[] result = ProductExceptSelfWrapper(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] ProductExceptSelfWrapper(int nums[]) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];

        if (nums.length == 0) {
            return null;
        }

        int product = 1;
        left[0] = product;
        for (int i=1; i< nums.length; i++) {
            product = product * nums[i-1];
            left[i] = product;
        }

        product = 1;
        right[nums.length-1] = product;
        for (int i=nums.length - 2; i>=0; i--) {
            product = product * nums[i+1];
            right[i] = product;
        }

        for (int i=0; i<nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
