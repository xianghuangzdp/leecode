package com.zdp.study.hot.medium;

import java.util.*;

/**
 * @author zdp
 * @date 2024/9/2 22:58
 * @desc 56.合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class MergeRange {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        int[][] intervals = new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };

        int[][] result = merge(intervals);

        System.out.println("case 1 result = " + result);

        int[][] target = new int[][]{
                {1,6},{8,10},{15,18}
        };

        return checkResult(target,result);
    }

    public static boolean case2(){
        int[][] intervals = new int[][]{
                {1,4},{4,5}
        };

        int[][] result = merge(intervals);

        System.out.println("case 2 result = " + result);

        int[][] target = new int[][]{
                {1,5}
        };

        return checkResult(target,result);
    }

    public static boolean case3(){
        int[][] intervals = new int[][]{
                {1,4},{1,4}
        };

        int[][] result = merge(intervals);

        System.out.println("case 3 result = " + result);

        int[][] target = new int[][]{
                {1,4}
        };

        return checkResult(target,result);
    }

    public static boolean case4(){
        int[][] intervals = new int[][]{
                {1,4},{0,0}
        };

        int[][] result = merge(intervals);

        System.out.println("case 4 result = " + result);

        int[][] target = new int[][]{
                {1,4},{0,0}
        };

        return checkResult(target,result);
    }

    public static boolean checkResult(int[][] nums1,int [][] nums2){
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0;j < nums1[i].length;j++)
                if (nums1[i][j] != nums2[i][j]){
                    return false;
                }
        }

        return true;
    }

    private static int[][] merge(int[][] intervals){
        int[] templateList = new int[intervals.length*2];
        Map<Integer,List<Integer>> valueIndexMap = new HashMap<>();

        for (int i = 0; i < intervals.length;i++){
            templateList[i*2] = intervals[i][0];
            templateList[i*2+1] = intervals[i][1];

            List<Integer> indexList;
            if (valueIndexMap.containsKey(intervals[i][0])){
                indexList = valueIndexMap.get(intervals[i][0]);
            } else {
                indexList = new ArrayList<>();
            }
            indexList.add(i);
            valueIndexMap.put(intervals[i][0],indexList);

            if (valueIndexMap.containsKey(intervals[i][1])){
                indexList = valueIndexMap.get(intervals[i][1]);
            } else {
                indexList = new ArrayList<>();
            }
            indexList.add(i);
            valueIndexMap.put(intervals[i][1],indexList);
        }

        Arrays.sort(templateList);

        int[][] result = new int[intervals.length][];
        int index = 0;
        Set<Integer> rangeGroupSet = new HashSet<>();
        int start = templateList[0];
        boolean empty = true;

        for (int i = 0; i < templateList.length; i++){
            List<Integer> indexList = valueIndexMap.get(templateList[i]);
            int group = indexList.get(0);
            indexList.remove(0);

            if (empty){
                rangeGroupSet.add(group);
                start = templateList[i];
                empty = false;
            } else {
                if (rangeGroupSet.contains(group)){
                    rangeGroupSet.remove(group);
                } else {
                    rangeGroupSet.add(group);
                }

                empty = rangeGroupSet.isEmpty() && indexList.isEmpty();
                if (empty){
                    int [] range = new int[2];
                    range[0] = start;
                    range[1] = templateList[i];
                    result[index] = range;
                    index++;
                }
            }
        }

        return Arrays.copyOf(result, index);
    }
}
