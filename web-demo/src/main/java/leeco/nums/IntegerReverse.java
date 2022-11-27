package leeco.nums;

import java.util.Stack;

/**
 * @author: liuxuan
 * @date: 2022-11-12 22:38
 **/
public class IntegerReverse {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 31) - 1);
        int i = -33;
        System.out.println(~(i-1));  //和-i一样
        Solution s = new Solution();
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse2(-123));
        System.out.println(s.reverse2(-123));
    }

    static class Solution {
        public int reverse(int x) {
            try {
                boolean flag = false;
                if (x < 0) {
                    flag = true;
                    x = -x;
                }
                String old = String.valueOf(x);
                String newS = new StringBuilder(old).reverse().toString();
                int res = Integer.parseInt(newS);
                if (flag) res = -res;
                return res;
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        public int reverse2(int x) {
            try {
                boolean flag = false;
                if (x < 0) {
                    flag = true;
                    x = -x;
                }
                int res = 0;
                while (x > 0) {
                    res = res * 10 + x % 10;
                    x = x / 10;
                }
                if (flag) res = - res;
                return res;
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        public int reverse3(int x) {
            try {
                boolean flag = false;
                if (x < 0) {
                    flag = true;
                    x = -x;
                }
                String old = String.valueOf(x);
                Stack<Character> stack = new Stack<>();
                for (char c : old.toCharArray()) stack.push(c);
                StringBuilder sb = new StringBuilder();
                while (!stack.empty()) sb.append(stack.pop());
                int res = Integer.parseInt(sb.toString());
                if (flag) res = -res;
                return res;
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }
}
