package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateTargetArrayInTheGivenOrder {
    public static void main(String[] args) {
        System.out
                .println(Arrays.toString(createTargetArray(new int[] { 0, 1, 2, 3, 4 }, new int[] { 0, 1, 2, 2, 1 })));
    }

    static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        // ans[index[i]] = nums[i];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int ind = index[i];
            // ans[ind] = val;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < ind; j++) {
                temp.add(ans.get(j));
            }
            temp.add(val);
            for (int j = ind; j < ans.size(); j++) {
                temp.add(ans.get(j));
            }
            ans = temp;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
