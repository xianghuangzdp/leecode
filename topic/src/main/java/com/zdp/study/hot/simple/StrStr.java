package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/8/27 00:47
 * @desc 题目：28.找出字符串中匹配的第一个下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        String haystack = "sadbutsad";
        String needle = "sad";
        int result = strStr(haystack,needle);

        System.out.println("case 1 result = " + result);

        return result == 0;
    }

    public static boolean case2(){
        String haystack = "leetcode";
        String needle = "leeto";
        int result = strStr(haystack,needle);

        System.out.println("case 2 result = " + result);

        return result == -1;
    }

    public static boolean case3(){
        String haystack = "mississippi";
        String needle = "issip";
        int result = strStr(haystack,needle);

        System.out.println("case 3 result = " + result);

        return result == 4;
    }

    public static int strStr(String haystack, String needle) {
        int needleIndex = 0;

        for (int i = 0; i < haystack.length();i++){
            if (haystack.charAt(i) == needle.charAt(needleIndex)){
                needleIndex++;
                if (needleIndex == needle.length()){
                    return i - needleIndex + 1;
                }
            } else {
                if (needleIndex > 0){
                    i = i - needleIndex;
                    needleIndex = 0;
                }
            }
        }

        return -1;
    }
}
