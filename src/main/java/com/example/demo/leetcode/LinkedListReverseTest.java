package com.example.demo.leetcode;

import cn.hutool.json.JSONUtil;
import com.example.demo.leetcode.a2.ListNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 链表反转
 * 1->2->3->4->5
 * change
 * 5->4->3->2->1
 *
 * @author robert
 * @date 2021/12/11
 */
@Slf4j
public class LinkedListReverseTest {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        log.info(JSONUtil.toJsonStr(node1));

        log.info(JSONUtil.toJsonStr(recursion(node1)));
//        log.info(JSONUtil.toJsonStr(linkedListReverse(node1)));
    }

    public static ListNode linkedListReverse(ListNode listNode) {
        if (Objects.isNull(listNode)) {
            return null;
        }
        ListNode current = listNode;
        ListNode next = listNode.getNext();
        current.setNext(null);
        while (Objects.nonNull(next)) {
            ListNode temp = next;
            next = next.getNext();
            temp.setNext(current);
            current = temp;
        }
        return current;
    }

    public static ListNode recursion(ListNode listNode) {
        if (listNode == null || listNode.getNext() == null) {
            return listNode;
        }
        ListNode newNode = recursion(listNode.getNext());
        listNode.getNext().setNext(listNode);
        listNode.setNext(null);
        return newNode;
    }
}
