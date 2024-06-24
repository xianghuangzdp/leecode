package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/6/24 23:05
 * @desc 题目：27：移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 */
public class RemoveItemFromList {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int[] nums1 ={3,2,2,3};
        int value = 3;

        int k = removeElement(nums1,value);

        System.out.println(join(nums1));

        return checkResult(nums1,k,value);
    }

    public static boolean case2(){
        int[] nums1 ={0,1,2,2,3,0,4,2};
        int value = 2;

        int k = removeElement(nums1,value);

        System.out.println(join(nums1));

        return checkResult(nums1,k,value);
    }

    public static boolean case3(){
        int[] nums1 ={4,5};
        int value = 5;

        int k = removeElement(nums1,value);

        System.out.println(join(nums1));

        return checkResult(nums1,k,value);
    }

    public static boolean checkResult(int [] nums1,int k,int value){
        for (int i = 0; i < k; i++){
            if (nums1[i] == value){
                return false;
            }
        }

        return true;
    }

    private static int removeElement(int[] nums, int val){
        int lastIndex = nums.length-1;
        int count = 0;

        for (int i = 0; i <= lastIndex;i++){
            int value = nums[i];
            if (value != val){
                count++;
                continue;
            }

            for (;lastIndex >= i; lastIndex--){
                int lastValue = nums[lastIndex];
                if (lastValue != val){
                    nums[i] = lastValue;
                    lastIndex--;
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    private static String join(int[] nums){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length;i++){
            builder.append(nums[i]).append(",");
        }

        return builder.toString();
    }
}
