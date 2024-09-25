package com.zdp.study.hot.medium;

import java.util.*;

/**
 * @author zdp
 * @date 2024/9/25 02:40
 * @desc 139.单词拆分
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class WordBreak {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean result = wordBreak(s,wordDict);

        return result == true;
    }

    public static boolean case2(){
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        boolean result = wordBreak(s,wordDict);

        return result == true;
    }

    public static boolean case3(){
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean result = wordBreak(s,wordDict);

        return result == false;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Boolean> checkList = new HashMap<>();
        return wordBreak(s,wordDict,checkList);
    }

    public static boolean wordBreak(String s, List<String> wordDict,Map<String,Boolean> checkList) {
        if (s.length() == 0){
            return true;
        }

        if (checkList.containsKey(s)){
            return checkList.get(s);
        }

        for (String dic:wordDict){
            if (s.startsWith(dic)){
                String subList = s.substring(dic.length());
                if (wordBreak(subList,wordDict,checkList)){
                    return true;
                }
            }
        }

        checkList.put(s,false);

        return false;
    }
}
