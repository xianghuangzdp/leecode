package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/8/29 22:08
 * @desc 题目：48.旋转图像
 *给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 *
 *
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *
 * 提示：
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 */
public class Rotate {
    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[][] number = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        rotate(number);

        int[][] target = new int[][]{
                {7,4,1},{8,5,2},{9,6,3}
        };

        return checkResult(number,target);
    }

    public static boolean case2(){
        int[][] number = new int[][]{
                {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
        };
        rotate(number);

        int[][] target = new int[][]{
                {15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}
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

    public static void rotate(int[][] matrix) {
        rotate(matrix,0,0,matrix.length-1,matrix[0].length-1);
    }

    public static void rotate(int[][] matrix,int startRow,int startColumn,int endRow,int endColumn) {

        for (int i = 0;i + startColumn < endColumn;i++){
            int num1 = matrix[startRow][i + startColumn];
            int num2 = matrix[i + startColumn][endColumn];
            int num3 = matrix[endRow][endColumn - i];
            int num4 = matrix[endRow-i][startColumn];

            matrix[startRow][i + startColumn] = num4;
            matrix[i + startColumn][endColumn] = num1;
            matrix[endRow][endColumn - i] = num2;
            matrix[endRow-i][startColumn] = num3;
        }

        if ((endColumn - startColumn > 1) && (endRow - startRow > 1)){
            rotate(matrix,startRow + 1,startColumn + 1, endRow - 1,endColumn - 1);
        }
    }
}
