package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main (String args[]) {
        int[] nums = {3,2,4};
        int target = 6;

        int[] result = TwoSumWrapper(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] TwoSumWrapper(int nums[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i< nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }
}
