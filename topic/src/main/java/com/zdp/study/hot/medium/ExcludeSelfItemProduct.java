package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/6/30 03:58
 * @desc 题目：238. 除自身以外的数组乘积
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ExcludeSelfItemProduct {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[] nums1 ={1,2,3,4};

        int[] answer = productExceptSelf(nums1);

        int[] except ={24,12,8,6};

        return checkResult(answer,except);
    }

    public static boolean case2(){
        int[] nums1 ={-1,1,0,-3,3};

        int[] answer = productExceptSelf(nums1);

        int[] except ={0,0,9,0,0};

        return checkResult(answer,except);
    }

    public static boolean checkResult(int [] nums1,int [] nums2){
        for (int i = 0; i < nums1.length; i++){
            if (nums1[i] != nums2[i]){
                return false;
            }
        }

        return true;
    }

    public static int[] productExceptSelf(int[] nums) {
        int [] answerTemp1 = new int[nums.length];
        int [] answerTemp2 = new int[nums.length];

        answerTemp1[0] = nums[0];
        answerTemp2[nums.length-1] = nums[nums.length-1];

        for (int i = 1; i < nums.length; i++){
            answerTemp1[i] = answerTemp1[i-1] * nums[i];
            answerTemp2[nums.length-1-i] = answerTemp2[nums.length-i] * nums[nums.length-1-i];
        }

        int [] answer = new int[nums.length];
        for (int i = 0;i < nums.length;i++){
            if (i == 0){
                answer[i] = answerTemp2[i + 1];
                continue;
            } else if (i == nums.length - 1){
                answer[i] = answerTemp1[i-1];
                continue;
            }

            answer[i] =  answerTemp1[i-1] * answerTemp2[i + 1];
        }

        return answer;
    }
}
