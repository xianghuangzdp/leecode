package com.zdp.study.hot.medium;

import java.util.*;

/**
 * @author zdp
 * @date 2024/9/17 23:40
 * @desc 22.括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
    }

    public static boolean case1(){
        List<String> result = generateParenthesis(3);
        String [] target = new String[]{"((()))","(()())","(())()","()(())","()()()"};
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

    private static List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        back(result,n,n,0,0,"");

        return result;
    }

    private static void back(List<String> result,int leftBound,int rightBound,int left,int right,String temp){
        if (left == leftBound && right == rightBound){
            result.add(temp);
            return;
        }

        if (left < leftBound) {
            back(result,leftBound,rightBound,left+1,right,temp + "(");
        }

        if (left > right){
            back(result,leftBound,rightBound,left,right+1,temp + ")");
        }
    }
}
