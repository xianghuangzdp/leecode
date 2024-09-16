package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;

import java.util.List;

/**
 * @author zdp
 * @date 2024/9/16 02:41
 * @desc 200.岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class NumIslands {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        char [][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };

        int result = numIslands(grid);
        return result == 1;
    }

    public static boolean case2(){
        char [][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };

        int result = numIslands(grid);
        return result == 3;
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

    public static int numIslands(char[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        int result = 0;

        for (int i = 0; i < height;i++){
            for (int j = 0;j< width;j++){
                char mark = grid[i][j];
                if (mark != '1') {
                    continue;
                }

                result++;
                marGrid(grid,i,j,(char) ('1' + result));
            }
        }

        return result;
    }

    public static void marGrid(char[][] grid,int row,int column,char value){
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) {
            return;
        }

        if (grid[row][column] == '0' || grid[row][column] == value) {
            return;
        }

        grid[row][column] = value;
        marGrid(grid,row-1,column,value);
        marGrid(grid,row+1,column,value);
        marGrid(grid,row,column-1,value);
        marGrid(grid,row,column+1,value);
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
