package com.zdp.study.hot.hard;

/**
 * @author zdp
 * @date 2024/6/29 14:09
 * @desc 题目: 42.接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class CatchRainWater {
    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
        System.out.println(case5()?"case5 success":"case5 fail");
    }

    public static boolean case1(){
        int[] nums1 ={5,4,1,2};

        int number = trap4(nums1);

        return number == 1;
    }

    public static boolean case2(){
        int[] nums1 ={9,6,8,8,5,6,3};

        int number = trap4(nums1);

        return number == 3;
    }

    public static boolean case3(){
        int[] nums1 ={4,2,0,3,2,5};

        int number = trap4(nums1);

        return number == 9;
    }

    public static boolean case4(){
        int[] nums1 ={0,1,0,2,1,0,1,3,2,1,2,1};

        int number = trap4(nums1);

        return number == 6;
    }

    public static boolean case5(){
        int[] nums1 ={4,4,4,7,1,0};

        int number = trap3(nums1);

        return number == 0;
    }

    public static int trap3(int[] height){

        return trap3(height,0,height.length -1);
    }

    public static int trap3(int[] height,int start,int end){
        int value = 0;

        if (end - start <= 1){
            return value;
        }

        int maxHeightIndex = -1;
        int secondHeightIndex = -1;
        int minIndex = -1;

        for (int i = start; i <= end; i++){
            if (maxHeightIndex < 0){
                maxHeightIndex = i;
            } else if (height[i] > height[maxHeightIndex]){
                secondHeightIndex = maxHeightIndex;
                maxHeightIndex = i;
            } else if (height[i] == height[maxHeightIndex]){
                secondHeightIndex = i;
            } else if (secondHeightIndex < 0 || height[i] > height[secondHeightIndex]){
                secondHeightIndex = i;
            }

            if (minIndex < 0 || height[minIndex] > height[i]){
                minIndex = i;
            }
        }

        if (checkEqual(maxHeightIndex,start,end) && checkEqual(secondHeightIndex,start,end)){
            if (between(minIndex,maxHeightIndex,secondHeightIndex)){
                int maxValue = Math.min(height[start],height[end]);
                for (int i = start; i <= end ; i++){
                    value += Math.max(0,maxValue- height[i]);
                }
            }

            return value;
        }

        int newStart = Math.min(maxHeightIndex,secondHeightIndex);
        int newEnd = Math.max(maxHeightIndex,secondHeightIndex);

        return trap3(height,start,newStart) + trap3(height,newStart,newEnd) + trap3(height,newEnd,end);
    }

    private static boolean checkEqual(int value,int choose1,int choose2){
        return value == choose1 || value == choose2;
    }

    private static boolean between(int value,int first,int second){
        return first < value && value < second || first > value && value > second;
    }

    public static int trap4(int[] height){
        int res = 0;
        int left = 0;
        int preMax = 0;
        int right = height.length - 1;
        int sufMax = 0;
        while (left < right) {
            preMax = Math.max(height[left], preMax);
            sufMax = Math.max(height[right], sufMax);
            if (preMax < sufMax) {
                res = res + preMax -height[left];
                left++;
            } else {
                res = res + sufMax - height[right];
                right--;
            }
        }
        return res;
    }
}
