package com.zdp.study.hot.medium;


/**
 * @author zdp
 * @date 2024/8/24 17:42
 * @desc 题目：12.整数转罗马数字
 * 七个不同的符号代表罗马数字，其值如下：
 *
 * 符号	值
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
 *
 * 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
 * 如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
 * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
 * 给定一个整数，将其转换为罗马数字。
 */
public class IntToRoman {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int source = 3749;
        String result = intToRoman(source);

        return result.equals("MMMDCCXLIX");
    }

    public static boolean case2(){
        int source = 58;
        String result = intToRoman(source);

        return result.equals("LVIII");
    }

    public static boolean case3(){
        int source = 1994;
        String result = intToRoman(source);

        return result.equals("MCMXCIV");
    }

    public static String intToRoman(int num) {
        char[] result = new char[100];

        int index = 0;

        if (num >= 1000){
            int count = num / 1000;
            for (int i = 0; i < count; i++){
                result[index + i] = 'M';
            }
            index = index + count;
            num = num % 1000;
        }

        if (num >= 900){
            result[index] = 'C';
            result[index+1] = 'M';
            index = index + 2;
            num -= 900;
        }

        if (num >= 500){
            result[index] = 'D';
            index++;
            num -= 500;
        }

        if (num >= 400){
            result[index] = 'C';
            result[index+1] = 'D';
            index = index + 2;
            num -= 400;
        }

        if (num >= 100){
            int count = num / 100;
            for (int i = 0; i < count; i++){
                result[index + i] = 'C';
            }
            index = index + count;
            num = num % 100;
        }

        if (num >= 90){
            result[index] = 'X';
            result[index+1] = 'C';
            index = index + 2;
            num -= 90;
        }

        if (num >= 50){
            result[index] = 'L';
            index++;
            num -= 50;
        }

        if (num >= 40){
            result[index] = 'X';
            result[index+1] = 'L';
            index = index + 2;
            num -= 40;
        }

        if (num >= 10){
            int count = num / 10;
            for (int i = 0; i < count; i++){
                result[index + i] = 'X';
            }
            index = index + count;
            num = num % 10;
        }

        if (num >= 9){
            result[index] = 'I';
            result[index+1] = 'X';
            index = index + 2;
            num -= 9;
        }

        if (num >= 5){
            result[index] = 'V';
            index++;
            num -= 5;
        }

        if (num >= 4){
            result[index] = 'I';
            result[index+1] = 'V';
            index = index + 2;
            num -= 4;
        }

        if (num >= 1){
            int count = num / 1;
            for (int i = 0; i < count; i++){
                result[index + i] = 'I';
            }
            index = index + count;
            num = 0;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(result,0,index);
        return builder.toString();
    }
}
