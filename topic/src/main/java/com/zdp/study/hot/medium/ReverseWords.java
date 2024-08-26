package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/8/24 19:13
 * @desc 题目：151. 反转字符串中的单词
 *
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        String source = "the sky is blue";
        String result = reverseWords(source);

        System.out.println("case 1 result = " + result);

        return result.equals("blue is sky the");
    }

    public static boolean case2(){
        String source = "  hello world  ";
        String result = reverseWords(source);

        System.out.println("case 2 result = " + result);

        return result.equals("world hello");
    }

    public static boolean case3(){
        String source = "a good   example";
        String result = reverseWords(source);

        System.out.println("case 3 result = " + result);

        return result.equals("example good a");
    }

    public static String reverseWords(String s) {
        char[] result = new char[s.length()];

        int wordStartIndex = -1;
        int wordEndIndex = -1;
        int index = 0;

        for (int point = s.length()-1;point >= 0; point--){
            if (s.charAt(point) == ' '){
                if (wordEndIndex > 0){
                    for (int i = wordStartIndex; i <= wordEndIndex;i++){
                        result[index] = s.charAt(i);
                        index++;
                    }

                    result[index] = ' ';
                    index++;

                    wordEndIndex = -1;
                }
            } else if (point == 0){
                if (wordEndIndex < 0){
                    wordEndIndex = 0;
                }

                for (int i = 0; i <= wordEndIndex;i++){
                    result[index] = s.charAt(i);
                    index++;
                }
            } else {
                wordStartIndex = point;
                if (wordEndIndex < 0){
                    wordEndIndex = point;
                }
            }
        }

        if (result[index -1] == ' '){
            index--;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(result,0,index);
        return builder.toString();
    }
}
