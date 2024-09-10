package com.zdp.study.hot.simple;

import com.zdp.study.hot.util.TreeNode;

/**
 * @author zdp
 * @date 2024/9/11 01:42
 * @desc 101.对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class Symmetric {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        if (root.left == null && root.right == null){
            return true;
        }

        if (root.left == null || root.right == null){
            return false;
        }

        return isSymmetric(root.left,root.right);
    }

    public static boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }

        if (p == null || q == null){
            return false;
        }

        if (p.val != q.val){
            return false;
        }

        if (!isSymmetric(p.left,q.right) || !isSymmetric(p.right,q.left)){
            return false;
        }

        return true;
    }
}
