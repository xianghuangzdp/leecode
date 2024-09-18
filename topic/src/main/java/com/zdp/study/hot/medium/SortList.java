package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.link.ListNode;

/**
 * @author zdp
 * @date 2024/9/18 01:28
 * @desc 148.链表排序
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortList {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        ListNode node = buildNodeByList(new int[]{4,2,1,3});

        ListNode result = sortList(node);
        int [] target = new int[]{1,2,3,4};
        return checkResult(target,result);
    }

    public static boolean case2(){
        ListNode node = buildNodeByList(new int[]{-1,5,3,4,0});

        ListNode result = sortList(node);
        int [] target = new int[]{-1,0,3,4,5};
        return checkResult(target,result);
    }

    public static boolean case3(){
        ListNode node = buildNodeByList(new int[]{-1,5,3,4,0});

        ListNode result = sortList(null);
        return result == null;
    }

    public static boolean case4(){
        ListNode node = buildNodeByList(new int[]{4,19,14,5,-3,1,8,5,11,15});

        ListNode result = sortList(node);
        int [] target = new int[]{-3,1,4,5,5,8,11,14,15,19};
        return checkResult(target,result);
    }

    public static boolean checkResult(int[] num1, ListNode node) {
        for (int i = 0; i < num1.length;i++){
            if (num1[i] != node.val){
                return false;
            }

            node = node.next;
        }

        return true;
    }

    private static ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode center = findCenterNode(head);
        ListNode next = center.next;
        center.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(next);

        return mergeNode(left,right);
    }

    private static ListNode findCenterNode(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null){
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            } else {
                break;
            }

            slow = slow.next;
        }

        return slow;
    }

    private static ListNode mergeNode(ListNode left,ListNode right){
        if (left == null){
            return right;
        }

        if (right == null){
            return left;
        }

        ListNode head = null;
        ListNode temp = null;

        while (left != null || right != null){
            if (left == null){
                if (temp == null){
                    head = right;
                } else {
                    temp.next = right;
                }
                temp = right;
                right = right.next;
                continue;
            }

            if (right == null){
                if (temp == null){
                    head = left;
                } else {
                    temp.next = left;
                }
                temp = left;
                left = left.next;
                continue;
            }

            if (left.val <= right.val){
                if (temp == null){
                    head = left;
                } else {
                    temp.next = left;
                }
                temp = left;
                left = left.next;
            } else {
                if (temp == null){
                    head = right;
                } else {
                    temp.next = right;
                }
                temp = right;
                right = right.next;
            }
        }

        return head;
    }

    private static ListNode buildNodeByList(int [] list){
        ListNode result = new ListNode(list[0]);
        ListNode temp = result;

        for (int i = 1; i < list.length;i++){
            ListNode node = new ListNode(list[i]);
            temp.next = node;
            temp = node;
        }

        return result;
    }
}
