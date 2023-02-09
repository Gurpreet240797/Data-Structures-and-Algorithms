package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ContainsDuplicate {
    public static void main (String args[]) {
        int[] nums = {2,2,4};

        boolean result = ContainsDuplicateWrapper(nums);
        System.out.println(result);
    }

    public static boolean ContainsDuplicateWrapper(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
