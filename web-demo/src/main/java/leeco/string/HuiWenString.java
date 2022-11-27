package leeco.string;


/**
 * 最长回文子串
 *
 * @author: liuxuan
 * @date: 2022-10-29 20:43
 **/
public class HuiWenString {
    public static void main(String[] args) {
        String s = "aacabdkacaa";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(s));
        System.out.println(solution.longestPalindrome1(s));
    }

    static class Solution {
        public String longestPalindrome(String s) {
            if (null == s || s.length() < 2) {
                return s;
            }
            int max = 0;
            String res = null;
            for (int i = 0; i < s.length() - 1; i ++) {
                int l = i, r = i;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l --;
                    r ++;
                }
                if (r - l + 1 > max) {
                    max = r - l + 1;
                    res = s.substring(l + 1, r);
                }
                l = i;
                r = i + 1;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l --;
                    r ++;
                }
                if (r - l + 1 > max) {
                    max = r - l + 1;
                    res = s.substring(l + 1, r);
                }
            }
            return res;
        }

        public String longestPalindrome1(String s) {
            if (null == s || s.length() < 2) {
                return s;
            }
            String res = null;
            int max = 0;
            int length = s.length();
            int[][] arr = new int[length][length];
            String rev = new StringBuffer(s).reverse().toString(); //字符串翻转
            for (int i = 0; i < length; i ++) {
                for (int j = 0; j < length; j ++) {
                    //如果不想等可以不赋值为0，表示以这个字符为公共最后字符没有公共字符，动态规划也用不上
                    if (s.charAt(i) == rev.charAt(j)) {
                        //为0的边界
                        if (i == 0 || j == 0) {
                            arr[i][j] = 1;
                        } else {
                            arr[i][j] = arr[i - 1][j - 1] + 1;
                        }
                    }
                    if (arr[i][j] > max) {
                        int beforeRev = length - 1 - j; //倒置前的坐标
                        if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                            max = arr[i][j];
                            res = s.substring(i - arr[i][j] + 1, i + 1);
                        }
                    }
                }
            }
            return res;
        }
    }
}
