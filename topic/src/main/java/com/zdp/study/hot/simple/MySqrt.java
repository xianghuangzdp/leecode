package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/9/25 00:01
 * @desc 69.x的平方根
 *
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class MySqrt {

    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int result = mySqrt(4);

        return result == 2;
    }

    public static boolean case2(){
        int result = mySqrt(8);

        return result == 2;
    }

    public static boolean case3(){
        int result = mySqrt(2147395599);

        return result == 46339;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }

        return mySqrt(x,0,x);
    }

    public static int mySqrt(int n,int left,int right){
        if (right <= left){
            if (left * left > n){
                return left-1;
            } else {
                return left;
            }
        }

        long middle = (left + right) /2L;
        long middleSqrt = middle * middle;

        if (middleSqrt == n){
            return (int)middle;
        }

        if (middleSqrt > n){
            return mySqrt(n,left,Math.max((int)middle-1,left));
        } else {
            return mySqrt(n,Math.min((int)middle+1,right),right);
        }
    }
}
