package com.zdp.study.hot.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/9/25 03:08
 * @desc
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int result = lengthOfLIS(nums);

        return result == 4;
    }

    public static boolean case2(){
        int[] nums = new int[]{0,1,0,3,2,3};
        int result = lengthOfLIS(nums);

        return result == 4;
    }

    public static boolean case3(){
        int[] nums = new int[]{7,7,7,7,7,7,7};
        int result = lengthOfLIS(nums);

        return result == 1;
    }

    public static boolean case4(){
        int[] nums = new int[]{3,5,6,2,5,4,19,5,6,7,12};
        int result = lengthOfLIS(nums);

        return result == 6;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static int lengthOfLIS(int[] nums) {
        Map<Integer,Integer> lengthMap = new HashMap<>();

        int result = lengthOfLIS(nums,0,Integer.MIN_VALUE,lengthMap);

        return result;
    }

    public static int lengthOfLIS(int[] nums, int index, int value, Map<Integer,Integer> lengthMap){
        int indexValue = nums[index];

        if (indexValue <= value){
            if (index == nums.length - 1){
                return 0;
            } else {
                return lengthOfLIS(nums,index+1,value,lengthMap);
            }
        }

        if (index == nums.length - 1){
            lengthMap.put(index,1);
            return 1;
        }

        int hasCurrent;
        if (lengthMap.containsKey(index)){
            hasCurrent = lengthMap.get(index);
        } else {
            hasCurrent = 1 + lengthOfLIS(nums,index+1,indexValue,lengthMap);
        }

        int notCurrent = lengthOfLIS(nums,index+1,value,lengthMap);

        int result = Math.max(hasCurrent,notCurrent);

        lengthMap.put(index,hasCurrent);

        return result;
    }
}
