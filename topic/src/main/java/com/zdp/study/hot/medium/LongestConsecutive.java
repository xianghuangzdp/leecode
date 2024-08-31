package com.zdp.study.hot.medium;

import java.util.*;

/**
 * @author zdp
 * @date 2024/8/30 22:57
 * @desc 题目：128.最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int [] nums = new int[] {100,4,200,1,3,2};
        int result = longestConsecutive(nums);

        System.out.println("case 1 result = " + result);

        return result == 4;
    }

    public static boolean case2(){
        int [] nums = new int[] {0,3,7,2,5,8,4,6,0,1};
        int result = longestConsecutive(nums);
        System.out.println("case 2 result = " + result);

        return result == 9;
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 0){
            return 0;
        }

        Set<Integer> valueMap = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            valueMap.add(nums[i]);
        }

        Set<Integer> afterCheckNum = new HashSet<>();

        int maxLength = 1;

        for (int num:valueMap){
            if (afterCheckNum.contains(num)){
                continue;
            }

            for (int j = 1;j <= nums.length;j++){
                if (!valueMap.contains(num + j)){
                    maxLength = Math.max(maxLength,j);
                    break;
                } else {
                    afterCheckNum.add(num+j);
                }
            }

            afterCheckNum.add(num);
        }


        return maxLength;
    }
}
