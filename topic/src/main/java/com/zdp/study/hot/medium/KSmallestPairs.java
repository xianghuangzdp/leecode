package com.zdp.study.hot.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zdp
 * @date 2024/9/22 02:57
 * @desc 373.查找和最小的K对数字
 *
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 */
public class KSmallestPairs {
    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int [] nums1 = new int[]{1,7,11};
        int [] nums2 = new int[]{2,4,6};

        List<List<Integer>> result = kSmallestPairs(nums1,nums2,3);

        return true;
    }

    public static boolean case2(){
        int [] nums1 = new int[]{1,1,2};
        int [] nums2 = new int[]{1,2,3};

        List<List<Integer>> result = kSmallestPairs(nums1,nums2,2);

        return true;
    }

    public static boolean case3(){
        int [] nums1 = new int[]{1,2,4,5,6};
        int [] nums2 = new int[]{3,5,7,9};

        List<List<Integer>> result = kSmallestPairs(nums1,nums2,20);

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

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(k,
                (l1,l2)->nums1[l1[0]] + nums2[l1[1]]-nums1[l2[0]] - nums2[l2[1]]);

        for (int i = 0; i < nums1.length;i++){
            queue.offer(new int[]{i,0});
        }

        List<List<Integer>> result = new ArrayList<>();

        while (k-- > 0 && !queue.isEmpty()){
            int [] pair = queue.poll();

            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[pair[0]]);
            temp.add(nums2[pair[1]]);
            result.add(temp);

            if (pair[1] + 1 < nums2.length){
                queue.offer(new int[]{pair[0],pair[1] + 1});
            }
        }

        return result;
    }
}
