package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/6/24 01:22
 * @desc 题目：88：合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class MergeOrderList {
    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        int[] nums1 ={1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int [] exceptResult = {1,2,2,3,5,6};

        merge2(nums1,3,nums2,3);

        return checkResult(nums1,exceptResult);
    }

    public static boolean case2(){
        int[] nums1 ={1};
        int[] nums2 = {};
        int [] exceptResult = {1};

        merge2(nums1,1,nums2,0);

        return checkResult(nums1,exceptResult);
    }

    public static boolean case3(){
        int[] nums1 ={0};
        int[] nums2 = {1};
        int [] exceptResult = {1};

        merge2(nums1,0,nums2,1);

        return checkResult(nums1,exceptResult);
    }

    public static boolean case4(){
        int[] nums1 ={1,2,3,9,0,0,0};
        int[] nums2 = {2,5,6};
        int [] exceptResult = {1,2,2,3,5,6,9};

        merge2(nums1,4,nums2,3);

        return checkResult(nums1,exceptResult);
    }

    public static boolean checkResult(int [] nums1,int [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] != exceptResult[i]){
                return false;
            }
        }

        return true;
    }

    /**
     * 结题思路比较直白，直接做两个列表的合并，每次取最小的往前排
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] temp = new int[m+n];
        if (n <= 0){
            return;
        }

        int nums1Index = 0;
        int nums2Index = 0;

        boolean nums1Finished = m <= 0;
        boolean nums2Finished = false;

        for (int i = 0; i < m+n; i++){
            if (!nums2Finished && (nums1Finished || nums1[nums1Index] > nums2[nums2Index])){
                temp[i] = nums2[nums2Index];
                nums2Index++;
                nums2Finished = nums2Index >= n;
            } else {
                temp[i] = nums1[nums1Index];
                nums1Index++;
                nums1Finished = nums1Index >= m;
            }
        }

        for (int i = 0; i < m+n; i++){
            nums1[i] = temp[i];
        }
    }

    /**
     * 节约空间，因为nums1 后n的数据全部是0，从后往前排可以保证不会覆盖数据
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0){
            return;
        }

        int nums1Index = m-1;
        int nums2Index = n-1;

        boolean nums1Finished = m <= 0;
        boolean nums2Finished = false;

        for (int i = m+n-1; i >= 0; i--){
            if (!nums2Finished && (nums1Finished || nums1[nums1Index] < nums2[nums2Index])){
                nums1[i] = nums2[nums2Index];
                nums2Index--;
                nums2Finished = nums2Index < 0;
            } else {
                nums1[i] = nums1[nums1Index];
                nums1Index--;
                nums1Finished = nums1Index < 0;
            }
        }
    }
}
