package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/8/24 19:43
 * @desc 题目：6.Z字形变换
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 */
public class ZConvert {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        String source = "PAYPALISHIRING";
        String result = convert(source,3);

        System.out.println("case 1 result = " + result);

        return result.equals("PAHNAPLSIIGYIR");
    }

    public static boolean case2(){
        String source = "PAYPALISHIRING";
        String result = convert(source,4);

        System.out.println("case 2 result = " + result);

        return result.equals("PINALSIGYAHRPI");
    }

    public static boolean case3(){
        String source = "A";
        String result = convert(source,1);

        System.out.println("case 3 result = " + result);

        return result.equals("A");
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1){
            return s;
        }

        int length = s.length();
        char[][] result = new char[numRows][length];

        int[] indexArray = new int[numRows];

        int size = numRows * 2 - 2;

        for (int point = 0;point < s.length(); point++) {
            int rowNumber = point % size;

            if (rowNumber >= numRows){
                rowNumber = numRows * 2 - rowNumber - 2;
            }

            int index = indexArray[rowNumber];
            result[rowNumber][index] = s.charAt(point);
            index++;
            indexArray[rowNumber] = index;
        }

        char[] resultChar = new char[s.length()];
        int resultIndex = 0;

        for (int i = 0; i < result.length;i++){
            char[] rowChar = result[i];
            for (int j = 0; j < rowChar.length;j++){
                if (rowChar[j] == 0){
                    break;
                }
                resultChar[resultIndex] = rowChar[j];
                resultIndex++;
            }
        }

        return new String(resultChar);
    }
}
