package com.zdp.study.hot.simple;

import com.zdp.study.hot.util.TreeNode;

/**
 * @author zdp
 * @date 2024/9/11 01:37
 * @desc 226.翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left  = root.left;
        TreeNode right  = root.right;

        invertTree(left);
        invertTree(right);

        root.left = right;
        root.right = left;

        return root;
    }
}
