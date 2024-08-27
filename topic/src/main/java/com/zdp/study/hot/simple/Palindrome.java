package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/8/27 01:03
 * @desc 题目：125.验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class Palindrome {

    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        String source = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(source);

        System.out.println("case 1 result = " + result);

        return result == true;
    }

    public static boolean case2(){
        String source = "race a car";
        boolean result = isPalindrome(source);

        System.out.println("case 2 result = " + result);

        return result == false;
    }

    public static boolean case3(){
        String source = " ";
        boolean result = isPalindrome(source);

        System.out.println("case 3 result = " + result);

        return result == true;
    }

    public static boolean case4(){
        String source = "0P";
        boolean result = isPalindrome(source);

        System.out.println("case 4 result = " + result);

        return result == false;
    }

    public static boolean isPalindrome(String s) {
        int endPoint = s.length() -1;
        int startPoint = 0;

        for (; startPoint < endPoint;startPoint++){
            char startChar = s.charAt(startPoint);
            if (!checkCharValid(startChar)){
                continue;
            }

            while (!checkCharValid(s.charAt(endPoint))){
                endPoint--;
                if (endPoint < startPoint){
                    return false;
                }
            }
            char endChar = s.charAt(endPoint);

            if (Character.toLowerCase(startChar) != Character.toLowerCase(endChar)){
                return false;
            }

            endPoint--;
        }

        return true;
    }

    private static boolean checkCharValid(char charValue){
        return Character.isLetterOrDigit(Character.toLowerCase(charValue));
    }
}
