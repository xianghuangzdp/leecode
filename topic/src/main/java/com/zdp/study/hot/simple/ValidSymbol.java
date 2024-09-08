package com.zdp.study.hot.simple;

/**
 * @author zdp
 * @date 2024/9/4 01:40
 * @desc 20.有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class ValidSymbol {
    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        String s = "()";
        boolean result = isValid(s);

        System.out.println("case 1 result = " + result);

        return result == true;
    }

    public static boolean case2(){
        String s = "()[]{}";
        boolean result = isValid(s);

        System.out.println("case 2 result = " + result);

        return result == true;
    }

    public static boolean case3(){
        String s = "(]";
        boolean result = isValid(s);

        System.out.println("case 3 result = " + result);

        return result == false;
    }

    public static boolean case4(){
        String s = "([])";
        boolean result = isValid(s);

        System.out.println("case 4 result = " + result);

        return result == true;
    }

    public static boolean isValid(String s) {
        char [] stack = new char[s.length()];
        int index = 0;

        for (int i = 0; i < s.length();i++){
            char symbol = s.charAt(i);
            if (symbol == '(' || symbol == '{' || symbol == '['){
                stack[index] = symbol;
                index++;
            } else {
                if (index <= 0){
                    return false;
                }

                if (checkSymbolPair(stack[index-1],symbol)){
                    index--;
                } else {
                    return false;
                }
            }
        }

        return index <= 0;
    }

    private static boolean checkSymbolPair(char left,char right){
        return left == '(' && right == ')' || left == '{' && right == '}' || left == '[' && right == ']';
    }
}
