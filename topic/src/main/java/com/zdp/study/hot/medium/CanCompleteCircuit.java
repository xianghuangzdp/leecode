package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/6/30 04:33
 * @desc 题目：134.加油站
 *
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */
public class CanCompleteCircuit {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[] nums1 ={1,2,3,4,5};
        int[] nums2 ={3,4,5,1,2};

        int index = canCompleteCircuit(nums1,nums2);

        return index == 3;
    }

    public static boolean case2(){
        int[] nums1 ={2,3,4};
        int[] nums2 ={3,4,3};

        int index = canCompleteCircuit(nums1,nums2);

        return index == -1;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int l = 0;
        int r = 1;
        int n = gas.length;

        int remain = gas[l] - cost[l];

        for (; r < n * 2;r++){
            remain += gas[r% n] - cost[r% n];

            for (;l <= r && remain < 0;l++){
                remain += -gas[l%n] + cost[l%n];
            }

            if (r - l == n){
                return l;
            }
        }

        return -1;
    }
}
