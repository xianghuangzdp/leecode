package com.zdp.study.hot.simple;

import com.zdp.study.hot.util.TreeNode;

import java.util.List;

/**
 * @author zdp
 * @date 2024/9/18 01:18
 * @desc 108. 将有序数组转化为二叉搜索树
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int [] nums = new int[]{-10,-3,0,5,9};

        TreeNode result = sortedArrayToBST(nums);

        return true;
    }

    public static boolean case2(){
        int [] nums = new int[]{1,3};

        TreeNode result = sortedArrayToBST(nums);

        return true;
    }

    public static boolean checkResult(String[] str1, List<String> str2) {
        for (int i = 0; i < str1.length;i++){
            if (!str2.contains(str1[i])){
                return false;
            }
        }

        return true;
    }

    private static TreeNode sortedArrayToBST(int[] nums){
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private static TreeNode sortedArrayToBST(int[] nums,int start,int end){
        if (start > end){
            return null;
        }

        int rootIndex = (end+start)/2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = sortedArrayToBST(nums,start,rootIndex-1);
        root.right = sortedArrayToBST(nums,rootIndex+1,end);

        return root;
    }
}
