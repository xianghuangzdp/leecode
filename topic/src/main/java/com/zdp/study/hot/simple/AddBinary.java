package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/9/22 13:31
 * @desc 67.二进制求和
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        String a = "11";
        String b = "1";

        String result = addBinary(a,b);

        return "100".equals(result);
    }

    public static boolean case2(){
        String a = "1010";
        String b = "1011";

        String result = addBinary(a,b);

        return "10101".equals(result);
    }

    public static boolean case3(){
        String a = "100";
        String b = "110010";

        String result = addBinary(a,b);

        return "110110".equals(result);
    }

    public static boolean checkResult(double [] nums1,Double [] exceptResult){
        for (int i = 0; i < nums1.length; i ++){
            if (nums1[i] - exceptResult[i] > 0.0001){
                return false;
            }
        }

        return true;
    }

    public static String addBinary(String a, String b) {

        int lengthA = a.length();
        int lengthB = b.length();

        int length = Math.min(lengthA,lengthB);
        int lengthMax = Math.max(lengthA,lengthB);

        int temp = 0;

        char [] result = new char[lengthMax+1];
        int index = lengthMax;

        for (int i = 0; i < length;i++){
            int valueA = a.charAt(lengthA-1-i) - '0';
            int valueB = b.charAt(lengthB-1-i) - '0';

            int indexValue = valueA + valueB + temp;
            result[index] = (char)(indexValue % 2 + '0');
            temp = indexValue / 2;
            index--;
        }

        if (a.length() > b.length()){
            for (int i = length; i < a.length(); i++){
                int valueA = a.charAt(lengthA-1-i) - '0';
                int indexValue = valueA + temp;
                result[index] = (char)(indexValue % 2 + '0');
                temp = indexValue / 2;
                index--;
            }
        } else if (a.length() < b.length()) {
            for (int i = length; i < b.length(); i++){
                int valueB = b.charAt(lengthB-1-i) - '0';
                int indexValue = valueB + temp;
                result[index] = (char)(indexValue % 2 + '0');
                temp = indexValue / 2;
                index--;
            }
        }

        result[index] = (char)(temp + '0');

        String resultStr = new String(result);
        if (temp == 0){
            return resultStr.substring(1);
        } else {
            return resultStr;
        }
    }
}
