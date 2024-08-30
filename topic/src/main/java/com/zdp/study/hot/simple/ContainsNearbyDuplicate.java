package com.zdp.study.hot.simple;

import java.util.*;

/**
 * @author zdp
 * @date 2024/8/30 22:44
 * @desc 题目：219.存在重复元素2
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int [] nums = new int[] {1,2,3,1};
        int k = 3;
        boolean result = containsNearbyDuplicate(nums,k);

        System.out.println("case 1 result = " + result);

        return result == true;
    }

    public static boolean case2(){
        int [] nums = new int[] {1,0,1,1};
        int k = 1;
        boolean result = containsNearbyDuplicate(nums,k);

        System.out.println("case 2 result = " + result);

        return result == true;
    }

    public static boolean case3(){
        int [] nums = new int[] {1,2,3,1,2,3};
        int k = 2;
        boolean result = containsNearbyDuplicate(nums,k);

        System.out.println("case 3 result = " + result);

        return result == false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> kValue = new HashSet<>();

        for (int i = 0; i < k && i < nums.length; i++){
            if (kValue.contains(nums[i])){
                return true;
            } else {
                kValue.add(nums[i]);
            }
        }

        for (int i = k; i < nums.length; i++){
            if (kValue.contains(nums[i])){
                return true;
            } else {
                kValue.add(nums[i]);
                kValue.remove(nums[i-k]);
            }
        }

        return false;
    }
}
