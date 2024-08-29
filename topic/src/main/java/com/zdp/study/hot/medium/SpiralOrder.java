package com.zdp.study.hot.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zdp
 * @date 2024/8/29 00:34
 * @desc 题目：54.螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SpiralOrder {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        int[][] number = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        List<Integer> result = spiralOrder(number);
        Integer[] targetArray = new Integer[]{1,2,3,6,9,8,7,4,5};
        List<Integer> target = new ArrayList();
        Collections.addAll(target, targetArray);

        System.out.println("case 1 result = " + result);

        return checkResult(result,target);
    }

    public static boolean case2(){
        int[][] number = new int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        List<Integer> result = spiralOrder(number);
        Integer[] targetArray = new Integer[]{1,2,3,4,8,12,11,10,9,5,6,7};
        List<Integer> target = new ArrayList();
        Collections.addAll(target, targetArray);

        System.out.println("case 2 result = " + result);

        return checkResult(result,target);
    }

    public static boolean case3(){
        int[][] number = new int[][]{
                {6,9,7}
        };
        List<Integer> result = spiralOrder(number);
        Integer[] targetArray = new Integer[]{6,9,7};
        List<Integer> target = new ArrayList();
        Collections.addAll(target, targetArray);

        System.out.println("case 3 result = " + result);

        return checkResult(result,target);
    }

    public static boolean case4(){
        int[][] number = new int[][]{
                {2,5,8},
                {4,0,-1}
        };
        List<Integer> result = spiralOrder(number);
        Integer[] targetArray = new Integer[]{2,5,8,-1,0,4};
        List<Integer> target = new ArrayList();
        Collections.addAll(target, targetArray);

        System.out.println("case 4 result = " + result);

        return checkResult(result,target);
    }

    public static boolean checkResult(List<Integer> nums1,List<Integer> nums2){
        for (int i = 0; i < nums1.size(); i++){
            if (nums1.get(i) != nums2.get(i)){
                return false;
            }
        }

        return true;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        spiralOrder(matrix,0,0,matrix.length-1,matrix[0].length-1,result);
        return result;
    }

    public static void spiralOrder(int[][] matrix,int startRow,int startColumn,int endRow,int endColumn
            ,List<Integer> result) {

        for (int i = startColumn;i <= endColumn;i++){
            result.add(matrix[startRow][i]);
        }

        for (int i = startRow + 1;i <= endRow;i++){
            result.add(matrix[i][endColumn]);
        }

        for (int i = endColumn - 1;i >= startColumn && endRow > startRow;i--){
            result.add(matrix[endRow][i]);
        }

        for (int i = endRow - 1;i >= startRow +1 && startColumn < endColumn;i--){
            result.add(matrix[i][startColumn]);
        }

        if ((endColumn - startColumn > 1) && (endRow - startRow > 1)){
            spiralOrder(matrix,startRow + 1,startColumn + 1, endRow - 1,endColumn - 1,result);
        }
    }
}
