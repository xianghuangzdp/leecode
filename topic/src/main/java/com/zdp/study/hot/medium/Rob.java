package com.zdp.study.hot.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/9/25 02:32
 * @desc 198.打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Rob {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int[] nums = new int[]{1,2,3,1};
        int result = rob(nums);

        return result == 4;
    }

    public static boolean case2(){
        int[] nums = new int[]{2,7,9,3,1};
        int result = rob(nums);

        return result == 12;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static int rob(int[] nums) {
        Map<Integer,Integer> stepMap = new HashMap<>();
        return rob(nums,0,stepMap);
    }

    public static int rob(int[] nums, int index, Map<Integer,Integer> robMap){
        if (index == nums.length-1){
            robMap.put(index,nums[index]);
            return nums[index];
        }

        if (index == nums.length-2){
            int result = Math.max(nums[index],nums[index+1]);
            robMap.put(index,result);
            return result;
        }

        if (robMap.containsKey(index)){
            return robMap.get(index);
        }

        int currentRob = nums[index] + rob(nums,index + 2,robMap);
        int currentEmpty = rob(nums,index+1,robMap);
        int result = Math.max(currentRob,currentEmpty);
        robMap.put(index,result);

        return result;
    }
}
