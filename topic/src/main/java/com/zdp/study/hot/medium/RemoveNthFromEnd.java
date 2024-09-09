package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.ListNode;

import java.util.Objects;

/**
 * @author zdp
 * @date 2024/9/10 00:32
 * @desc 19.删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int [] num1 = new int[]{1,2,3,4,5};

        ListNode result = removeNthFromEnd(buildNode(num1),2);

        int [] target = new int[]{1,2,3,5};
        return checkResult(result,target);
    }

    public static boolean case2(){
        int [] num1 = new int[]{5};

        ListNode result = removeNthFromEnd(buildNode(num1),1);

        int [] target = new int[]{};
        return checkResult(result,target);
    }

    public static boolean case3(){
        int [] num1 = new int[]{1,2};

        ListNode result = removeNthFromEnd(buildNode(num1),1);

        int [] target = new int[]{1};
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeNode = new ListNode(0,head);

        ListNode tempHeadNode = fakeNode;
        ListNode temp1 = tempHeadNode;

        for (int i = 0; i <= n && tempHeadNode != null; i++){
            tempHeadNode = tempHeadNode.next;
        }

        while (tempHeadNode != null){
            temp1 = temp1.next;
            tempHeadNode = tempHeadNode.next;
        }

        temp1.next = temp1.next.next;

        return fakeNode.next;
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
