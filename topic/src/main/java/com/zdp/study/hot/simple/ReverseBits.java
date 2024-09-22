package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/9/22 16:28
 * @desc 190.颠倒二进制位
 *
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 */
public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
    }

    public static boolean case1(){
        long result = reverseBits(43261596);

        return result == 964176192;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32 && n != 0; i++){
            result = (n & 1) << (31-i) | result;
            n = n >> 1;
        }

        return result;
    }
}
