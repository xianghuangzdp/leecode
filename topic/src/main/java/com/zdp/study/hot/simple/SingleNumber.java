package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/9/22 23:51
 * @desc 136.只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int [] nums = new int[]{2,2,1};
        int result = singleNumber(nums);

        return result == 1;
    }

    public static boolean case2(){
        int [] nums = new int[]{4,1,2,1,2};
        int result = singleNumber(nums);

        return result == 4;
    }

    public static boolean case3(){
        int [] nums = new int[]{1};
        int result = singleNumber(nums);

        return result == 1;
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++){
            result = result ^ nums[i];
        }

        return result;
    }
}
