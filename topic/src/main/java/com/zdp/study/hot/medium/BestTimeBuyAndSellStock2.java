package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/6/28 01:33
 * @desc 题目：121.买卖股票的最佳时机2
 *
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润
 */
public class BestTimeBuyAndSellStock2 {
    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int[] nums1 ={7,1,5,3,6,4};

        int number = maxProfit(nums1);

        return number == 7;
    }

    public static boolean case2(){
        int[] nums1 ={1,2,3,4,5};

        int number = maxProfit(nums1);

        return number == 4;
    }

    public static boolean case3(){
        int[] nums1 ={7,6,4,3,1};

        int number = maxProfit(nums1);

        return number == 0;
    }

    public static int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int value = 0;

        for (int i = 0;i< prices.length;i++){
            if (prices[i] < cost){
                cost = prices[i];
            }

            if (prices[i] - cost > 0){
                value += prices[i] - cost;
                cost = prices[i];
            }
        }

        return value;
    }
}
