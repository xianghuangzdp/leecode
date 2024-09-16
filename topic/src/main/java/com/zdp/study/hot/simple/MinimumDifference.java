package com.zdp.study.hot.simple;

import com.zdp.study.hot.util.TreeNode;

import java.util.List;

/**
 * @author zdp
 * @date 2024/9/16 01:47
 * @desc 530.二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class MinimumDifference {

    int pre = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();
        MinimumDifference test = new MinimumDifference();
        int result = test.getMinimumDifference(root);
        return result == 1;
    }

    public static boolean case2(){
        TreeNode root = buildNode2();

        MinimumDifference test = new MinimumDifference();
        int result = test.getMinimumDifference(root);
        return result == 1;
    }

    public static boolean case3(){
        TreeNode root = buildNode3();

        MinimumDifference test = new MinimumDifference();
        int result = test.getMinimumDifference(root);
        return result == 47;
    }

    public static boolean checkResult(List<List<Integer>> nums1,List<List<Integer>> exceptResult){
        for (int i = 0; i < nums1.size(); i ++){
            for (int j = 0; j < nums1.get(i).size();j++)
                if (nums1.get(i).get(j) != exceptResult.get(i).get(j)){
                    return false;
                }
        }

        return true;
    }

    public int getMinimumDifference(TreeNode root) {
        visitNodeByInOrder(root);
        return min;
    }

    public  void visitNodeByInOrder(TreeNode node) {
        if (node == null){
            return;
        }

        visitNodeByInOrder(node.left);

        if (pre < Integer.MAX_VALUE){
            min = Math.min(node.val - pre,min);
        }

        pre = node.val;

        visitNodeByInOrder(node.right);
    }

    public static TreeNode buildNode1(){
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        node4.left = node2;
        node4.right = node6;

        node2.left = node1;
        node2.right = node3;

        return node4;
    }

    public static TreeNode buildNode2(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        TreeNode node48 = new TreeNode(48);
        TreeNode node12 = new TreeNode(12);
        TreeNode node49 = new TreeNode(49);

        node1.left = node0;
        node1.right = node48;

        node48.left = node12;
        node48.right = node49;

        return node1;
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
