package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    static List<List<Integer>> dp = new ArrayList<>();
    public static void main (String args[]) {
        int[] nums = {1,2,3};
        List<Integer> list = new ArrayList<>();
        wrapperPowerSet(dp, 0, list, nums);

        for (int i=0; i<dp.size(); i++) {
            System.out.println(dp.get(i).toString());
        }
    }

    public static void wrapperPowerSet(List<List<Integer>> dp, int start, List<Integer> list, int[] nums) {
        if (start >= nums.length) dp.add(new ArrayList<>(list));
        else {
            list.add(nums[start]);
            wrapperPowerSet(dp, start+1, list, nums);

            list.remove(list.size()-1);
            wrapperPowerSet(dp, start+1, list, nums);
        }
    }
}
