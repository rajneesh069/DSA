package leetcode;

import java.util.HashMap;

public class $1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> prev = new HashMap<>();
       for(int i=0; i < nums.length; i++){
        int n = nums[i];
        int diff = target - nums[i];
        if(prev.containsKey(diff)){
            return new int[]{prev.get(diff), i};
        }

        prev.put(n,i);
       }
        return new int[]{};  
    }
}
