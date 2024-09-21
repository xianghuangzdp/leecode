package com.zdp.study.hot.medium;

import java.util.List;

/**
 * @author zdp
 * @date 2024/9/22 00:35
 * @desc 33.搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Search {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int [] nums = new int[]{4,5,6,7,0,1,2};

        int result = search(nums,0);

        return result == 4;
    }

    public static boolean case2(){
        int [] nums = new int[]{4,5,6,7,0,1,2};

        int result = search(nums,3);

        return result == -1;
    }

    public static boolean case3(){
        int [] nums = new int[]{1};

        int result = search(nums,0);

        return result == -1;
    }

    public static boolean case4(){
        int [] nums = new int[]{1,3,5};

        int result = search(nums,3);

        return result == 1;
    }

    public static boolean case5(){
        int [] nums = new int[]{8,1,2,3,4,5,6,7};

        int result = search(nums,6);

        return result == 6;
    }

    public static boolean checkResult(String[] str1, List<String> str2) {
        for (int i = 0; i < str1.length;i++){
            if (!str2.contains(str1[i])){
                return false;
            }
        }

        return true;
    }

    private static int search(int[] nums, int target){
        return search(nums,0,nums.length-1,target);
    }

    private static int search(int[] nums,int start,int end, int target){
        if (start == end){
            return nums[start] == target?start:-1;
        }

        if (target == nums[start]){
            return start;
        } else if (target == nums[end]){
            return end;
        }

        int center = (start+end)/2;
        if (nums[center] == target){
            return center;
        } else if (nums[start] < nums[center] && nums[center] < nums[end]){
            if (nums[center] > target){
                return search(nums,start,Math.max(center-1,start),target);
            } else {
                return search(nums,Math.min(center+1,end),end,target);
            }
        } else if (nums[start] > nums[center] && nums[center] > nums[end]){
            if (nums[center] < target){
                return search(nums,start,Math.max(center-1,start),target);
            } else {
                return search(nums,Math.min(center+1,end),end,target);
            }
        } else {
            if (target > nums[start]){
                if (nums[center] > nums[start]){
                    if (target > nums[center]){
                        return search(nums,Math.min(center+1,end),end,target);
                    } else {
                        return search(nums,start,Math.max(center-1,start),target);
                    }
                } else {
                    return search(nums,start,Math.max(center-1,start),target);
                }

            } else {
                if (nums[center] > nums[start]){
                    return search(nums,Math.min(center+1,end),end,target);
                } else {
                    if (target > nums[center]){
                        return search(nums,Math.min(center+1,end),end,target);
                    } else {
                        return search(nums,start,Math.max(center-1,start),target);
                    }
                }
            }
        }
    }
}
