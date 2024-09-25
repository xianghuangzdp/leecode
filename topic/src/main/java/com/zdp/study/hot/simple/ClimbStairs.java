package com.zdp.study.hot.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/9/25 02:27
 * @desc 70.爬楼梯
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int result = climbStairs(2);

        return result == 2;
    }

    public static boolean case2(){
        int result = climbStairs(3);

        return result == 3;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static int climbStairs(int n) {
        Map<Integer,Integer> stepMap = new HashMap<>();
        return climbStairs(n,stepMap);
    }

    public static int climbStairs(int n, Map<Integer,Integer> stepMap){
        if (n == 1){
            stepMap.put(1,1);
            return 1;
        }

        if (n == 2){
            stepMap.put(2,2);
            return 2;
        }

        if (stepMap.containsKey(n)){
            return stepMap.get(n);
        }

        int result = climbStairs(n-1,stepMap) + climbStairs(n-2,stepMap);
        stepMap.put(n,result);
        return result;
    }
}
