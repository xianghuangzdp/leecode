package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/14 02:47
 * @desc 173.二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 *
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 */
public class BSTIterator {

    private List<TreeNode> nodeList;
    private int index = -1;

    public BSTIterator(TreeNode root) {
        nodeList = new ArrayList<>();
        visitNodeByInOrder(root);
    }

    public int next() {
        index++;
        return nodeList.get(index).val;
    }

    public boolean hasNext() {
        return index < nodeList.size()-1;
    }

    private void visitNodeByInOrder(TreeNode root){
        if (root == null){
            return;
        }

        if (root.left != null){
            visitNodeByInOrder(root.left);
        }

        nodeList.add(root);

        if (root.right != null){
            visitNodeByInOrder(root.right);
        }
    }
}