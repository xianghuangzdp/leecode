package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/8/24 18:09
 * @desc 题目：58.最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大
 * 子字符串
 * 。
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        String source = "Hello World";
        int result = lengthOfLastWord(source);

        return result == 5;
    }

    public static boolean case2(){
        String source = "   fly me   to   the moon  ";
        int result = lengthOfLastWord(source);

        return result == 4;
    }

    public static boolean case3(){
        String source = "luffy is still joyboy";
        int result = lengthOfLastWord(source);

        return result == 6;
    }

    public static boolean case4(){
        String source = " y";
        int result = lengthOfLastWord(source);

        return result == 1;
    }

    /**
     * 直接做字典匹配即可
     */
    public static int lengthOfLastWord(String s) {
        int start = s.length()-1;
        int end = s.length()-1;

        int length = 0;

        for (;start >= 0;start--){
            char code = s.charAt(start);
            if (code == ' '){
                if (end - start > 0){
                    return end - start;
                } else {
                    end = start - 1;
                }
            } else if (start == 0){
                return end - start + 1;
            }
        }

        return length;
    }
}
