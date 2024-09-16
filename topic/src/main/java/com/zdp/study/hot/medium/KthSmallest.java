package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;

import java.util.List;

/**
 * @author zdp
 * @date 2024/9/16 02:24
 * @desc 230.二叉搜索树的第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 */
public class KthSmallest {

    int number = 0;
    int value = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();
        KthSmallest test = new KthSmallest();
        int result = test.kthSmallest(root,1);
        return result == 1;
    }

    public static boolean case2(){
        TreeNode root = buildNode2();

        KthSmallest test = new KthSmallest();
        int result = test.kthSmallest(root,3);
        return result == 3;
    }

//    public static boolean case3(){
//        TreeNode root = buildNode3();
//
//        MinimumDifference test = new MinimumDifference();
//        int result = test.getMinimumDifference(root);
//        return result == 47;
//    }

    public static boolean checkResult(List<List<Integer>> nums1, List<List<Integer>> exceptResult){
        for (int i = 0; i < nums1.size(); i ++){
            for (int j = 0; j < nums1.get(i).size();j++)
                if (nums1.get(i).get(j) != exceptResult.get(i).get(j)){
                    return false;
                }
        }

        return true;
    }

    public int kthSmallest(TreeNode root,int k) {
        visitNodeByInOrder(root,k);
        return value;
    }

    public  void visitNodeByInOrder(TreeNode node,int k) {
        if (node == null || number >= k){
            return;
        }

        visitNodeByInOrder(node.left,k);
        number++;
        if (number == k){
            value = node.val;
        }

        visitNodeByInOrder(node.right,k);
    }

    public static TreeNode buildNode1(){
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);

        node3.left = node1;
        node3.right = node4;

        node1.right = node2;

        return node3;
    }

    public static TreeNode buildNode2(){
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);

        node5.left = node3;
        node5.right = node6;

        node3.left = node2;
        node3.right = node4;

        node2.left = node1;

        return node5;
    }

    public static TreeNode buildNode3(){
        TreeNode node543 = new TreeNode(543);
        TreeNode node384 = new TreeNode(384);
        TreeNode node652 = new TreeNode(652);
        TreeNode node445 = new TreeNode(445);
        TreeNode node699 = new TreeNode(699);

        node543.left = node384;
        node543.right = node652;

        node384.right = node445;

        node652.right = node699;

        return node543;
    }
}
