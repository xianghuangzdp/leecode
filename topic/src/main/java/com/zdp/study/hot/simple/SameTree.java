package com.zdp.study.hot.simple;

import com.zdp.study.hot.util.TreeNode;

/**
 * @author zdp
 * @date 2024/9/11 01:30
 * @desc 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class SameTree {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        TreeNode p = buildNode11();
        TreeNode q = buildNode12();

        boolean result = isSameTree(p,q);

        return result == true;
    }

    public static boolean case2(){
        TreeNode p = buildNode21();
        TreeNode q = buildNode22();

        boolean result = isSameTree(p,q);

        return result == false;
    }

    public static boolean case3(){
        TreeNode p = buildNode31();
        TreeNode q = buildNode32();

        boolean result = isSameTree(p,q);

        return result == false;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }

        if (p == null || q == null){
            return false;
        }

        if (p.val != q.val){
            return false;
        }

        if (!isSameTree(p.left,q.left) || !isSameTree(p.right,q.right)){
            return false;
        }

        return true;
    }

    public static TreeNode buildNode11(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        return root;
    }

    public static TreeNode buildNode12(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        return root;
    }

    public static TreeNode buildNode21(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);

        root.left = left;

        return root;
    }

    public static TreeNode buildNode22(){
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        root.right = right;

        return root;
    }

    public static TreeNode buildNode31(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(1);

        root.left = left;
        root.right = right;

        return root;
    }

    public static TreeNode buildNode32(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        root.left = left;
        root.right = right;

        return root;
    }
}
