package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/9/25 02:08
 * @desc 50. pow(x,n)
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 */
public class MyPow {

    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        double result = myPow(2.0D,10);

        return result - 1024 < 0.001;
    }

    public static boolean case2(){
        double result = myPow(2.1D,3);

        return result - 9.261 < 0.001;
    }

    public static boolean case3(){
        double result = myPow(2.0D,-2);

        return result - 0.25 < 0.001;
    }

    public static boolean case4(){
        double result = myPow(1.0D,-2147483648);

        return result - 1 < 0.001;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static double myPow(double x, int n) {
        if (x == 0){
            return 0;
        }

        if (n == 0){
            return 1;
        }

        if (n == 1){
            return x;
        }

        if (n < 0){
            long tempN = n;
            return 1 / myPowDetail(x,-tempN);
        }

        return myPowDetail(x,n);
    }

    public static double myPowDetail(double x, long n){
        if (n == 0){
            return 1;
        }

        int logN = log2(n);
        if (logN == 0){
            return x;
        }

        double result = x;
        long consumeN = 1;

        for (int i = 0; i < logN;i++){
            result = result * result;
            consumeN = consumeN * 2;
        }

        return result * myPowDetail(x,n-consumeN);
    }

    public static int log2(long n){
        int result = 0;

        while (n > 1){
            n = n / 2;
            result++;
        }

        return result;
    }
}
