package com.zdp.study.hot.simple;

import com.zdp.study.hot.util.TreeNode;

/**
 * @author zdp
 * @date 2024/9/14 02:17
 * @desc 112.路径之和
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class PathSum {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();

        boolean result = hasPathSum(root,22);

        return result == true;
    }

    public static boolean case2(){
        TreeNode root = buildNode2();

        boolean result = hasPathSum(root,5);

        return result == false;
    }

    public static boolean case3(){

        boolean result = hasPathSum(null,0);

        return result == false;
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return sumNode(root,targetSum,0);
    }

    public static boolean sumNode(TreeNode root, int targetSum,int currentCount) {
        if (root == null){
            return false;
        }

        currentCount = currentCount + root.val;

        if (root.left == null && root.right == null){
            return targetSum == currentCount;
        }

        if (root.left != null){
            boolean leftSum = sumNode(root.left,targetSum,currentCount);
            if (leftSum){
                return true;
            }
        }

        if (root.right != null){
            return sumNode(root.right,targetSum,currentCount);
        }

        return false;
    }

    public static TreeNode buildNode1(){
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);

        node5.left = node4;
        node5.right = node8;

        node4.left = node11;

        node11.left = node7;
        node11.right = node2;

        node8.left = node13;
        node8.right = node4_2;

        node4_2.right = node1;

        return node5;
    }

    public static TreeNode buildNode2(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        return node1;
    }
}
