package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/9/22 23:47
 * @desc 191.位1的个数
 *
 * 编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中
 * 设置位
 *  的个数（也被称为汉明重量）。
 */
public class HammingWeight {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        long result = hammingWeight(11);

        return result == 3;
    }

    public static boolean case2(){
        long result = hammingWeight(128);

        return result == 1;
    }

    public static boolean case3(){
        long result = hammingWeight(2147483645);

        return result == 30;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static int hammingWeight(int n) {
        int result = 0;

        for (int i = 0; i < 32 && n != 0; i++){
            int temp = n & 1;
            if (temp > 0){
                result++;
            }

            n = n >> 1;
        }

        return result;
    }
}
