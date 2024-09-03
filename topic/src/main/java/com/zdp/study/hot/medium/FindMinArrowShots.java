package com.zdp.study.hot.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zdp
 * @date 2024/9/4 00:45
 * @desc 452.用最少数量的箭引爆气球
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 *
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 */
public class FindMinArrowShots {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[][] points = new int[][]{
                {10,16},{2,8},{1,6},{7,12}
        };

        int result = findMinArrowShots(points);

        System.out.println("case 1 result = " + result);


        return result == 2;
    }

    public static boolean case2(){
        int[][] points = new int[][]{
                {1,2},{3,4},{5,6},{7,8}
        };

        int result = findMinArrowShots(points);

        System.out.println("case 2 result = " + result);


        return result == 4;
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

    private static int findMinArrowShots(int[][] points){
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int result = 0;

        int tempStart = points[0][0];
        int tempEnd = points[0][1];
        for (int i = 0; i < points.length;i++) {
            int start = points[i][0];
            int end = points[i][1];

            if (tempStart <= start && start <= tempEnd || start <= tempEnd && tempEnd <= end){
                tempStart = Math.max(start,tempStart);
                tempEnd = Math.min(end,tempEnd);
            } else {
                result++;
                tempStart = points[i][0];
                tempEnd = points[i][1];
            }
        }

        result++;

        return result;
    }
}
