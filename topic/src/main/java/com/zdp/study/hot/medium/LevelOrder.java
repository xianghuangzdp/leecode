package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/14 23:21
 * @desc 102.二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();

        List<List<Integer>> result = levelOrder(root);
        List<List<Integer>> target = buildTarget();
        return checkResult(target,result);
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        List<TreeNode> floorNodeList = new ArrayList<>();
        floorNodeList.add(root);
        visitFloorNode(floorNodeList,result);

        return result;
    }

    public static void visitFloorNode(List<TreeNode> floorNodeList, List<List<Integer>> result) {
        if (floorNodeList.size() == 0){
            return;
        }

        List<TreeNode> nextFloorNodeList = new ArrayList<>();
        List<Integer> levelNodeValue = new ArrayList<>();
        for (TreeNode node:floorNodeList){
            levelNodeValue.add(node.val);
            visitNode(node,nextFloorNodeList);
        }

        result.add(levelNodeValue);

        visitFloorNode(nextFloorNodeList,result);
    }

    public static void visitNode(TreeNode node, List<TreeNode> nextFloorNodeList) {
        if (node == null){
            return;
        }

        if (node.left != null){
            nextFloorNodeList.add(node.left);
        }

        if (node.right != null){
            nextFloorNodeList.add(node.right);
        }
    }

    public static TreeNode buildNode1(){
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;

        node20.left = node15;
        node20.right = node7;

        return node3;
    }

    public static List<List<Integer>> buildTarget(){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(3);
        result.add(temp);

        temp = new ArrayList<>();
        temp.add(9);
        temp.add(20);
        result.add(temp);

        temp = new ArrayList<>();
        temp.add(15);
        temp.add(7);
        result.add(temp);

        return result;
    }
}
