package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.ListNode;

import java.util.Objects;

/**
 * @author zdp
 * @date 2024/9/10 01:02
 * @desc 61.旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class RotateRight {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int [] num1 = new int[]{1,2,3,4,5};

        ListNode result = rotateRight(buildNode(num1),2);

        int [] target = new int[]{4,5,1,2,3};
        return checkResult(result,target);
    }

    public static boolean case2(){
        int [] num1 = new int[]{0,1,2};

        ListNode result = rotateRight(buildNode(num1),4);

        int [] target = new int[]{2,0,1};
        return checkResult(result,target);
    }

    private static boolean checkResult(ListNode node,int[] target){
        for (int i = 0; i < target.length;i++){
            if (node == null || !Objects.equals(target[i],node.val)){
                return false;
            }

            node = node.next;
        }

        return node == null;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }

        ListNode tempHeadNode = head;
        ListNode temp1 = tempHeadNode;

        for (int i = 0; i < k; i++){
            tempHeadNode = tempHeadNode.next;
            if (tempHeadNode == null){
                k = k % (i+1);
                i = -1;
                tempHeadNode = head;
            }
        }

        while (tempHeadNode.next != null){
            temp1 = temp1.next;
            tempHeadNode = tempHeadNode.next;
        }

        tempHeadNode.next = head;
        ListNode result = temp1.next;
        temp1.next = null;

        return result;
    }

    public static ListNode buildNode(int[] nodes){
        if (nodes.length == 0){
            return new ListNode(0);
        }

        ListNode result = new ListNode(nodes[0]);
        ListNode temp = result;
        for (int i = 1; i < nodes.length;i++){
            temp.next = new ListNode(nodes[i]);
            temp = temp.next;
        }

        return result;
    }
}
