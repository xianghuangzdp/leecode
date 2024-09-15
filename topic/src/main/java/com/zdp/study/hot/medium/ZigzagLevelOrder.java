package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/14 23:29
 * @desc 103.二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        TreeNode root = buildNode1();

        List<List<Integer>> result = zigzagLevelOrder(root);
        List<List<Integer>> target = buildTarget();
        return checkResult(target,result);
    }

    public static boolean case2(){
        TreeNode root = buildNode2();

        List<List<Integer>> result = zigzagLevelOrder(root);
        List<List<Integer>> target = buildTarget2();
        return checkResult(target,result);
    }

    public static boolean case3(){
        TreeNode root = buildNode3();

        List<List<Integer>> result = zigzagLevelOrder(root);
        List<List<Integer>> target = buildTarget3();
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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        List<TreeNode> floorNodeList = new ArrayList<>();
        floorNodeList.add(root);
        visitFloorNode(floorNodeList,result,false);

        return result;
    }

    public static void visitFloorNode(List<TreeNode> floorNodeList, List<List<Integer>> result,boolean leftDirect) {
        if (floorNodeList.size() == 0){
            return;
        }

        List<TreeNode> nextFloorNodeList = new ArrayList<>();
        List<Integer> levelNodeValue = new ArrayList<>();
        int length = floorNodeList.size();

        for (int i = 0; i < length; i++){
            levelNodeValue.add(floorNodeList.get(i).val);
            visitNode(floorNodeList.get(length - 1 - i),nextFloorNodeList,leftDirect);
        }

        result.add(levelNodeValue);

        visitFloorNode(nextFloorNodeList,result,!leftDirect);
    }

    public static void visitNode(TreeNode node, List<TreeNode> nextFloorNodeList,boolean direct) {
        if (node == null){
            return;
        }

        if (direct){
            if (node.left != null){
                nextFloorNodeList.add(node.left);
            }

            if (node.right != null){
                nextFloorNodeList.add(node.right);
            }
        } else {
            if (node.right != null){
                nextFloorNodeList.add(node.right);
            }

            if (node.left != null){
                nextFloorNodeList.add(node.left);
            }
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

    public static TreeNode buildNode2(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node3.right = node5;

        return node1;
    }

    public static TreeNode buildNode3(){
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node$1 = new TreeNode(-1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node_1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);

        node0.left = node2;
        node0.right = node4;

        node2.left = node1;

        node1.left = node5;
        node1.right = node_1;

        node4.left = node3;
        node4.right = node$1;

        node3.right = node6;
        node$1.right = node8;

        return node0;
    }

    public static List<List<Integer>> buildTarget(){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(3);
        result.add(temp);

        temp = new ArrayList<>();
        temp.add(20);
        temp.add(9);
        result.add(temp);

        temp = new ArrayList<>();
        temp.add(15);
        temp.add(7);
        result.add(temp);

        return result;
    }

    public static List<List<Integer>> buildTarget2(){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        result.add(temp);

        temp = new ArrayList<>();
        temp.add(3);
        temp.add(2);
        result.add(temp);

        temp = new ArrayList<>();
        temp.add(4);
        temp.add(5);
        result.add(temp);

        return result;
    }

    public static List<List<Integer>> buildTarget3(){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        result.add(temp);

        temp = new ArrayList<>();
        temp.add(4);
        temp.add(2);
        result.add(temp);

        temp = new ArrayList<>();
        temp.add(1);
        temp.add(3);
        temp.add(-1);
        result.add(temp);

        temp = new ArrayList<>();
        temp.add(8);
        temp.add(6);
        temp.add(1);
        temp.add(5);
        result.add(temp);

        return result;
    }
}
