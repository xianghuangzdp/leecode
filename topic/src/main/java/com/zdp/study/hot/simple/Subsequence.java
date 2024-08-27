package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/8/27 01:23
 * @desc
 */
public class Subsequence {
    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        String s = "abc";
        String t = "ahbgdc";
        boolean result = isSubsequence(s,t);

        System.out.println("case 1 result = " + result);

        return result == true;
    }

    public static boolean case2(){
        String s = "axc";
        String t = "ahbgdc";
        boolean result = isSubsequence(s,t);

        System.out.println("case 2 result = " + result);

        return result == false;
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0){
            return true;
        }

        int sIndex = 0;

        for (int i = 0; i < t.length();i++){
            if (t.charAt(i) == s.charAt(sIndex)){
                sIndex++;
                if (sIndex == s.length()){
                    return true;
                }
            }
        }

        return false;
    }
}
