package com.example.demo.leetcode.a4;

/**
 * @author robert
 * @date 2021/12/19
 */
public class A4 {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length == 0 && nums2.length == 0) {
                return 0.0;
            }
            boolean flag = 0 == ((nums1.length + nums2.length) % 2);
            int n = (nums1.length + nums2.length) / 2;
            if (nums1.length == 0) {
                return flag ? nums2[n] : (nums2[n] + nums2[n + 1]) / 2.0;
            }
            if (nums2.length == 0) {
                return flag ? nums1[n] : (nums1[n] + nums1[n + 1]) / 2.0;
            }

            int num = 0;
            int index1 = 0, index2 = 0;
            while (num <= n) {
                if (index1 <= nums1.length && nums1[index1] < nums2[index2]) {
                    index1++;
                    num++;
                }
                if (index2 <= nums2.length && nums1[index1] >= nums2[index2]) {
                    index2++;
                    num++;
                }
                if (index1 == nums1.length && index2 <= nums2.length) {
                    index2 ++;
                    num ++;
                }
                if (index2 == nums2.length && index1 <= nums1.length) {
                    index1 ++;
                    num ++;
                }
            }
            return 0.0;
        }
    }
}
