package com.zdp.study.hot.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/2 22:37
 * @desc 题目：228.汇总区间
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class SummaryRanges {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int[] nums1 ={0,1,2,4,5,7};

        List<String> result = summaryRanges(nums1);

        System.out.println("case 1 result = " + result);

        List<String> target = new ArrayList<>();
        Collections.addAll(target, "0->2", "4->5", "7");

        return checkResult(result,target);
    }

    public static boolean case2(){
        int[] nums1 ={0,2,3,4,6,8,9};

        List<String> result = summaryRanges(nums1);

        System.out.println("case 2 result = " + result);

        List<String> target = new ArrayList<>();
        Collections.addAll(target, "0","2->4","6","8->9");

        return checkResult(result,target);
    }

    public static boolean case3(){
        int[] nums1 ={-2147483648,-2147483647,2147483647};

        List<String> result = summaryRanges(nums1);

        System.out.println("case 3 result = " + result);

        List<String> target = new ArrayList<>();
        Collections.addAll(target, "-2147483648->-2147483647","2147483647");

        return checkResult(result,target);
    }

    public static boolean checkResult(List<String> value1,List<String> value2){
        for (int i = 0; i < value1.size(); i++){
            if (!value1.get(i).equals(value2.get(i))){
                return false;
            }
        }

        return true;
    }

    private static List<String> summaryRanges(int[] nums){
        List<String> result = new ArrayList<>();
        if (nums.length <= 0){
            return result;
        }

        if (nums.length == 1){
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int start = nums[0];
        int end;

        for (int i = 1; i < nums.length;i++){
            if ((long)nums[i] - (long)nums[i -1] > 1){
                end = nums[i-1];
                if (start == end){
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }

                start = nums[i];
            }
        }

        end = nums[nums.length-1];
        if (start == end){
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }

        return result;
    }
}
