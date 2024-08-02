package leetcode;

import java.util.HashMap;

public class $169_MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                continue;
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
