package com.example.demo.leetcode.a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author robert
 * @date 2021/12/4
 */
public class A1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            Integer secondNum = numMap.get((target - nums[i]));
            if (Objects.nonNull(secondNum)) {
                return new int[]{secondNum, i};
            }
            numMap.put(nums[i], i);
        }
        throw new RuntimeException("未找到两数和为目标值");
    }

    public static void main(String[] args) {
        twoSum(new int[]{2, 7, 11, 15}, 9);
    }
}
