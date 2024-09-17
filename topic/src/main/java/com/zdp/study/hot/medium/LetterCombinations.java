package com.zdp.study.hot.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/9/17 18:32
 * @desc 17.电话号码的字母组合
 */
public class LetterCombinations {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        String digits = "23";

        List<String> result = letterCombinations(digits);
        String [] target = new String[]{"ad","ae","af","bd","be","bf","cd","ce","cf"};

        return checkResult(target,result);
    }

    public static boolean case2(){
        String digits = "";

        List<String> result = letterCombinations(digits);
        String [] target = new String[]{};

        return checkResult(target,result);
    }

    public static boolean case3(){
        String digits = "2";

        List<String> result = letterCombinations(digits);
        String [] target = new String[]{"a","b","c"};

        return checkResult(target,result);
    }

    public static boolean checkResult(String[] str1,List<String> str2) {
        for (int i = 0; i < str1.length;i++){
            if (!str2.contains(str1[i])){
                return false;
            }
        }

        return true;
    }

    private static List<String> letterCombinations(String digits){
        Map<Integer,List<String>> codeMap = init();

        List<String> result = new ArrayList<>();
        if (digits.length() == 0){
            return result;
        }

        result.add("");

        for (int i = 0; i < digits.length(); i++){
            int number = digits.charAt(i) - '1' + 1;
            result = letterCombinations(result,codeMap.get(number));
        }

        return result;
    }

    private static List<String> letterCombinations(List<String> temp,List<String> words){
        List<String> result = new ArrayList<>();
        for (String word:words){
            for (String t:temp){
                result.add(t + word);
            }
        }

        return result;
    }

    private static Map<Integer,List<String>> init(){
        Map<Integer,List<String>> result = new HashMap<>();

        for (int i = 2; i < 7;i++){
            List<String> word = new ArrayList<>();
            word.add(String.valueOf((char)('a' + (i-2)*3)));
            word.add(String.valueOf((char)('a' + (i-2)*3+1)));
            word.add(String.valueOf((char)('a' + (i-2)*3+2)));

            result.put(i,word);
        }

        List<String> word = new ArrayList<>();
        word.add(String.valueOf((char)('a' + (7-2)*3)));
        word.add(String.valueOf((char)('a' + (7-2)*3+1)));
        word.add(String.valueOf((char)('a' + (7-2)*3+2)));
        word.add(String.valueOf((char)('a' + (7-2)*3+3)));
        result.put(7,word);

        word = new ArrayList<>();
        word.add("t");
        word.add("u");
        word.add("v");
        result.put(8,word);

        word = new ArrayList<>();
        word.add("w");
        word.add("x");
        word.add("y");
        word.add("z");
        result.put(9,word);

        return result;
    }
}
