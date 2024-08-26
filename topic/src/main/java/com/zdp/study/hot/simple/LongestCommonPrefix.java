package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/8/24 18:45
 * @desc 题目：14.最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        String[] source = new String[]{"dog","racecar","car"};
        String result = longestCommonPrefix(source);

        return result.equals("");
    }

    public static boolean case2(){
        String[] source = new String[]{"flower","flow","flight"};
        String result = longestCommonPrefix(source);

        return result.equals("fl");
    }

    public static boolean case3(){
        String[] source = new String[]{"a"};
        String result = longestCommonPrefix(source);

        return result.equals("a");
    }

    public static boolean case4(){
        String[] source = new String[]{"a","ab"};
        String result = longestCommonPrefix(source);

        return result.equals("a");
    }

    /**
     * 直接做字典匹配即可
     */
    public static String longestCommonPrefix(String[] strs) {
        String result = strs[0];

        for (int i = 1; i < strs.length; i++){
            String str = strs[i];

            while (result.length() > 0){
                if (str.startsWith(result)){
                    break;
                } else {
                    result = result.substring(0,result.length() - 1);
                }
            }

            if (result.length() == 0){
                return "";
            }
        }

        return result;
    }
}
