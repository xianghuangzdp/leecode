package com.zdp.study.hot.util;

/**
 * @author zdp
 * @date 2024/9/9 23:39
 * @desc
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode front;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {}
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
