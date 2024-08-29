package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/8/30 00:33
 * @desc 题目：205. 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class Isomorphic {
    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        String s = "egg";
        String t = "add";
        boolean result = isIsomorphic(s,t);

        System.out.println("case 1 result = " + result);

        return result == true;
    }

    public static boolean case2(){
        String s = "foo";
        String t = "bar";
        boolean result = isIsomorphic(s,t);

        System.out.println("case 2 result = " + result);

        return result == false;
    }

    public static boolean case3(){
        String s = "paper";
        String t = "title";
        boolean result = isIsomorphic(s,t);

        System.out.println("case 3 result = " + result);

        return result == true;
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        int[] sIndexList = new int[300];
        int[] tIndexList = new int[300];

        int sIndex = 1;
        int tIndex = 1;

        for (int i = 0; i < s.length();i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            int currentSIndex = sIndexList[sChar];
            int currentTIndex = tIndexList[tChar];

            if (currentSIndex <= 0){
                sIndexList[sChar] = sIndex;
                sIndex++;
            }

            if (currentTIndex <= 0){
                tIndexList[tChar] = tIndex;
                tIndex++;
            }

            if (sIndexList[sChar] != tIndexList[tChar]){
                return false;
            }
        }

        return true;
    }

}
