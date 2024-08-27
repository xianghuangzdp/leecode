package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/8/27 02:21
 * @desc 题目：11.盛水最多的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        int[] number = new int[]{1,8,6,2,5,4,8,3,7};
        int result = maxArea(number);

        System.out.println("case 1 result = " + result);

        return result == 49;
    }

    public static boolean case2(){
        int[] number = new int[]{1,1};
        int result = maxArea(number);

        System.out.println("case 2 result = " + result);

        return result == 1;
    }

    public static boolean case3(){
        int[] number = new int[]{1,1000,1000,6,2,5,4,8,3,7};
        int result = maxArea(number);

        System.out.println("case 3 result = " + result);

        return result == 1000;
    }

    public static boolean case4(){
        int[] number = new int[]{2,3,4,5,18,17,6};
        int result = maxArea(number);

        System.out.println("case 4 result = " + result);

        return result == 17;
    }

    public static int maxArea(int[] height) {
        int left  = 0;
        int right = height.length - 1;
        int area = Math.min(height[left],height[right]) * (right-left);

        for (;left < right; left++){
            int tempArea = Math.min(height[left],height[right]) * (right-left);

            if (tempArea > area){
                area = tempArea;
            }

            if (height[left] > height[right]){
                left--;
                right--;
            }
        }

        return area;
    }
}
