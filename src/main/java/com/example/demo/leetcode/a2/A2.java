package com.example.demo.leetcode.a2;

/**
 * @author robert
 * @date 2021/12/5
 */
public class A2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int t = 0;
        ListNode result = new ListNode();
        t += l1.val + l2.val;
        result.val = t % 10;
        t = t / 10;
        ListNode temp = result;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null & l2 != null) {
            t += l1.val + l2.val;
            ListNode next = new ListNode(t % 10);
            t = t / 10;
            temp.next = next;
            temp = next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            t += l1.val;
            ListNode next = new ListNode(t % 10, l1.next);
            t = t / 10;
            temp.next = next;
            temp = next;
            l1 = l1.next;
        }

        while (l2 != null) {
            t += l2.val;
            ListNode next = new ListNode(t % 10, l2.next);
            t = t / 10;
            temp.next = next;
            temp = next;
            l2 = l2.next;
        }

        if (t != 0) {
            temp.next = new ListNode(t);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
