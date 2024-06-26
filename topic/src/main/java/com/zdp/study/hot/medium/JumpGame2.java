package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/6/28 01:53
 * @desc 题目：45.跳跃游戏2
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class JumpGame2 {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        int[] nums1 ={2,3,1,1,4};

        int step = jump(nums1);

        return step == 2;
    }

    public static boolean case2(){
        int[] nums1 ={2,3,0,1,4};

        int step = jump(nums1);

        return step == 2;
    }

    public static int jump(int[] nums) {
        int step = 0;
        int lp = 0;
        int rp = 0;

        if (nums.length == 1){
            return 0;
        }

        if (nums.length == 2){
            return 1;
        }

        for (;lp<nums.length;){
            int reach = -1;
            int index = -1;
            for (;rp < Math.min(lp + nums[lp] + 1,nums.length);rp++){
                if (rp + nums[rp] > reach){
                    reach = rp + nums[rp];
                    index = rp;

                    if (reach >= nums.length -1){
                        break;
                    }
                }
            }

            lp = index;
            rp = lp+1;

            if (lp > 0){
                step++;
            }

            if (lp == nums.length-1){
                break;
            }

            if (reach >= nums.length-1){
                step++;
                break;
            }

        }

        return step;
    }
}
