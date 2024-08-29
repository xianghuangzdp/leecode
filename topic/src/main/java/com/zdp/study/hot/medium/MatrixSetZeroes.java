package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/8/29 22:33
 * @desc 题目：73.矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class MatrixSetZeroes {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[][] number = new int[][]{
                {1,1,1},{1,0,1},{1,1,1}
        };
        setZeroes(number);

        int[][] target = new int[][]{
                {1,0,1},{0,0,0},{1,0,1}
        };

        return checkResult(number,target);
    }

    public static boolean case2(){
        int[][] number = new int[][]{
                {0,1,2,0},{3,4,5,2},{1,3,1,5}
        };
        setZeroes(number);

        int[][] target = new int[][]{
                {0,0,0,0},{0,4,5,0},{0,3,1,0}
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

    public static void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        boolean [] rowZero = new boolean[rowLength];
        boolean [] columnZero = new boolean[columnLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength;j++){
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    columnZero[j] = true;
                }
            }
        }

        for (int i = 0; i < rowLength || i < columnLength; i++) {
            if (i < rowLength && rowZero[i]){
                for (int j = 0; j < columnLength; j++){
                    matrix[i][j] = 0;
                }
            }

            if (i < columnLength && columnZero[i]){
                for (int j = 0; j < rowLength; j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
