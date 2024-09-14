package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;

/**
 * @author zdp
 * @date 2024/9/14 02:29
 * @desc 129.求根节点到叶子节点的数字之和
 *
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 */
public class SumNumbers {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();

        int result = sumNumbers(root);

        return result == 25;
    }

    public static boolean case2(){
        TreeNode root = buildNode2();

        int result = sumNumbers(root);

        return result == 1026;
    }

    public static int sumNumbers(TreeNode root) {
        TreeNode sum = new TreeNode(0);
        sumNode(root,sum,0);

        return sum.val;
    }

    public static void sumNode(TreeNode root,TreeNode sum,int pathNumber) {
        if (root == null){
            return;
        }

        pathNumber = pathNumber * 10 + root.val;

        if (root.left == null && root.right == null){
            sum.val = sum.val + pathNumber;
        }

        if (root.left != null){
            sumNode(root.left,sum,pathNumber);
        }

        if (root.right != null){
            sumNode(root.right,sum,pathNumber);
        }
    }

    public static TreeNode buildNode2(){
        TreeNode node4 = new TreeNode(4);
        TreeNode node9 = new TreeNode(9);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);

        node4.left = node9;
        node4.right = node0;

        node9.left = node5;
        node9.right = node1;

        return node4;
    }

    public static TreeNode buildNode1(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        return node1;
    }
}
