package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/9/24 20:19
 * @desc 9.回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数
 * 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 */
public class NumberIsPalindrome {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
        System.out.println(case5()?"case5 success":"case5 fail");
        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        boolean result = isPalindrome(121);

        return result == true;
    }

    public static boolean case2(){
        boolean result = isPalindrome(-121);

        return result == false;
    }

    public static boolean case3(){
        boolean result = isPalindrome(10);

        return result == false;
    }

    public static boolean case4(){
        boolean result = isPalindrome(1000021);

        return result == false;
    }

    public static boolean case5(){
        boolean result = isPalindrome(1000030001);

        return result == false;
    }

    public static boolean case6(){
        boolean result = isPalindrome(1001);

        return result == true;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }

        int pow = log10(x);

         for (int i = 1; i <= pow/2;i++){

             int fPow10 = pow10(pow-i);
             int lPow10 = pow10(i-1);
             int first = (x / fPow10)%10;
             int last = (x / lPow10) % 10;
             if (last != first){
                 return false;
             }
         }

         return true;
    }

    private static int log10(int x){
        int result = 1;
        while (x >= 10){
            x = x / 10;
            result++;
        }

        return result;
    }

    private static int pow10(int pow){
        int result = 1;
        for (int i = 0; i < pow;i++){
            result = result * 10;
        }

        return result;
    }
}
