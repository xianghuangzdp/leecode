package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/8/29 23:33
 * @desc 题目：289.生命游戏
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 */
public class GameOfLife {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int[][] number = new int[][]{
                {0,1,0},{0,0,1},{1,1,1},{0,0,0}
        };
        gameOfLife(number);

        int[][] target = new int[][]{
                {0,0,0},{1,0,1},{0,1,1},{0,1,0}
        };

        return checkResult(number,target);
    }

    public static boolean case2(){
        int[][] number = new int[][]{
                {1,1},{1,0}
        };
        gameOfLife(number);

        int[][] target = new int[][]{
                {1,1},{1,1}
        };

        return checkResult(number,target);
    }

    public static boolean case3(){
        int[][] number = new int[][]{
                {0,1,0},{0,0,1},{1,1,1},{0,0,0}
        };
        gameOfLife(number);

        int[][] target = new int[][]{
                {0,0,0},{1,0,1},{0,1,1},{0,1,0}
        };

        return checkResult(number,target);
    }

    public static boolean checkResult(int[][] nums1,int [][] nums2){
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0;j < nums1[i].length;j++)
                if (nums1[i][j] != nums2[i][j]){
                    return false;
                }
        }

        return true;
    }

    public static void gameOfLife(int[][] board) {
        int rowLength = board.length;
        int columnLength = board[0].length;

        int [] needChangeList = new int[rowLength * columnLength];
        int needChangeCount = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength;j++){
                boolean checkNeedChange = checkNeedChange(board,i,j);

                if (checkNeedChange){
                    needChangeList[needChangeCount] = i * columnLength + j;
                    needChangeCount++;
                }
            }
        }

        for (int i = 0; i < needChangeCount;i++){
            int row = needChangeList[i] / columnLength;
            int column = needChangeList[i] % columnLength;

            board[row][column] = board[row][column] > 0?0:1;
        }
    }

    public static boolean checkNeedChange(int[][] board,int row,int column){
        int liveCount = 0;
        for (int i = Math.max(0,row-1); i < Math.min(row+2,board.length);i++){
            for (int j = Math.max(0,column-1); j < Math.min(column+2,board[i].length);j++){
                if (i != row || j != column){
                    if (board[i][j] > 0){
                        liveCount++;

                        if (board[row][column] == 0 && liveCount > 3){
                            break;
                        }
                    }
                }
            }
        }

        if (board[row][column] > 0){
            return liveCount < 2 || liveCount > 3;
        } else {
            return liveCount == 3;
        }
    }
}
