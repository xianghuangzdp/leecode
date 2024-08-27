package com.zdp.study.hot.medium;

import java.util.*;

/**
 * @author zdp
 * @date 2024/8/27 03:01
 * @desc 题目：15.三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {

    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
        System.out.println(case5()?"case5 success":"case5 fail");
    }

    public static boolean case1(){
        int[] number = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(number);

        System.out.println("case 1 result = " + result);

        return true;
    }

    public static boolean case2(){
        int[] number = new int[]{0,1,1};
        List<List<Integer>> result = threeSum(number);

        System.out.println("case 2 result = " + result);

        return true;
    }

    public static boolean case3(){
        int[] number = new int[]{0,0,0};
        List<List<Integer>> result = threeSum(number);

        System.out.println("case 3 result = " + result);

        return true;
    }

    public static boolean case4(){
        int[] number = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> result = threeSum(number);

        System.out.println("case 4 result = " + result);

        return true;
    }

    public static boolean case5(){
        int[] number = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> result = threeSum(number);

        System.out.println("case 4 result = " + result);

        return true;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer,Integer> valueMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (valueMap.containsKey(nums[i])){
                valueMap.put(nums[i],valueMap.get(nums[i]) + 1);
            } else {
                valueMap.put(nums[i], 1);
            }
        }

        Set<String> result = new HashSet<>();

        for (int i = 0; i < nums.length && nums[i] <= 0;i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for (int j = nums.length-1; j > i + 1 && nums[j] >= 0;j--) {
                if (j < nums.length - 1 && nums[j] == nums[j+1]){
                    continue;
                }

                int target = -nums[i] - nums[j];

                if (valueMap.containsKey(target)){
                    int count = valueMap.get(target);
                    if (target == nums[i] || target == nums[j]){
                        if (nums[i] == nums[j]){
                            if (count >= 3){
                                addAnswer(result,nums[i],nums[j],target);
                            }
                        } else {
                            if (count >= 2){
                                addAnswer(result,nums[i],nums[j],target);
                            }
                        }
                    } else {
                        addAnswer(result,nums[i],nums[j],target);
                    }
                }
            }
        }

        return convert2List(result);
    }

    public static void addAnswer(Set<String> result,int left,int center,int right) {
        List<Integer> resultRow = new ArrayList<>();
        resultRow.add(left);
        resultRow.add(center);
        resultRow.add(right);

        resultRow.sort(Integer::compareTo);

        String row = resultRow.get(0) + "_" + resultRow.get(1) + "_" + resultRow.get(2);

        if (!result.contains(row)){
            result.add(row);
        }
    }

    public static List<List<Integer>> convert2List(Set<String> resultStr){
        List<List<Integer>> result = new ArrayList<>();

        for(String row:resultStr){
            List<String> rowList = Arrays.asList(row.split("_"));
            List<Integer> rowNumberList = new ArrayList<>();

            for (String numStr:rowList){
                rowNumberList.add(Integer.parseInt(numStr));
            }

            result.add(rowNumberList);
        }

        return result;
    }
}
