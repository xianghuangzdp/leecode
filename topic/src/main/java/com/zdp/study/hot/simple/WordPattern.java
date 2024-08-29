package com.zdp.study.hot.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/8/30 00:46
 * @desc 题目：290.单词规律
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 */
public class WordPattern {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        String pattern = "abba";
        String s = "dog cat cat dog";
        boolean result = wordPattern(pattern,s);

        System.out.println("case 1 result = " + result);

        return result == true;
    }

    public static boolean case2(){
        String pattern = "abba";
        String s = "dog cat cat fish";
        boolean result = wordPattern(pattern,s);

        System.out.println("case 2 result = " + result);

        return result == false;
    }

    public static boolean case3(){
        String pattern = "aaaa";
        String s = "dog cat cat dog";
        boolean result = wordPattern(pattern,s);

        System.out.println("case 3 result = " + result);

        return result == false;
    }

    public static boolean wordPattern(String pattern, String s) {

        Map<String,Integer> sIndexMap = new HashMap<>();
        int[] patternIndexList = new int[300];

        int patternIndex = 1;
        int sIndex = 1;

        int position = 0;

        for (int i = 0; i < pattern.length();i++){
            char patternChar = pattern.charAt(i);

            int end = s.length();

            if (position >= s.length()){
                return false;
            }

            int start = -1;
            for (int j = position;j < s.length();j++){
                if (Character.isLetterOrDigit(s.charAt(j))){
                    if (start < 0){
                        start = j;
                    }
                } else {
                    if (start >= 0){
                        end = j;
                        break;
                    }
                }
            }

            String word = s.substring(start,end);
            position = end + 1;

            int currentPatternIndex = patternIndexList[patternChar];
            Integer currentSIndex = sIndexMap.get(word);

            if (currentPatternIndex <= 0){
                patternIndexList[patternChar] = patternIndex;
                patternIndex++;
            }

            if (currentSIndex == null){
                sIndexMap.put(word,sIndex);
                sIndex++;
            }

            if (patternIndexList[patternChar] != sIndexMap.get(word)){
                return false;
            }
        }

        return position > s.length();
    }
}
