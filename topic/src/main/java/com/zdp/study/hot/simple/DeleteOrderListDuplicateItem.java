package com.zdp.study.hot.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zdp
 * @date 2024/6/25 22:04
 * @desc 题目：26. 删除有序数组中的重复元素
 *
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的
 * 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 */
public class DeleteOrderListDuplicateItem {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[] nums1 ={1,1,2};

        int k = removeDuplicates(nums1);

        System.out.println(join(nums1) + ", k = " + k);

        return checkResult(nums1,k);
    }

    public static boolean case2(){
        int[] nums1 ={0,0,1,1,1,2,2,3,3,4};

        int k = removeDuplicates(nums1);

        System.out.println(join(nums1) + ", k = " + k);

        return checkResult(nums1,k);
    }

    public static boolean checkResult(int [] nums,int k){
        Set<Integer> values = new HashSet<>();

        for (int i = 0; i < k; i++){
            if (i > 0){
                if (nums[i] <= nums[i-1]){
                    return false;
                }
            }

            if (values.contains(nums[i])){
                return false;
            } else {
                values.add(nums[i]);
            }
        }

        return true;
    }

    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;

        for (; right < nums.length;right++){
            if (nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
            }
        }

        return left+1;
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
