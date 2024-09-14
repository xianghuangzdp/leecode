package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;

/**
 * @author zdp
 * @date 2024/9/14 03:07
 * @desc 236.二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();

        TreeNode result = lowestCommonAncestor(root,new TreeNode(5),new TreeNode(1));

        return result.val == 3;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findNode(root,p,q)[0];
    }

    public static TreeNode[] findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return new TreeNode[]{null,null,null};
        }

        TreeNode pNode = null;
        TreeNode qNode = null;

        if (root.val == p.val){
            pNode = root;
        }

        if (root.val == q.val){
            qNode = root;
        }

        TreeNode[] findLeftResult = new TreeNode[]{null,null,null};
        TreeNode[] findRightResult = new TreeNode[]{null,null,null};

        if (root.left != null){
            findLeftResult = findNode(root.left,p,q);
        }

        if (root.right != null){
            findRightResult = findNode(root.right,p,q);
        }

        if (findLeftResult[0] != null){
            return findLeftResult;
        }

        if (findRightResult[0] != null){
            return findRightResult;
        }

        if (findLeftResult[1] != null){
            pNode = findLeftResult[1];
        }

        if (findRightResult[1] != null){
            pNode = findRightResult[1];
        }

        if (findLeftResult[2] != null){
            qNode = findLeftResult[2];
        }

        if (findRightResult[2] != null){
            qNode = findRightResult[2];
        }

        return new TreeNode[]{pNode!=null&&qNode!=null?root:null,pNode,qNode};
    }

    public static TreeNode buildNode1(){
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        node3.left = node5;
        node3.right = node1;

        node5.left = node6;
        node5.right = node2;

        node2.left = node7;
        node2.right = node4;

        node1.left = node0;
        node1.right = node8;

        return node3;
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
