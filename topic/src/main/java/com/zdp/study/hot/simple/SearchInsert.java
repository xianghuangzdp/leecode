package com.zdp.study.hot.simple;

import java.util.List;

/**
 * @author zdp
 * @date 2024/9/21 23:22
 * @desc 35.搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsert {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
        System.out.println(case5()?"case5 success":"case5 fail");
        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int [] nums = new int[]{1,3,5,6};

        int result = searchInsert(nums,5);

        return result == 2;
    }

    public static boolean case2(){
        int [] nums = new int[]{1,3,5,6};

        int result = searchInsert(nums,2);

        return result == 1;
    }

    public static boolean case3(){
        int [] nums = new int[]{1,3,5,6};

        int result = searchInsert(nums,7);

        return result == 4;
    }

    public static boolean case4(){
        int [] nums = new int[]{1,3,5,6};

        int result = searchInsert(nums,0);

        return result == 0;
    }

    public static boolean case5(){
        int [] nums = new int[]{1,3};

        int result = searchInsert(nums,0);

        return result == 0;
    }

    public static boolean case6(){
        int [] nums = new int[]{3,5,7,9,10};

        int result = searchInsert(nums,8);

        return result == 3;
    }

    public static boolean checkResult(String[] str1, List<String> str2) {
        for (int i = 0; i < str1.length;i++){
            if (!str2.contains(str1[i])){
                return false;
            }
        }

        return true;
    }

    private static int searchInsert(int[] nums,int target){
        return searchInsert(nums,0,nums.length-1,target);
    }

    private static int searchInsert(int[] nums,int start,int end,int target){
        if (start == end){
            if (nums[start] == target){
                return start;
            } else if (nums[start] > target){
                return start;
            } else {
                return start+1;
            }
        }

        int center = (end+start)/2;

        if (nums[center] > target){
            return searchInsert(nums,start,Math.max(center-1,start),target);
        } else if (nums[center] < target){
            return searchInsert(nums, Math.min(center+1,end),end,target);
        } else {
            return center;
        }
    }
}
