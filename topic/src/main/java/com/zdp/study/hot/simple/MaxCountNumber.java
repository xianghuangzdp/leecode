package com.zdp.study.hot.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/6/26 23:40
 * @desc 题目：169. 多数元素
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MaxCountNumber {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[] nums1 ={3,2,3};

        int number = majorityElement(nums1);

        return number == 3;
    }

    public static boolean case2(){
        int[] nums1 ={2,2,1,1,1,2,2};

        int number = majorityElement(nums1);

        return number == 2;
    }

    public static int majorityElement(int[] nums) {

        Map<Integer,Integer> numAndCount = new HashMap<>();
        int maxNum = nums[0];
        int maxCount = 1;
        int n = nums.length;
        int halfn = n / 2;

        for (int i = 0;i < n;i=i+2){
            if (i == n-1){
                int count = add(nums[i],1,numAndCount,i,halfn);
                if (count > maxCount){
                    maxCount = count;
                    maxNum = nums[i];

                    if (maxCount > halfn){
                        return maxNum;
                    }
                }

                return maxNum;
            }

            int fnum = nums[i];
            int snum = nums[i+1];

            if (fnum == snum){
                int count = add(fnum,2,numAndCount,i,halfn);
                if (count > maxCount){
                    maxCount = count;
                    maxNum = fnum;

                    if (maxCount > halfn){
                        return maxNum;
                    }
                }
            } else {
                int count = add(fnum,1,numAndCount,i,halfn);
                if (count > maxCount){
                    maxCount = count;
                    maxNum = fnum;

                    if (maxCount > halfn){
                        return maxNum;
                    }
                }

                count = add(snum,1,numAndCount,i+1,halfn);
                if (count > maxCount){
                    maxCount = count;
                    maxNum = snum;

                    if (maxCount > halfn){
                        return maxNum;
                    }
                }
            }
        }

        return maxNum;
    }

    private static int add(int value, int addCount, Map<Integer,Integer> numAndCount, int index, int halfn){
        if (numAndCount.containsKey(value)){
            int count = numAndCount.get(value);
            numAndCount.put(value,count + addCount);
            return count + addCount;
        } else {
            if (index <= halfn){
                numAndCount.put(value,addCount);
                return addCount;
            } else {
                return 0;
            }
        }

    }
}
