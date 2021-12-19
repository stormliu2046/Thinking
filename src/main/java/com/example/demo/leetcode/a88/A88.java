package com.example.demo.leetcode.a88;

import java.util.Arrays;

/**
 * @author robert
 * @date 2021/12/19
 */
public class A88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0, index1 = 0, index2 = 0;
        int[] result = new int[m + n];
        while (index1 < m && index2 < n) {
            if (nums1[index1] >= nums2[index2]) {
                result[index] = nums2[index2];
                index2++;
            } else {
                result[index] = nums1[index1];
                index1++;
            }
            index++;
        }
        while (index1 < m) {
            result[index] = nums1[index1];
            index1++;
            index++;
        }
        while (index2 < n) {
            result[index] = nums2[index2];
            index2++;
            index++;
        }
        System.arraycopy(result, 0, nums1, 0 , m + n);
    }
}
