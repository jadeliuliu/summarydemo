package leeco.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @author: liuxuan
 * @date: 2022-10-22 12:29
 **/
public class MaxNoRepeatString {
    public static void main(String[] args) {
        String s = "abcabc";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 用map表示字符对应的下一个位置
            Map<Character, Integer> map = new HashMap<>();
            int res = 0;
            String sub = null;
            for (int start = 0, end = 0; end < s.length(); end ++) {
                char c = s.charAt(end);
                if (map.containsKey(c)) {
                    start = Math.max(start, map.get(c));
                }
                // 如果存在key，会更新
                map.put(c, end + 1);
                //res = Math.max(res, end - start + 1);
                if (end - start + 1 > res) {
                    res = end - start + 1;
                    sub = s.substring(start, end + 1);
                }
            }
            System.out.println("sub字符串：" + sub);
            return res;
        }
    }
}
