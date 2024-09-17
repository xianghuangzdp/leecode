package com.zdp.study.hot.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/17 18:57
 * @desc 77.组合
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
public class Combine {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        List<List<Integer>> result = combine(4,2);
        return true;
    }

    public static boolean case2(){
        List<List<Integer>> result = combine(1,1);
        return true;
    }

    public static boolean checkResult(String[] str1,List<String> str2) {
        for (int i = 0; i < str1.length;i++){
            if (!str2.contains(str1[i])){
                return false;
            }
        }

        return true;
    }

    private static List<List<Integer>> combine(int n, int k){
        List<Integer> numbers = init(n);

        List<List<Integer>> result = new ArrayList<>();
        if (k == 0){
            return result;
        }

        dfs(0,k,new ArrayList<>(),numbers,result);
        return result;
    }

    private static void dfs(int index,int k,List<Integer> temp,List<Integer> numbers,List<List<Integer>> result){
        if (temp.size() == k){
            result.add(temp);
            return;
        }

        if (index == k){
            return;
        }

        Integer lastNumber;
        if (temp.size() == 0){
            lastNumber = 0;
        } else {
            lastNumber = temp.get(temp.size()-1);
        }

        for (int i = lastNumber; i < numbers.size();i++){
            List<Integer> current = new ArrayList<>();
            current.addAll(temp);
            current.add(numbers.get(i));
            dfs(index+1,k,current,numbers,result);
        }
    }

    private static List<Integer> init(int n){
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            result.add(i);
        }

        return result;
    }
}
