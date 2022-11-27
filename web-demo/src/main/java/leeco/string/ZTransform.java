package leeco.string;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: liuxuan
 * @date: 2022-11-12 12:08
 **/
public class ZTransform {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        Solution so = new Solution();
        String res = so.convert(s, 3);
        System.out.println(res);
    }

    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows < 2) return s;
            List<StringBuilder> rows = Lists.newArrayList();
            //List<StringBuilder> rows = new ArrayList<StringBuilder>();
            //需要写入numRows个StringBuilder到List
            for (int i = 0; i < numRows; i++) {
                StringBuilder sb = new StringBuilder();
                rows.add(sb);
            }
            int index = 0;
            int step = -1;
            for (char c : s.toCharArray()) {
                rows.get(index).append(c);
                //遇到拐点，方向就反
                if (index == 0 || index == numRows - 1) {
                    step = -step;
                }
                index += step;
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                res.append(rows.get(i));
            }
            return res.toString();
        }
    }
}
