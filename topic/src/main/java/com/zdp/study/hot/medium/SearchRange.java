package com.zdp.study.hot.medium;

import java.util.List;

/**
 * @author zdp
 * @date 2024/9/22 01:13
 * @desc 34.在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class SearchRange {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int [] nums = new int[]{5,7,7,8,8,10};

        int[] result = searchRange(nums,8);

        return result[0] == 3 && result[1] == 4;
    }

    public static boolean case2(){
        int [] nums = new int[]{5,7,7,8,8,10};

        int[] result = searchRange(nums,6);

        return result[0] == -1 && result[1] == -1;
    }

    public static boolean case3(){
        int [] nums = new int[]{};

        int[] result = searchRange(nums,0);

        return result[0] == -1 && result[1] == -1;
    }

//    public static boolean case4(){
//        int [] nums = new int[]{1,3,5};
//
//        int result = search(nums,3);
//
//        return result == 1;
//    }
//
//    public static boolean case5(){
//        int [] nums = new int[]{8,1,2,3,4,5,6,7};
//
//        int result = search(nums,6);
//
//        return result == 6;
//    }

    public static boolean checkResult(String[] str1, List<String> str2) {
        for (int i = 0; i < str1.length;i++){
            if (!str2.contains(str1[i])){
                return false;
            }
        }

        return true;
    }

    private static int[] searchRange(int[] nums, int target){
        if (nums.length == 0){
            return new int[]{-1,-1};
        }

        return searchRange(nums,0,nums.length-1,target);
    }

    private static int[] searchRange(int[] nums,int start,int end, int target){
        if (nums[start] == target && nums[end] == target){
            return new int[]{start,end};
        }

        if (start == end){
            return new int[]{-1,-1};
        }

        int center = (start + end) / 2;

        int left = center;
        int right = center;

        if (nums[center] > target){
            return searchRange(nums,start,Math.max(start,center-1),target);
        } else if (nums[center] < target){
            return searchRange(nums,Math.min(end,center+1),end,target);
        } else {
            if (nums[start] < target){
                int[] leftResult =  searchRange(nums,start,Math.max(start,center-1),target);
                if (leftResult[0] > -1){
                    left = Math.min(leftResult[0],left);
                }
            } else {
                left = start;
            }

            if (nums[end] > target){
                int[] rightResult =  searchRange(nums,Math.min(end,center+1),end,target);
                if (rightResult[1] > -1){
                    right = Math.max(rightResult[1],right);
                }
            } else {
                right = end;
            }

            return new int[]{left,right};
        }
    }
}
