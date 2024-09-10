package com.zdp.study.hot.simple;

import com.zdp.study.hot.util.TreeNode;

/**
 * @author zdp
 * @date 2024/9/11 01:16
 * @desc 104.二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class MaxDepth {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();

        int result = maxDepth(root);

        return result == 3;
    }

    public static boolean case2(){
        TreeNode root = buildNode2();

        int result = maxDepth(root);

        return result == 2;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right) + 1;
    }

    public static TreeNode buildNode1(){
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);

        root.left = left;
        root.right = right;

        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        return root;
    }

    public static TreeNode buildNode2(){
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        root.right = right;

        return root;
    }
}
