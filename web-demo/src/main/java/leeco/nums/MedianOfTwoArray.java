package leeco.nums;

/**
 * 寻找两个正序数组的中位数
 *
 * @author: liuxuan
 * @date: 2022-10-23 10:10
 **/
public class MedianOfTwoArray {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2};
        int[] array2 = new int[]{3, 4};
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(array1, array2));
        System.out.println(s.findMedianSortedArrays2(array1, array2));
    }

    static class Solution {
        // 方法一：在两个数组间遍历，移动(m+n)/2+1步
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int index1 = 0, index2 = 0, left = 0, right = 0;
            int size = nums1.length + nums2.length;
            for (int i = 0; i <= size / 2; i++) {
                // left慢一步
                left = right;
                if (index1 < nums1.length && (index2 == nums2.length || nums1[index1] <= nums2[index2])) {
                    right = nums1[index1++];
                } else {
                    right = nums2[index2++];
                }
            }
            if (size % 2 == 0) {
                return (left + right) / 2.0;
            } else {
                return left;
            }
        }
        // 方法二：二分法
        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int left = (n + m + 1) / 2;
            int right = (n + m + 2) / 2;
            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
        }
        // 获取两正序数组的第k大的值
        private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            // 要进行比较的数组的长度
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            if (len1 + len2 < k) {throw new IllegalArgumentException("no result");}
            // 出递归条件
            if (len1 == 0) return nums2[start2 + k - 1];
            if (len2 == 0) return nums1[start1 + k - 1];
            if (k == 1) return Math.min(nums1[start1], nums2[start2]);
            // 要比较的两个数组的索引
            int i = start1 + Math.min(len1, k / 2) - 1;
            int j = start2 + Math.min(len2, k / 2) - 1;
            if (nums1[i] > nums2[j]) {
                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
            }
            else {
                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
            }
        }
    }
}
