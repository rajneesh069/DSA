package recursion.permutations;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutations {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] map = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(nums, map, ans, new ArrayList<Integer>());
        return ans;
    }

    private static void findPermutations(int[] nums, boolean[] map, List<List<Integer>> ans, List<Integer> ds) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (map[i]==true) {
               continue;
            }
            map[i] = true;
            ds.add(nums[i]);
            findPermutations(nums, map, ans, ds);
            ds.removeLast();
            map[i] = false;
        }
    }
}
