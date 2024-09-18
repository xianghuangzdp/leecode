package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;
import com.zdp.study.hot.util.four.Node;

import java.util.List;

/**
 * @author zdp
 * @date 2024/9/19 01:54
 * @desc 427.建立四叉树
 * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 *
 * 你需要返回能表示矩阵 grid 的 四叉树 的根结点。
 *
 * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 *
 * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False。注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
 * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
 * class Node {
 *     public boolean val;
 *     public boolean isLeaf;
 *     public Node topLeft;
 *     public Node topRight;
 *     public Node bottomLeft;
 *     public Node bottomRight;
 * }
 * 我们可以按以下步骤为二维区域构建四叉树：
 *
 * 如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
 * 如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
 * 使用适当的子网格递归每个子节点。
 */
public class Construct {

    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){

        int [][] grid = new int[][]{
                {0,1},{1,0}
        };

        Node result = construct(grid);
        System.out.println(print(result));
        return true;
    }

    public static boolean case2(){
        int [][] grid = new int[][]{
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}
        };

        Node result =construct(grid);

        System.out.println(print(result));
        return true;
    }

    public static boolean case3(){
        int [][] grid = new int[][]{
                {1,1,0,0},
                {0,0,1,1},
                {1,1,0,0},
                {0,0,1,1}
        };

        Node result = construct(grid);

        System.out.println(print(result));
        return true;
    }

//    public static boolean case3(){
//        TreeNode root = buildNode3();
//
//        MinimumDifference test = new MinimumDifference();
//        int result = test.getMinimumDifference(root);
//        return result == 47;
//    }

    public static boolean checkResult(List<List<Integer>> nums1, List<List<Integer>> exceptResult){
        for (int i = 0; i < nums1.size(); i ++){
            for (int j = 0; j < nums1.get(i).size();j++)
                if (nums1.get(i).get(j) != exceptResult.get(i).get(j)){
                    return false;
                }
        }

        return true;
    }

    public static String print(Node result){
        StringBuilder builder = new StringBuilder();
        print(result,builder);

        return builder.toString();
    }

    public static void print(Node result,StringBuilder builder ){
        builder.append("[");
        builder.append(result.isLeaf?1:0);
        builder.append(result.val?1:0);
        builder.append("]");
        builder.append(",");

        if (result.topLeft != null){
            print(result.topLeft,builder);
        }

        if (result.topRight != null){
            print(result.topRight,builder);
        }

        if (result.bottomLeft != null){
            print(result.bottomLeft,builder);
        }

        if (result.bottomRight != null){
            print(result.bottomRight,builder);
        }
    }

    public static Node construct(int[][] grid) {
        return construct(grid,0,grid.length-1,0,grid.length-1);
    }

    public static Node construct(int[][] grid,int rowStart,int rowEnd,int colStart,int colEnd) {
        if (rowEnd == rowStart && colStart == colEnd){
            return new Node(grid[rowStart][colStart] == 1,true);
        }

        int rowCenter = (rowStart + rowEnd) /2;
        int colCenter = (colStart + colEnd) / 2;

        Node topLeft = construct(grid,rowStart,rowCenter,colStart,colCenter);
        Node topRight = construct(grid,rowStart,rowCenter,colCenter+1,colEnd);
        Node bottomLeft = construct(grid,rowCenter+1,rowEnd,colStart,colCenter);
        Node bottomRight = construct(grid,rowCenter+1,rowEnd,colCenter+1,colEnd);

        int sum = (topLeft.val?1:0) + (topRight.val?1:0) + (bottomLeft.val?1:0) + (bottomRight.val?1:0);
        boolean totalLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;

        boolean leaf = totalLeaf && (sum == 0 || sum == 4);
        boolean val = sum == 4;

        if (leaf){
            return new Node(val,true);
        } else {
            return new Node(val,leaf,topLeft,topRight,bottomLeft,bottomRight);
        }
    }

    public static TreeNode buildNode1(){
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);

        node3.left = node1;
        node3.right = node4;

        node1.right = node2;

        return node3;
    }

    public static TreeNode buildNode2(){
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);

        node5.left = node3;
        node5.right = node6;

        node3.left = node2;
        node3.right = node4;

        node2.left = node1;

        return node5;
    }

    public static TreeNode buildNode3(){
        TreeNode node543 = new TreeNode(543);
        TreeNode node384 = new TreeNode(384);
        TreeNode node652 = new TreeNode(652);
        TreeNode node445 = new TreeNode(445);
        TreeNode node699 = new TreeNode(699);

        node543.left = node384;
        node543.right = node652;

        node384.right = node445;

        node652.right = node699;

        return node543;
    }
}
