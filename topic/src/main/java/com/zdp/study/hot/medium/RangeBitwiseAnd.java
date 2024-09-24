package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/9/23 01:12
 * @desc 201.数字范围按位与
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 */
public class RangeBitwiseAnd {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        int result = singleNumber(5,7);

        return result == 4;
    }

    public static boolean case2(){
        int result = singleNumber(0,0);

        return result == 0;
    }

    public static boolean case3(){
        int result = singleNumber(1,2147483647);

        return result == 0;
    }

    public static boolean case4(){
        int result = singleNumber(2,4);

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

    public static int singleNumber(int left, int right) {
        if (left == right){
            return left;
        }

        int result = left & right;
        int diff = right - left ;
        for (int i = 0; i < 32 && diff != 0; i++){
            result = result >> i+1;
            result = result << i+1;
            diff = diff >> 1;
        }

        return result;
    }
}
