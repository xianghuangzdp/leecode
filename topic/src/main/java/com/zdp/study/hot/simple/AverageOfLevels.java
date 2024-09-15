package com.zdp.study.hot.simple;

import com.zdp.study.hot.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/14 23:13
 * @desc 637.二叉树的层平均值
 */
public class AverageOfLevels {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();

        List<Double> result = averageOfLevels(root);
        double [] target = new double[]{3.00000D,14.50000D,11.00000D};
        return checkResult(target,result.toArray(new Double[result.size()]));
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        List<TreeNode> floorNodeList = new ArrayList<>();
        floorNodeList.add(root);
        visitFloorNode(floorNodeList,result);

        return result;
    }

    public static void visitFloorNode(List<TreeNode> floorNodeList, List<Double> result) {
        if (floorNodeList.size() == 0){
            return;
        }

        List<TreeNode> nextFloorNodeList = new ArrayList<>();
        double sum = 0D;
        int count = 0;
        for (TreeNode node:floorNodeList){
            sum += node.val;
            count++;
            visitNode(node,nextFloorNodeList);
        }

        result.add(sum/count);

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
}
