package com.zdp.study.hot.medium;

import java.util.List;

/**
 * @author zdp
 * @date 2024/9/22 01:37
 * @desc 153.寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class FindMin {

    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int [] nums = new int[]{3,4,5,1,2};

        int result = findMin(nums);

        return result == 1;
    }

    public static boolean case2(){
        int [] nums = new int[]{4,5,6,7,0,1,2};

        int result = findMin(nums);

        return result == 0;
    }

    public static boolean case3(){
        int [] nums = new int[]{11,13,15,17};

        int result = findMin(nums);

        return result == 11;
    }

    public static boolean case4(){
        int [] nums = new int[]{3,1,2};

        int result = findMin(nums);

        return result == 1;
    }
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

    private static int findMin(int[] nums){
        return findMin(nums,0,nums.length-1);
    }

    private static int findMin(int[] nums,int start,int end){
        if (nums[start] <= nums[end]){
            return nums[start];
        }

        int center = (start + end) / 2;

        if (nums[center] > nums[start]){
            return findMin(nums,Math.min(center,end),end);
        } else if (nums[center] < nums[start]){
            return findMin(nums,start,Math.max(center,start));
        } else {
            if (nums[start] < nums[end]){
                return nums[center];
            } else {
                return nums[center+1];
            }
        }
    }
}
