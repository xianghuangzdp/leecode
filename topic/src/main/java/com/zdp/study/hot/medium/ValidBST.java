package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;

import java.util.List;

/**
 * @author zdp
 * @date 2024/9/16 02:32
 * @desc 98.验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidBST {

    Integer pre = null;

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();

        ValidBST test = new ValidBST();
        boolean result = test.isValidBST(root);
        return result == true;
    }

    public static boolean case2(){
        TreeNode root = buildNode2();

        ValidBST test = new ValidBST();
        boolean result = test.isValidBST(root);
        return result == false;
    }

    public static boolean checkResult(List<List<Integer>> nums1, List<List<Integer>> exceptResult){
        for (int i = 0; i < nums1.size(); i ++){
            for (int j = 0; j < nums1.get(i).size();j++)
                if (nums1.get(i).get(j) != exceptResult.get(i).get(j)){
                    return false;
                }
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return visitNodeByInOrder(root);
    }

    public boolean visitNodeByInOrder(TreeNode node) {
        if (node == null){
            return true;
        }

        boolean leftValue = visitNodeByInOrder(node.left);
        if (!leftValue){
            return false;
        }

        if (pre != null){
            if (node.val <= pre){
                return false;
            }
        }

        pre = node.val;

        return visitNodeByInOrder(node.right);
    }

    public static TreeNode buildNode1(){
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        node2.left = node1;
        node2.right = node3;

        return node2;
    }

    public static TreeNode buildNode2(){
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);

        node5.left = node1;
        node5.right = node4;

        node4.left = node3;
        node4.right = node6;

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
