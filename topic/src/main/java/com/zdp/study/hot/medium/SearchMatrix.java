package com.zdp.study.hot.medium;

import java.util.List;

/**
 * @author zdp
 * @date 2024/9/21 23:54
 * @desc 74.搜索二位矩阵
 */
public class SearchMatrix {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int [][] nums = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        boolean result = searchMatrix(nums,3);

        return result == true;
    }

    public static boolean case2(){
        int [][] nums = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        boolean result = searchMatrix(nums,13);

        return result == false;
    }

//    public static boolean case3(){
//        int [] nums = new int[]{1,3,5,6};
//
//        int result = searchMatrix(nums,7);
//
//        return result == 4;
//    }
//
//    public static boolean case4(){
//        int [] nums = new int[]{1,3,5,6};
//
//        int result = searchInsert(nums,0);
//
//        return result == 0;
//    }
//
//    public static boolean case5(){
//        int [] nums = new int[]{1,3};
//
//        int result = searchInsert(nums,0);
//
//        return result == 0;
//    }
//
//    public static boolean case6(){
//        int [] nums = new int[]{3,5,7,9,10};
//
//        int result = searchInsert(nums,8);
//
//        return result == 3;
//    }

    public static boolean checkResult(String[] str1, List<String> str2) {
        for (int i = 0; i < str1.length;i++){
            if (!str2.contains(str1[i])){
                return false;
            }
        }

        return true;
    }

    private static boolean searchMatrix(int[][] matrix, int target){
        return searchMatrix(matrix,0,matrix.length*matrix[0].length-1,target);
    }

    private static boolean searchMatrix(int[][] matrix,int start,int end,int target){

        if (start == end){
            int row = start / matrix[0].length;
            int col = start % matrix[0].length;

            return matrix[row][col] == target;
        }

        int center = (end+start)/2;
        int row = center / matrix[0].length;
        int col = center % matrix[0].length;

        if (matrix[row][col] > target){
            return searchMatrix(matrix,start,Math.max(center-1,start),target);
        } else if (matrix[row][col] < target){
            return searchMatrix(matrix, Math.min(center+1,end),end,target);
        } else {
            return true;
        }
    }
}
