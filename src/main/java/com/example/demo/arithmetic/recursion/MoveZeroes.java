package com.example.demo.arithmetic.recursion;

import java.util.Arrays;

/**
 * @author robert
 */
public class MoveZeroes {

    /**移动零，将所有零移动到数组的末尾，保持非零元素相对顺序*/
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
