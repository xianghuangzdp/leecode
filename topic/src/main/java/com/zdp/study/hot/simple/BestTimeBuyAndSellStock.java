package com.zdp.study.hot.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/6/28 00:11
 * @desc 题目：121.买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class BestTimeBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        int[] nums1 ={7,1,5,3,6,4};

        int number = maxProfit2(nums1);

        return number == 5;
    }

    public static boolean case2(){
        int[] nums1 ={7,6,4,3,1};

        int number = maxProfit2(nums1);

        return number == 0;
    }

    public static boolean case3(){
        int[] nums1 ={1,2};

        int number = maxProfit2(nums1);

        return number == 1;
    }

    public static boolean case4(){
        int[] nums1 ={4,7,1,2,11};

        int number = maxProfit2(nums1);

        return number == 10;
    }

    public static int maxProfit(int[] prices) {
        Map<Integer,Integer> buyIndexMap = new HashMap<>();
        Map<Integer,Integer> sellIndexMap = new HashMap<>();

        for (int i = 0; i < prices.length;i++){
            if (!buyIndexMap.containsKey(prices[i])){
                buyIndexMap.put(prices[i],i);
            }

            sellIndexMap.put(prices[i],i);
        }

        Arrays.sort(prices);

        int buy = 0;
        int sell = prices.length - 1;

        int maxValue = 0;

        int minBuyIndex = prices.length - 1;
        int maxSellPrice = 0;

        for (;buy < sell;buy++){
            int buyPrice = prices[buy];
            int buyIndex = buyIndexMap.get(buyPrice);

            if (buyIndex < minBuyIndex){
                minBuyIndex = buyIndex;
            } else {
                continue;
            }

            for (int i = sell;buy < i;i--){
                int sellPrice = prices[i];

                if (sellPrice < maxSellPrice){
                    break;
                }

                int sellIndex = sellIndexMap.get(sellPrice);

                if (prices[i] - prices[buy] < maxValue){
                    break;
                }

                if (sellIndex > buyIndex){
                    int value =  sellPrice - buyPrice;
                    if (value > maxValue){
                        maxValue = value;
                    }

                    if (sellPrice > maxSellPrice){
                        maxSellPrice = sellPrice;
                    }

                    break;
                }
            }
        }

        return maxValue;
    }

    public static int maxProfit2(int[] prices) {
        int buyTime = 0;
        int sellTime = 0;
        int value = -1;

        int prepareBuyTime = -1;

        for (int i = 1; i < prices.length;i++){
            int currentPrice = prices[i];

            if (value <= 0){
                if (currentPrice > prices[sellTime] && currentPrice -  prices[buyTime] > 0){
                    sellTime = i;
                    value = prices[sellTime]-prices[buyTime];
                } else if (currentPrice < prices[buyTime] && i < prices.length - 1){
                    buyTime = i;
                    sellTime = i + 1;
                    value = prices[sellTime]-prices[buyTime];
                }
            } else {
                if (currentPrice > prices[sellTime]){
                    sellTime = i;
                    if (prepareBuyTime > 0){
                        buyTime = prepareBuyTime;
                        prepareBuyTime = -1;
                    }

                    value = prices[sellTime]-prices[buyTime];
                } else if (currentPrice < prices[buyTime] && i < prices.length - 1){
                    if (prices[i+1] - prices[i] > value){
                        buyTime = i;
                        sellTime = i + 1;
                        value = prices[sellTime]-prices[buyTime];
                    } else if (prepareBuyTime < 0 || prices[i] < prices[prepareBuyTime]){
                        prepareBuyTime = i;
                    }
                } else if (prepareBuyTime >= 0 && currentPrice - prices[prepareBuyTime] > value) {
                    buyTime = prepareBuyTime;
                    sellTime = i;
                    value = prices[sellTime]-prices[buyTime];
                }
            }
        }

        return value > 0?value:0;
    }

    public int maxProfit3(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int value = 0;

        for (int i = 0;i< prices.length;i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }

            if (prices[i] - minPrice > value){
                value = prices[i] - minPrice;
            }
        }

        return value;
    }
}
