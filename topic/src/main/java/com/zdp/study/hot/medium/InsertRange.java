package com.zdp.study.hot.medium;

import java.util.Arrays;

/**
 * @author zdp
 * @date 2024/9/3 00:51
 * @desc 57.插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 *
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 *
 * 返回插入之后的 intervals。
 *
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 */
public class InsertRange {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[][] intervals = new int[][]{
                {1,3},{6,9}
        };

        int [] newInterval = new int[]{2,5};

        int[][] result = merge(intervals,newInterval);

        System.out.println("case 1 result = " + result);

        int[][] target = new int[][]{
                {1,5},{6,9}
        };

        return checkResult(target,result);
    }

    public static boolean case2(){
        int[][] intervals = new int[][]{
                {1,2},{3,5},{6,7},{8,10},{12,16}
        };

        int [] newInterval = new int[]{4,8};

        int[][] result = merge(intervals,newInterval);

        System.out.println("case 2 result = " + result);

        int[][] target = new int[][]{
                {1,2},{3,10},{12,16}
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

    private static int[][] merge(int[][] intervals,int[] newInterval){
        int[][] result = new int[intervals.length+1][];
        if (intervals.length == 0){
            result[0] = newInterval;
            return result;
        }

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int index = 0;

        int tempStart = newStart;
        int tempEnd = newEnd;

        boolean hasInsert = false;
        for (int i = 0; i < intervals.length;i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (end < newStart){
                result[index] = new int[]{intervals[i][0],intervals[i][1]};
                index++;
            } else if (newEnd < start){
                if (!hasInsert){
                    result[index] = new int[]{tempStart,tempEnd};
                    index++;
                    hasInsert = true;
                }
                result[index] = new int[]{intervals[i][0],intervals[i][1]};
                index++;
            } else {
                tempStart = Math.min(tempStart,start);
                tempEnd = Math.max(tempEnd,end);
            }
        }

        if (!hasInsert){
            result[index] = new int[]{tempStart,tempEnd};
            index++;
        }

        return Arrays.copyOf(result, index);
    }
}
