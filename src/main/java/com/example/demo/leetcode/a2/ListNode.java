package com.example.demo.leetcode.a2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author robert
 * @date 2021/12/4
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

}
