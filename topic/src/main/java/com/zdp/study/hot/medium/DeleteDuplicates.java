package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.ListNode;

import java.util.Objects;

/**
 * @author zdp
 * @date 2024/9/10 00:46
 * @desc 82.删除排序链表中的重复元素2
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int [] num1 = new int[]{1,2,3,3,4,4,5};

        ListNode result = deleteDuplicates(buildNode(num1));

        int [] target = new int[]{1,2,5};
        return checkResult(result,target);
    }

    public static boolean case2(){
        int [] num1 = new int[]{1,1,1,2,3};

        ListNode result = deleteDuplicates(buildNode(num1));

        int [] target = new int[]{2,3};
        return checkResult(result,target);
    }

    public static boolean case3(){
        int [] num1 = new int[]{1,1};

        ListNode result = deleteDuplicates(buildNode(num1));

        int [] target = new int[]{};
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

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode fakeNode = new ListNode(head.val - 1,head);
        ListNode tempHeadNode = fakeNode;

        ListNode lastDuplicateNode = fakeNode;
        boolean hasDuplicateNode = false;

        while (tempHeadNode != null){
            if (tempHeadNode.next != null && tempHeadNode.val == tempHeadNode.next.val){
                tempHeadNode.next = tempHeadNode.next.next;
                hasDuplicateNode = true;
            } else {
                if (hasDuplicateNode){
                    lastDuplicateNode.next = tempHeadNode.next;
                    hasDuplicateNode = false;
                } else {
                    lastDuplicateNode = tempHeadNode;
                }

                tempHeadNode = tempHeadNode.next;
            }
        }

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
