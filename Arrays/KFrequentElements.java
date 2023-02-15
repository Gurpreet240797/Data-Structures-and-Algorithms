package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KFrequentElements {
    public static void main (String args[]) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        int[] result = KFrequentElementsWrapper(nums, k);
        System.out.println(Arrays.toString(result));
    }

    public static int[] KFrequentElementsWrapper(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(i, 0) + 1);
        }

        List<Integer> bucket[] = new ArrayList[nums.length + 1];

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int res[] = new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(int val : bucket[i]){
                    res[index++] = val;
                    if(index == k) return res;
                }
            }
        }
        return res;
    }
}
