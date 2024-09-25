package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/9/24 20:52
 * @desc 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int[] digits = new int[]{1,2,3};
        int[] result = plusOne(digits);
        int [] target = new int[]{1,2,4};
        return checkResult(target,result);
    }

    public static boolean case2(){
        int[] digits = new int[]{4,3,2,1};
        int[] result = plusOne(digits);
        int [] target = new int[]{4,3,2,2};
        return checkResult(target,result);
    }

    public static boolean case3(){
        int[] digits = new int[]{0};
        int[] result = plusOne(digits);
        int [] target = new int[]{1};
        return checkResult(target,result);
    }

    public static boolean checkResult(int [] nums1,int [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] != exceptResult[i]){
                return false;
            }
        }

        return true;
    }

    public static int[] plusOne(int[] digits) {
        int [] result = new int[digits.length];

        int temp = 1;

        for (int i = digits.length-1; i >= 0;i--){
            int value = digits[i] + temp;
            result[i] = value % 10;
            temp = value / 10;
        }

        if (temp != 0){
            int [] tempResult = new int[digits.length+1];
            tempResult[0] = temp;

            for (int i = 0; i < result.length; i++){
                tempResult[i+1] = result[i];
            }

            result = tempResult;
        }

        return result;
    }
}
