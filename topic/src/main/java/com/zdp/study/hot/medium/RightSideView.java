package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/14 03:35
 * @desc 199.二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class RightSideView {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();

        List<Integer> result = rightSideView(root);
        int [] target = new int[]{1,3,4};
        return checkResult(target,result.toArray(new Integer[result.size()]));
    }

    public static boolean checkResult(int [] nums1,Integer [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] != exceptResult[i]){
                return false;
            }
        }

        return true;
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        result.add(root.val);

        List<TreeNode> floorNodeList = new ArrayList<>();
        floorNodeList.add(root);
        visitFloorNode(floorNodeList,result);

        return result;
    }

    public static void visitFloorNode(List<TreeNode> floorNodeList, List<Integer> result) {
        if (floorNodeList.size() == 0){
            return;
        }

        List<TreeNode> nextFloorNodeList = new ArrayList<>();
        for (TreeNode node:floorNodeList){
            visitNode(node,nextFloorNodeList);
        }

        if (nextFloorNodeList.size() > 0){
            result.add(nextFloorNodeList.get(0).val);
        }

        visitFloorNode(nextFloorNodeList,result);
    }

    public static void visitNode(TreeNode node, List<TreeNode> nextFloorNodeList) {
        if (node == null){
            return;
        }

        if (node.right != null){
            nextFloorNodeList.add(node.right);
        }

        if (node.left != null){
            nextFloorNodeList.add(node.left);
        }
    }

    public static TreeNode buildNode1(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.right = node5;

        node3.right = node4;

        return node1;
    }
}
