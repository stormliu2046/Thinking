package com.example.demo.leetcode.a3;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @author robert
 * @date 2021/12/12
 */
@Slf4j
public class A3 {

    public static void main(String[] args) {
        log.info(lengthOfLongestSubstring("pwwkew") + "");
    }

    public static int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
