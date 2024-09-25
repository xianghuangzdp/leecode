package com.zdp.study.hot.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/9/25 02:50
 * @desc
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int[] nums = new int[]{1, 2, 5};
        int result = coinChange(nums,11);

        return result == 3;
    }

    public static boolean case2(){
        int[] nums = new int[]{2};
        int result = coinChange(nums,3);

        return result == -1;
    }

    public static boolean case3(){
        int[] nums = new int[]{1};
        int result = coinChange(nums,0);

        return result == 0;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        Map<Integer,Integer> stepMap = new HashMap<>();
        return coinChange(coins,amount,stepMap);
    }

    public static int coinChange(int[] coins, int amount, Map<Integer,Integer> amountMap){
        if (amount == 0){
            return 0;
        }

        if (amount < 0){
            return -1;
        }

        if (amountMap.containsKey(amount)){
            return amountMap.get(amount);
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length;i++){
            int time = coinChange(coins,amount-coins[i],amountMap);
            if (time < 0){
                continue;
            }

            result = Math.min(1 + time,result);
        }

        if (result == Integer.MAX_VALUE){
            result = -1;
        }

        amountMap.put(amount,result);

        return result;
    }
}
