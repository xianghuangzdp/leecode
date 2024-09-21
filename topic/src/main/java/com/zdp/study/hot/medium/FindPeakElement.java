package com.zdp.study.hot.medium;

import java.util.Arrays;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/22 00:02
 * @desc 162.寻找峰值
 */
public class FindPeakElement {

    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int [] nums = new int[]{1,2,3,1};

        int result = findPeakElement(nums);

        return result == 2;
    }

    public static boolean case2(){
        int [] nums = new int[]{1,2,1,3,5,6,4};

        int result = findPeakElement(nums);

        List<Integer> answer = Arrays.asList(1,5);

        return answer.contains(result);
    }

    public static boolean case3(){
        int [] nums = new int[]{3,4,3,2,1};

        int result = findPeakElement(nums);

        List<Integer> answer = Arrays.asList(1);

        return answer.contains(result);
    }

    public static boolean checkResult(String[] str1, List<String> str2) {
        for (int i = 0; i < str1.length;i++){
            if (!str2.contains(str1[i])){
                return false;
            }
        }

        return true;
    }

    private static int findPeakElement(int[] nums){
        if (nums.length == 1){
            return 0;
        }

        if (nums[0] > nums[1]){
            return 0;
        }

        if (nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }

        return findPeakElement(nums,0,nums.length-1);
    }

    private static int findPeakElement(int[] nums,int start,int end){
        int center = (start + end)/2;

        if (center == 0){
            center = 1;
        } else if (center == nums.length-1){
            center = nums.length-2;
        }

        if (nums[center] > nums[center-1] && nums[center] > nums[center+1]){
            return center;
        } else if (nums[center] < nums[center-1] && nums[center] > nums[center+1]){
            return findPeakElement(nums,start,Math.max(center-1,start));
        } else {
            return findPeakElement(nums, Math.min(center+1,end),end);
        }
    }
}
