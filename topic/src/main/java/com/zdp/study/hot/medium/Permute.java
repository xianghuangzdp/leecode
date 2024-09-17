package com.zdp.study.hot.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/17 19:29
 * @desc 46.全排序
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permute {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
    }

    public static boolean case1(){
        int [] numbers = new int[]{1,2,3};
        List<List<Integer>> result = permute(numbers);
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

    private static List<List<Integer>> permute(int[] nums){

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length;i++){
            numbers.add(nums[i]);
        }

        dfs(new ArrayList<>(),numbers,result);
        return result;
    }

    private static void dfs(List<Integer> temp,List<Integer> numbers,List<List<Integer>> result){
        if (numbers.size() == 0){
            result.add(temp);
            return;
        }

        for (int i = 0; i < numbers.size();i++){
            List<Integer> current = new ArrayList<>();
            current.addAll(temp);

            Integer currentNumbers = numbers.get(i);
            current.add(currentNumbers);

            List<Integer> newNumbers = new ArrayList<>();
            newNumbers.addAll(numbers);
            newNumbers.remove(currentNumbers);

            dfs(current,newNumbers,result);
        }
    }
}
