package com.zdp.study.hot.simple;

import java.util.*;

/**
 * @author zdp
 * @date 2024/8/30 21:56
 * @desc 题目：202.快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int n = 19;
        boolean result = isHappy(n);

        System.out.println("case 1 result = " + result);

        return result == true;
    }

    public static boolean case2(){
        int n = 2;
        boolean result = isHappy(n);

        System.out.println("case 2 result = " + result);
        return result == false;
    }

    public static boolean isHappy(int n) {
        Set<Integer> hasCalculateNumber = new HashSet<>();

        while (n != 1 && !hasCalculateNumber.contains(n)){
            hasCalculateNumber.add(n);
            n = calculateNextNumber(n);
        }

        return n == 1;
    }

    private static int calculateNextNumber(int n){
        int result = 0;
        while (n >= 10){
            int lastNumber = n % 10;
            result += lastNumber * lastNumber;
            n = n / 10;
        }

        result += n * n;

        return result;
    }
}
