package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/9/19 04:05
 * @desc 918.环形子数组的最大和
 *
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 *
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ，
 * nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，
 * 不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 */
public class MaxSubArraySumCircular {
    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
        System.out.println(case5()?"case5 success":"case5 fail");
        System.out.println(case6()?"case6 success":"case6 fail");
        System.out.println(case7()?"case7 success":"case7 fail");
        System.out.println(case8()?"case8 success":"case8 fail");
    }

    public static boolean case1(){
        int[] nums1 ={1,-2,3,-2};

        int result = maxSubarraySumCircular(nums1);

        return result == 3;
    }

    public static boolean case2(){
        int[] nums1 ={5,-3,5};

        int result = maxSubarraySumCircular(nums1);

        return result == 10;
    }

    public static boolean case3(){
        int[] nums1 ={3,-2,2,-3};

        int result = maxSubarraySumCircular(nums1);

        return result == 3;
    }

    public static boolean case4(){
        int[] nums1 ={2,-2,2,7,8,0};

        int result = maxSubarraySumCircular(nums1);

        return result == 19;
    }

    public static boolean case5(){
        int[] nums1 ={-3,-2,-3};

        int result = maxSubarraySumCircular(nums1);

        return result == -2;
    }

    public static boolean case6(){
        int[] nums1 ={-2};
        int result = maxSubarraySumCircular(nums1);

        return result == -2;
    }

    public static boolean case7(){
        int[] nums1 ={52,183,124,154,-170,-191,-240,107,-178,171,75,186,-125,61,-298,284,21,-73,-294,253,146,248,-248,127,26,289,118,-22,-300,26,-116,-113,-44,29,252,-278,47,254,-106,246,-275,42,257,15,96,-298,-69,-104,-239,-95,-4,76,-202,156,-14,-178,188,-84,78,-195,-125,28,109,125,-25,-53,58,287,55,-296,198,281,53,-160,146,298,25,-41,-3,27,-242,169,287,-281,19,91,213,115,211,-218,124,-25,-272,278,296,-177,-166,-192,97,-49,-25,168,-81,6,-94,267,293,146,-1,-258,256,283,-156,197,28,78,267,-151,-230,-66,100,-94,-66,-123,121,-214,-182,187,65,-186,215,273,243,-99,-76,178,59,190,279,300,217,67,-117,170,163,153,-37,-147,-251,296,-176,117,68,258,-159,-300,-36,-91,-60,195,-293,-116,208,175,-100,-97,188,79,-270,80,100,211,112,264,-217,-142,5,105,171,-264,-247,138,275,227,-86,30,-219,153,10,-66,267,22,-56,-70,-234,-66,89,182,110,-146,162,-48,-201,-240,-225,-15,-275,129,-117,28,150,84,-264,249,-85,70,-140,-259,26,162,5,-203,143,184,101,140,207,131,177,274,-178,-79,14,-36,104,52,31,257,273,-52,74,276,104,-133,-255,188,-252,229,200,-74,-39,-250,142,-201,-196,-43,-40,255,-149,-299,-197,-175,-96,-155,-196,-24,12,79,71,-144,-59,-120,227,-256,-163,-297,116,286,-283,-31,-221,-41,121,-170,160,205,8,88,25,-272,-107,292,-180,299,94,-97,-81,-134,37,238};
        int result = maxSubarraySumCircular(nums1);

        return result == 5803;
    }

    public static boolean case8(){
        int[] nums1 ={2,-2,2,7,8,0};
        int result = maxSubarraySumCircular(nums1);

        return result == 19;
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int globalMax = -1000000;
        int max = -1000000;
        int maxSum = 0;

        int total = 0;
        int globalMin = 1000000;
        int min = 1000000;
        int minSum = 0;

        int length = nums.length;

        for (int i = 0; i < length ;i++){
            maxSum += nums[i];
            minSum += nums[i];
            total += nums[i];

            max = Math.max(max,maxSum);
            globalMax = Math.max(max,globalMax);

            min = Math.min(min,minSum);
            globalMin = Math.min(min,globalMin);

            if (maxSum < 0){
                maxSum = 0;
            }

            if (minSum > 0){
                minSum = 0;
            }
        }

        if (globalMin == total){
            return globalMax;
        }

        return Math.max(globalMax,total - globalMin);
    }

}
