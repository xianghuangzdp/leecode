package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/9/23 00:53
 * @desc 137.只出现一次的数字2
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int [] nums = new int[]{2,2,3,2};
        int result = singleNumber(nums);

        return result == 3;
    }

    public static boolean case2(){
        int [] nums = new int[]{0,1,0,1,0,1,99};
        int result = singleNumber(nums);

        return result == 99;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static int singleNumber(int[] nums) {
        int[] valueCount = new int[32];

        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            for (int j = 0; j < 32;j++){
                valueCount[j] += num & 1;
                num = num >> 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32;i++){
            result = result | (valueCount[i]%3 & 1) << i;
        }

        return result;
    }
}
