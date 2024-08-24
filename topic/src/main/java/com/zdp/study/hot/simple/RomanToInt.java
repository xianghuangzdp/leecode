package com.zdp.study.hot.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/8/24 16:42
 * @desc 题目: 13.罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 */
public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        String source = "III";
        int result = romanToInt2(source);

        return result == 3;
    }

    public static boolean case2(){
        String source = "IV";
        int result = romanToInt2(source);

        return result == 4;
    }

    public static boolean case3(){
        String source = "IX";
        int result = romanToInt2(source);

        return result == 9;
    }

    public static boolean case4(){
        String source = "LVIII";
        int result = romanToInt2(source);

        return result == 58;
    }

    /**
     * 直接做字典匹配即可
     */
    public static int romanToInt(String s) {
        Map<String,Integer> codeValueMap = new HashMap<String,Integer>(16);
        codeValueMap.put("I",1);
        codeValueMap.put("II",2);
        codeValueMap.put("III",3);
        codeValueMap.put("IV",4);
        codeValueMap.put("IX",9);
        codeValueMap.put("V",5);
        codeValueMap.put("X",10);
        codeValueMap.put("XL",40);
        codeValueMap.put("L",50);
        codeValueMap.put("XC",90);
        codeValueMap.put("C",100);
        codeValueMap.put("CD",400);
        codeValueMap.put("D",500);
        codeValueMap.put("CM",900);
        codeValueMap.put("M",1000);

        int start = 0;
        int end = 1;

        int result = 0;

        for (;end <= s.length();end++){
            String code = s.substring(start,end);

            if (!codeValueMap.containsKey(code)){
                code = s.substring(start,end-1);
                result += codeValueMap.get(code);
                start = end-1;
            }

            if (end == s.length()){
                code = s.substring(start,end);
                result += codeValueMap.get(code);
                start = end;
            }
        }

        return result;
    }

    public static int romanToInt2(String s) {
        int first = -1;
        int second = 0;

        int result = 0;

        for (;second < s.length();second++){
            char code = s.charAt(second);
            result += changeValue(code);

            Character matchCode = matchCode(code);
            if (matchCode != null && first >= 0 && matchCode == s.charAt(first)){
                result -= changeValue(s.charAt(first)) * 2;
            }

            first++;
        }

        return result;
    }

    public static int changeValue(char value){
        switch (value){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        return 0;
    }

    public static char matchCode(char value){
        switch (value){
            case 'I':
                return 1;
            case 'V':
                return 'I';
            case 'X':
                return 'I';
            case 'L':
                return 'X';
            case 'C':
                return 'X';
            case 'D':
                return 'C';
            case 'M':
                return 'C';
        }

        return 0;
    }
}
