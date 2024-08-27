package com.zdp.study.hot.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/8/28 03:00
 * @desc 题目：3.无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 *  的长度。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
        System.out.println(case5()?"case5 success":"case5 fail");
        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        String source = "abcabcbb";
        int result = lengthOfLongestSubstring2(source);

        return result == 3;
    }

    public static boolean case2(){
        String source = "bbbbb";
        int result = lengthOfLongestSubstring2(source);

        return result == 1;
    }

    public static boolean case3(){
        String source = "pwwkew";
        int result = lengthOfLongestSubstring2(source);

        return result == 3;
    }

    public static boolean case4(){
        String source = " ";
        int result = lengthOfLongestSubstring2(source);

        return result == 1;
    }

    public static boolean case5(){
        String source = "au";
        int result = lengthOfLongestSubstring2(source);

        return result == 2;
    }

    public static boolean case6(){
        String source = "abba";
        int result = lengthOfLongestSubstring2(source);

        return result == 2;
    }

    public static int lengthOfLongestSubstring(String s) {
        int end = 0;
        int length = 0;
        int start = 0;

        if (s.length() == 1){
            return 1;
        }

        for (int i = 0;i< s.length();i++){
            Map<Character,Integer> subStrCode = new HashMap<>();
            subStrCode.put(s.charAt(i),i);

            for (end = i + 1; end < s.length();end++){
                char code = s.charAt(end);
                if (subStrCode.containsKey(code)){
                    length = Math.max(length,end - i);
                    start = subStrCode.get(code);
                    break;
                } else {
                    subStrCode.put(code,end);
                }

                if (end == s.length() - 1){
                    length = Math.max(length,end - i + 1);
                }
            }

            if (start >= i){
                i = start;
            }
        }

        return length;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int end = 0;
        int length = 0;
        int start = 0;

        if (s.length() == 1){
            return 1;
        }

        Map<Character,Integer> subStrCode = new HashMap<>();

        for (; end < s.length();end++){
            char code = s.charAt(end);
            if (subStrCode.containsKey(code)){
                length = Math.max(length,end - start);
                start = Math.max(subStrCode.get(code) + 1,start);
                subStrCode.put(code,end);
            } else {
                subStrCode.put(code,end);
            }

            if (end == s.length() - 1){
                length = Math.max(length,end - start + 1);
            }
        }

        return length;
    }
}
