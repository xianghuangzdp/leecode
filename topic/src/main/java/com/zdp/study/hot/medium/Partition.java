package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.ListNode;

import java.util.Objects;

/**
 * @author zdp
 * @date 2024/9/10 01:12
 * @desc 86.分割链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class Partition {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int [] num1 = new int[]{1,4,3,2,5,2};

        ListNode result = partition(buildNode(num1),3);

        int [] target = new int[]{1,2,2,4,3,5};
        return checkResult(result,target);
    }

    public static boolean case2(){
        int [] num1 = new int[]{2,1};

        ListNode result = partition(buildNode(num1),2);

        int [] target = new int[]{1,2};
        return checkResult(result,target);
    }

    public static boolean case3(){
        int [] num1 = new int[]{1};

        ListNode result = partition(buildNode(num1),2);

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

    public static ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }

        ListNode fakeNode = new ListNode(x-1,head);
        ListNode greaterNode = null;
        ListNode greaterHeadNode = null;
        ListNode lesserNode = null;
        ListNode lesserHeadNode = null;

        ListNode tempHeadNode = fakeNode;

        while (tempHeadNode != null){
            if (tempHeadNode.val < x){
                if (lesserNode == null){
                    lesserNode = tempHeadNode;
                    lesserHeadNode = tempHeadNode;
                } else {
                    lesserNode.next = tempHeadNode;
                    lesserNode = lesserNode.next;
                }
            } else {
                if (greaterNode == null){
                    greaterNode = tempHeadNode;
                    greaterHeadNode = tempHeadNode;
                } else {
                    greaterNode.next = tempHeadNode;
                    greaterNode = greaterNode.next;
                }
            }

            tempHeadNode = tempHeadNode.next;
        }

        lesserNode.next = greaterHeadNode;
        if (greaterNode != null){
            greaterNode.next = null;
        }

        return lesserHeadNode.next;
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
