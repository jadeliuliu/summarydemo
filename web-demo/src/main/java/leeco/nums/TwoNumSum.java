package leeco.nums;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 *
 * @author: liuxuan
 * @date: 2022-10-20 23:39
 **/
public class TwoNumSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, 9);
        System.out.println(Arrays.toString(res));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("no result");
        }
    }
}
