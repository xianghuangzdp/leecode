package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/6/28 01:46
 * @desc
 */
public class JumpGame {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int[] nums1 ={2,3,1,1,4};

        boolean canJump = canJump(nums1);

        return canJump == true;
    }

    public static boolean case2(){
        int[] nums1 ={3,2,1,0,4};

        boolean canJump = canJump(nums1);

        return canJump == true;
    }

    public static boolean canJump(int[] nums) {
        int lp = 0;
        int rp = 0;

        for (;rp < nums.length-1;rp++){
            if (nums[rp] == 0){
                boolean canJump = false;

                for (;lp < rp;lp++){
                    if (nums[lp] > rp - lp){
                        canJump = true;
                        break;
                    }
                }

                if (!canJump){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean canJump2(int[] nums) {
        int reach = nums[0];

        for (int i = 0;i < nums.length-1;i++){
            if (i > reach){
                return false;
            }

            reach = Math.max(i + nums[i],reach);

            if (reach > nums.length-1){
                return true;
            }
        }

        return true;
    }
}
