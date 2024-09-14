package com.zdp.study.hot.util;

/**
 * @author zdp
 * @date 2024/9/9 23:59
 * @desc
 */
public class Node {
    public int val;
    public Node next;
    public Node left;
    public Node right;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
