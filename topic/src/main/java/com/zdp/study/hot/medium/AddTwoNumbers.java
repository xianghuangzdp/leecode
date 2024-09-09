package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.ListNode;

import java.util.Objects;

/**
 * @author zdp
 * @date 2024/9/9 23:17
 * @desc 2.两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int [] num1 = new int[]{2,4,3};
        int [] num2 = new int[]{5,6,4};

        ListNode result = addTwoNumbers(buildNode(num1),buildNode(num2));

        int [] target = new int[]{7,0,8};
        return checkResult(result,target);
    }

    public static boolean case2(){
        int [] num1 = new int[]{0};
        int [] num2 = new int[]{0};

        ListNode result = addTwoNumbers(buildNode(num1),buildNode(num2));

        int [] target = new int[]{0};
        return checkResult(result,target);
    }

    public static boolean case3(){
        int [] num1 = new int[]{9,9,9,9,9,9,9};
        int [] num2 = new int[]{9,9,9,9};

        ListNode result = addTwoNumbers(buildNode(num1),buildNode(num2));

        int [] target = new int[]{8,9,9,9,0,0,0,1};
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

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode tempNode = start;
        int value = 0;

        while (l1 != null || l2 != null){
            int temp = value;
            if (l1 != null){
                temp += l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }

            ListNode currentNode = new ListNode(temp%10);
            tempNode.next = currentNode;
            tempNode = currentNode;
            value = temp / 10;
        }

        if (value > 0){
            ListNode currentNode = new ListNode(value);
            tempNode.next = currentNode;
        }

        return start.next;
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
