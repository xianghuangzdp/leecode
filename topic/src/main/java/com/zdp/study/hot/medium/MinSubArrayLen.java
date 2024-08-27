package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/8/28 02:36
 * @desc 题目：209.长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        int[] number = new int[]{2,3,1,2,4,3};
        int target = 7;
        int result = minSubArrayLen(target,number);

        System.out.println("case 1 result = " + result);

        return result == 2;
    }

    public static boolean case2(){
        int[] number = new int[]{1,4,4};
        int target = 4;
        int result = minSubArrayLen(target,number);

        System.out.println("case 2 result = " + result);

        return result == 1;
    }

    public static boolean case3(){
        int[] number = new int[]{1,1,1,1,1,1,1,1};
        int target = 11;
        int result = minSubArrayLen(target,number);

        System.out.println("case 3 result = " + result);

        return result == 0;
    }

    public static boolean case4(){
        int[] number = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        int target = 213;
        int result = minSubArrayLen(target,number);

        System.out.println("case 4 result = " + result);

        return result == 8;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = 0;
        int sum = 0;
        int second = 0;
        for (int i = 0;i < nums.length;i++){
            while (sum < target && second < nums.length){
                sum += nums[second];
                second++;
            }

            if (sum < target){
                break;
            }

            if (minLength <= 0){
                minLength = second - i;
            } else {
                minLength = Math.min(minLength,second - i);
            }

            sum -= nums[i];
        }

        return minLength;
    }
}
