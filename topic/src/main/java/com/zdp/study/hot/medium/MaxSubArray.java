package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/9/19 02:41
 * @desc 53.最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
        System.out.println(case5()?"case5 success":"case5 fail");
    }

    public static boolean case1(){
        int[] nums1 ={-2,1,-3,4,-1,2,1,-5,4};

        int result = maxSubArray(nums1);

        return result == 6;
    }

    public static boolean case2(){
        int[] nums1 ={1};

        int result = maxSubArray(nums1);

        return result == 1;
    }

    public static boolean case3(){
        int[] nums1 ={5,4,-1,7,8};

        int result = maxSubArray(nums1);

        return result == 23;
    }

    public static boolean case4(){
        int[] nums1 ={-2,1};

        int result = maxSubArray(nums1);

        return result == 1;
    }

    public static boolean case5(){
        int[] nums1 ={-2,1,-3,4,-1,2,1,-5,4};

        int result = maxSubArray(nums1);

        return result == 6;
    }

    public static int maxSubArray(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length;i++){
            sum += nums[i];
            max = Math.max(sum,max);
            globalMax = Math.max(max,globalMax);
            if (sum < 0){
                sum = 0;
            }
        }

        return globalMax;
    }
}
