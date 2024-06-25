package com.zdp.study.hot.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/6/25 22:28
 * @desc 题目: 删除有序数组中的重复项2
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class DeleteOrderListDuplicateItem2 {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[] nums1 ={1,1,1,2,2,3};

        int k = removeDuplicates(nums1);

        System.out.println(join(nums1) + " k = " + k);

        return checkResult(nums1,k);
    }

    public static boolean case2(){
        int[] nums1 ={0,0,1,1,1,1,2,3,3};

        int k = removeDuplicates(nums1);

        System.out.println(join(nums1) + " k = " + k);

        return checkResult(nums1,k);
    }

    public static boolean checkResult(int [] nums,int k){
        Map<Integer,Integer> values = new HashMap<>();

        for (int i = 0; i < k; i++){
            if (i > 1){
                if (nums[i] <= nums[i-2]){
                    return false;
                }
            }

            if (values.containsKey(nums[i])){
                if (values.get(nums[i]) < 1){
                    values.put(nums[i],1);
                } else {
                    return false;
                }
            } else {
                values.put(nums[i],0);
            }
        }

        return true;
    }

    public static int removeDuplicates(int[] nums) {
        int left  = 0;
        int right = 1;
        int time = 0;

        for (;right < nums.length;right++){
            if (nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
                time = 0;
            } else if (time < 1){
                time++;
                left++;
                nums[left] = nums[right];
            }
        }

        return left + 1;
    }

    private static String join(int[] nums){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length;i++){
            builder.append(nums[i]);
            if (i < nums.length -1){
                builder.append(",");
            }
        }

        return builder.toString();
    }
}
