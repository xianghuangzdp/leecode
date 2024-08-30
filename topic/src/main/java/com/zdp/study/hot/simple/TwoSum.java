package com.zdp.study.hot.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/8/30 21:30
 * @desc 题目：1. 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int [] nums = new int[] {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums,target);

        System.out.println("case 1 result = " + result);

        Arrays.sort(result);

        return result[0] == 0 && result[1] == 1;
    }

    public static boolean case2(){
        int [] nums = new int[] {3,2,4};
        int target = 6;
        int[] result = twoSum(nums,target);

        System.out.println("case 2 result = " + result);

        Arrays.sort(result);
        return result[0] == 1 && result[1] == 2;
    }

    public static boolean case3(){
        int [] nums = new int[] {3,3};
        int target = 6;
        int[] result = twoSum(nums,target);

        System.out.println("case 3 result = " + result);

        Arrays.sort(result);
        return result[0] == 0 && result[1] == 1;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> valueAndIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int requestValue = target - nums[i];
            if (valueAndIndexMap.containsKey(requestValue)){
                return new int[]{i,valueAndIndexMap.get(requestValue)};
            } else {
                valueAndIndexMap.put(nums[i],i);
            }
        }

        return new int[0];
    }
}
