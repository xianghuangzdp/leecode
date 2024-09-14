package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/14 01:39
 * @desc 114.二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Flatten {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();

        flatten(root);

        return true;
    }

    public static boolean case2(){
        flatten(null);

        return true;
    }

    public static boolean case3(){
        TreeNode root = buildNode3();

        flatten(root);

        return true;
    }

    public static void flatten(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        visitNodeByPre(root,nodeList);

        for (int i = 0; i < nodeList.size()-1; i++){
            nodeList.get(i).right = nodeList.get(i+1);
            nodeList.get(i).left = null;
        }
    }

    public static void visitNodeByPre(TreeNode root, List<TreeNode> nodeList) {
        if (root == null){
            return;
        }

        nodeList.add(root);

        if (root.left != null){
            visitNodeByPre(root.left,nodeList);
        }

        if (root.right != null){
            visitNodeByPre(root.right,nodeList);
        }
    }

    public static TreeNode buildNode1(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node4;

        node5.right = node6;

        return node1;
    }

    public static TreeNode buildNode3(){
        TreeNode root = new TreeNode(0);
        return root;
    }
}
