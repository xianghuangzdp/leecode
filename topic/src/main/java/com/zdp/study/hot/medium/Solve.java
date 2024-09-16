package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.TreeNode;

/**
 * @author zdp
 * @date 2024/9/16 03:33
 * @desc 130.被包围的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
 *
 * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * 区域：连接所有 'O' 的单元格来形成一个区域。
 * 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
 * 通过将输入矩阵 board 中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。
 */
public class Solve {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        char [][] board = new char[][]{
                {'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}
        };

        char [][] target = new char[][]{
                {'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','O','X','X'}
        };

        solve(board);
        return checkResult(target,board);
    }

    public static boolean case2(){
        char [][] board = new char[][]{
                {'X'}
        };

        char [][] target = new char[][]{
                {'X'}
        };

        solve(board);
        return checkResult(target,board);
    }

//    public static boolean case3(){
//        TreeNode root = buildNode3();
//
//        MinimumDifference test = new MinimumDifference();
//        int result = test.getMinimumDifference(root);
//        return result == 47;
//    }

    public static boolean checkResult(char [][] nums1, char [][] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            for (int j = 0; j < nums1[i].length;j++)
                if (nums1[i][j] != exceptResult[i][j]){
                    return false;
                }
        }

        return true;
    }

    public static void solve(char[][] board) {
        int height = board.length;
        int width = board[0].length;

        for (int i = 0; i < height;i++){
            for (int j = 0;j< width;j++){
                char mark = board[i][j];
                if (mark != 'O') {
                    continue;
                }

                if (i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1) {
                    markGridBound(board,i,j);
                }
            }
        }

        for (int i = 0; i < height;i++){
            for (int j = 0;j< width;j++){
                char mark = board[i][j];
                if (mark == 'O') {
                    board[i][j] = 'X';
                } else if (mark == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void markGridBound(char[][] board,int row,int column){
        if (row < 0 || column < 0 || row >= board.length || column >= board[0].length) {
            return;
        }

        if (board[row][column] != 'O') {
            return;
        }

        board[row][column] = 'T';

        markGridBound(board,row-1,column);
        markGridBound(board,row+1,column);
        markGridBound(board,row,column-1);
        markGridBound(board,row,column+1);
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
