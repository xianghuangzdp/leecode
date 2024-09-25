package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/9/24 21:10
 * @desc 172.阶乘后的0
 *
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 */
public class TrailingZeroes {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int result = trailingZeroes(3);

        return result == 0;
    }

    public static boolean case2(){
        int result = trailingZeroes(5);

        return result == 1;
    }

    public static boolean case3(){
        int result = trailingZeroes(0);

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

    public static int trailingZeroes(int n) {
        int fiveCount = 0;

        while (n > 0){
            fiveCount += n / 5;
            n = n / 5;
        }

        return fiveCount;
    }
}
