package com.zdp.study.hot.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/6/27 00:13
 * @desc 题目：189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class RotateList {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[] nums1 ={1,2,3,4,5,6};

        rotate(nums1,3);

        System.out.println(join(nums1));

        return true;
    }

    public static boolean case2(){
        int[] nums1 ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};

        rotate(nums1,38);

        System.out.println(join(nums1));

        return true;
    }

    public static boolean checkResult(int [] nums,int k){
        Map<Integer,Integer> values = new HashMap<>();

        for (int i = 0; i < k; i++){
            if (i > 1){
                if (nums[i] <= nums[i-2]){
                    return false;
                }
            }

            if (values.containsKey(nums[i])){
                if (values.get(nums[i]) < 1){
                    values.put(nums[i],1);
                } else {
                    return false;
                }
            } else {
                values.put(nums[i],0);
            }
        }

        return true;
    }

    public static void rotate(int [] nums,int k){
        int n = nums.length;

        if (k > n){
            rotate(nums,k%n);
            return;
        }

        int calIndex = 0;
        int changeIndex = 0;

        for (int i = 0;i < n; i++){
            int tempIndex;
            int temp = nums[changeIndex];

            if (calIndex < (n - k)){
                tempIndex = calIndex + k;
            } else {
                tempIndex = calIndex - n + k;
            }

            nums[changeIndex] = nums[tempIndex];
            nums[tempIndex] = temp;

            if (changeIndex != tempIndex){
                calIndex = tempIndex;
            } else {
                changeIndex = changeIndex + 1;
                calIndex = changeIndex;
            }
        }
    }

    private static String join(int[] nums){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length;i++){
            builder.append(nums[i]);
            if (i < nums.length -1){
                builder.append(",");
            }
        }

        return builder.toString();
    }
}
