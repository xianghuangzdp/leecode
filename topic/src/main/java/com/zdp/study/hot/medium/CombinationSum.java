package com.zdp.study.hot.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/17 22:37
 * @desc  39.组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
    }

    public static boolean case1(){
        int [] numbers = new int[]{8,7,4,3};
        List<List<Integer>> result = combinationSum(numbers,11);
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

    private static List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0){
            return result;
        }

        Arrays.sort(candidates);
        back(new ArrayList<>(),candidates,result,target,0);

        return result;
    }

    private static void back(List<Integer> temp, int[] nums, List<List<Integer>> result, int target,int index){
        for (int i = index; i < nums.length;i++){
            int n = nums[i];

            if (n > target){
                break;
            }

            List<Integer> current = new ArrayList<>();
            current.addAll(temp);

            current.add(n);

            if (n == target){
                result.add(current);
                break;
            } else {
                back(current,nums,result,target-n,i);
            }
        }
    }
}
