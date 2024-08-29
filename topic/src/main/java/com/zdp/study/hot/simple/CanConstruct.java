package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/8/30 00:13
 * @desc 题目：383.赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class CanConstruct {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        String ransomNote = "a";
        String magazine = "b";
        boolean result = canConstruct(ransomNote,magazine);

        System.out.println("case 1 result = " + result);

        return result == false;
    }

    public static boolean case2(){
        String ransomNote = "aa";
        String magazine = "ab";
        boolean result = canConstruct(ransomNote,magazine);

        System.out.println("case 2 result = " + result);

        return result == false;
    }

    public static boolean case3(){
        String ransomNote = "aa";
        String magazine = "aab";
        boolean result = canConstruct(ransomNote,magazine);

        System.out.println("case 3 result = " + result);

        return result == true;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()){
            return false;
        }

        int[] charCount = new int[36];

        for (int i = 0; i < magazine.length();i++){
            char magazineChar = magazine.charAt(i);

            if (i < ransomNote.length()){
                char ransomNoteChar = ransomNote.charAt(i);
                if (magazineChar == ransomNoteChar){
                    continue;
                }

                addCount(charCount,ransomNoteChar,-1);
            }

            addCount(charCount,magazineChar,1);
        }

        for (Integer count:charCount){
            if (count < 0){
                return false;
            }
        }

        return true;
    }

    public static void addCount(int[] charCount,char charCode,int count){
        int index = charCode - 'a';
        charCount[index] = charCount[index] + count;
    }
}
