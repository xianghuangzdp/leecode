package com.zdp.study.hot.medium;

import java.util.Arrays;

/**
 * @author zdp
 * @date 2024/6/28 03:00
 * @desc 题目：274.H指数
 *
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 *
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
 * 并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 */
public class Hindex {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[] nums1 ={3,0,6,1,5};

        int index = hIndex(nums1);

        return index == 3;
    }

    public static boolean case2(){
        int[] nums1 ={1,3,1};

        int index = hIndex(nums1);

        return index == 1;
    }

    public static int hIndex(int[] citations) {
        int h = 0;
        int maxH = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++){
            if (h < citations[i]){
                h = citations[i];
            }

            if (h > citations.length - i){
                h = citations.length - i;
            }

            if (h > maxH){
                maxH = h;
            }

            if (citations.length - i < citations[i]){
                break;
            }
        }

        return maxH;
    }
}
