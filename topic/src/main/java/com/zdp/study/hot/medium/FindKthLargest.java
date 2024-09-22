package com.zdp.study.hot.medium;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zdp
 * @date 2024/9/22 01:56
 * @desc 215.数组的第K个大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class FindKthLargest {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
//        System.out.println(case6()?"case6 success":"case6 fail");
    }

    public static boolean case1(){
        int [] nums = new int[]{3,2,1,5,6,4};

        int result = findKthLargest2(nums,2);

        return result == 5;
    }

    public static boolean case2(){
        int [] nums = new int[]{3,2,3,1,2,4,5,5,6};

        int result = findKthLargest2(nums,4);

        return result == 4;
    }

    public static boolean case3(){
        String numsStr = readFile();
        String[] strList = numsStr.split(",");

        int result = findKthLargest2(convert(strList),10855);

        return result == -9988;
    }

    public static int[] convert(String [] list){
        int[] result = new int[list.length];
        for (int i = 0; i < list.length;i++){
            result[i] = Integer.parseInt(list[i]);
        }

        return result;
    }

    public static String readFile() {
        File file = new File("/Users/zdp/IdeaProjects/leecode/topic/src/main/resources/META-INF/findKthLargestTestCase.txt");
        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                return line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

//    public static boolean case3(){
//        int [] nums = new int[]{11,13,15,17};
//
//        int result = findMin(nums);
//
//        return result == 11;
//    }
//
//    public static boolean case4(){
//        int [] nums = new int[]{3,1,2};
//
//        int result = findMin(nums);
//
//        return result == 1;
//    }
//
//    public static boolean case5(){
//        int [] nums = new int[]{8,1,2,3,4,5,6,7};
//
//        int result = search(nums,6);
//
//        return result == 6;
//    }

    public static boolean checkResult(String[] str1, List<String> str2) {
        for (int i = 0; i < str1.length;i++){
            if (!str2.contains(str1[i])){
                return false;
            }
        }

        return true;
    }

    private static int findKthLargest(int[] nums, int k) {
        List<Integer> heap = new ArrayList<>();
        int minValueInHeap = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length;i++){
            if (nums[i] >= minValueInHeap){
                minValueInHeap = addHeap(heap,nums[i],k);
            }
        }

        if (heap.size() >= k){
            return heap.get(k-1);
        } else {
            return heap.get(heap.size()-1);
        }
    }

    private static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length;i++){
            queue.offer(nums[i]);
            if (queue.size() > k){
                queue.poll();
            }
        }

        return queue.peek();
    }

    private static int addHeap(List<Integer> heap,int value,int k){
        if (heap.size() > 0){
            int index = findIndex(heap,value,0,heap.size()-1);
            heap.add(index,value);
        } else {
            heap.add(value);
        }

        if (heap.size() > k) {
            heap.remove(k);
            return heap.get(k-1);
        } else if (heap.size() == k){
            return heap.get(k-1);
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private static int findIndex(List<Integer> heap,int value,int start,int end){
        if (start == end){
            return heap.get(start) < value?start:start+1;
        }

        int center = (start + end) / 2;
        if (heap.get(center) == value){
            return center;
        } else if (heap.get(center) < value){
            return findIndex(heap,value,start,Math.max(start,center-1));
        } else {
            return findIndex(heap,value,Math.min(end,center+1),end);
        }
    }
}
