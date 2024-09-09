package com.zdp.study.hot.simple;

import com.zdp.study.hot.util.ListNode;

import java.util.Objects;

/**
 * @author zdp
 * @date 2024/9/9 23:37
 * @desc 21. 合并两个有序数组
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int [] num1 = new int[]{1,2,4};
        int [] num2 = new int[]{1,3,4};

        ListNode result = mergeTwoLists(buildNode(num1),buildNode(num2));

        int [] target = new int[]{1,1,2,3,4,4};
        return checkResult(result,target);
    }

    public static boolean case2(){
        int [] num1 = new int[]{};
        int [] num2 = new int[]{};

        ListNode result = mergeTwoLists(buildNode(num1),buildNode(num2));

        int [] target = new int[]{};
        return checkResult(result,target);
    }

    public static boolean case3(){
        int [] num1 = new int[]{};
        int [] num2 = new int[]{0};

        ListNode result = mergeTwoLists(buildNode(num1),buildNode(num2));

        int [] target = new int[]{0};
        return checkResult(result,target);
    }

    private static boolean checkResult(ListNode node, int[] target){
        for (int i = 0; i < target.length;i++){
            if (node == null || !Objects.equals(target[i],node.val)){
                return false;
            }

            node = node.next;
        }

        return node == null;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }

        if (list2 == null){
            return list1;
        }

        ListNode currentNode = new ListNode(0);
        ListNode result = currentNode;

        while (list1 != null && list2 != null){

            if (list1.val <= list2.val){
                currentNode.next = list1;
                currentNode = currentNode.next;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                currentNode = currentNode.next;
                list2 = list2.next;
            }
        }

        if (list1 != null){
            currentNode.next = list1;
        } else if (list2 != null){
            currentNode.next = list2;
        }

        return result.next;
    }

    public static ListNode buildNode(int[] nodes){
        if (nodes.length == 0){
            return null;
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
