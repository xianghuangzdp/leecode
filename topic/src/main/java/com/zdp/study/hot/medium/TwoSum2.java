package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/8/27 01:34
 * @desc 题目：167.两数之和2 - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class TwoSum2 {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int[] number = new int[]{2,7,11,15};
        int target = 9;
        int[] result = twoSum(number,target);

        System.out.println("case 1 result = " + result.toString());

        return result[0] == 1 && result[1] == 2;
    }

    public static boolean case2(){
        int[] number = new int[]{2,3,4};
        int target = 6;
        int[] result = twoSum(number,target);

        System.out.println("case 2 result = " + result.toString());

        return result[0] == 1 && result[1] == 3;
    }

    public static boolean case3(){
        int[] number = new int[]{-1,0};
        int target = -1;
        int[] result = twoSum(number,target);

        System.out.println("case 3 result = " + result.toString());

        return result[0] == 1 && result[1] == 2;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int smallNumberIndex = 0;
        int bigNumberIndex = numbers.length - 1;
        int sum;
        for (;smallNumberIndex < bigNumberIndex;smallNumberIndex++){
            for (int i = bigNumberIndex;i > smallNumberIndex;i--){
                sum = numbers[smallNumberIndex] + numbers[i];
                if (sum == target){
                    int [] result = new int[2];
                    result[0] = smallNumberIndex + 1;
                    result[1] = i + 1;
                    return result;
                } else if (sum < target){
                    break;
                } else {
                    bigNumberIndex = i;
                }
            }

        }

        return new int[2];
    }
}
