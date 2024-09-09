package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.ListNode;

import java.util.Objects;

/**
 * @author zdp
 * @date 2024/9/10 00:14
 * @desc 92.反转链表2
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class ReverseBetween {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int [] num1 = new int[]{1,2,3,4,5};

        ListNode result = reverseBetween(buildNode(num1),2,4);

        int [] target = new int[]{1,4,3,2,5};
        return checkResult(result,target);
    }

    public static boolean case2(){
        int [] num1 = new int[]{5};

        ListNode result = reverseBetween(buildNode(num1),1,1);

        int [] target = new int[]{5};
        return checkResult(result,target);
    }

    public static boolean case3(){
        int [] num1 = new int[]{3,5};

        ListNode result = reverseBetween(buildNode(num1),1,2);

        int [] target = new int[]{5,3};
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fakeNode = new ListNode(0,head);
        left++;
        right++;
        ListNode tempHeadNode = fakeNode;

        for (int i = 0; i < left - 2; i++){
            tempHeadNode = tempHeadNode.next;
        }

        ListNode tempReverseHeadNode = tempHeadNode.next;
        ListNode temp = new ListNode();
        ListNode firstReverseNode = temp;

        for (int i = left; i <= right && tempReverseHeadNode != null; i++){
            ListNode currentNode = new ListNode(tempReverseHeadNode.val);
            if (temp.next != null){
                currentNode.next = temp.next;
            } else {
                firstReverseNode = currentNode;
            }

            temp.next = currentNode;
            tempReverseHeadNode = tempReverseHeadNode.next;
        }

        tempHeadNode.next = temp.next;
        firstReverseNode.next = tempReverseHeadNode;

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
