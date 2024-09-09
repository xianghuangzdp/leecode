package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/9/9 22:41
 * @desc 150.逆波兰表达式求值
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 *
 * 请你计算该表达式。返回一个表示表达式值的整数。
 *
 * 注意：
 *
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 */
public class EvalRPN {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        String[] tokens ={"2","1","+","3","*"};

        int result = evalRPN(tokens);

        return result == 9;
    }

    public static boolean case2(){
        String[] tokens ={"4","13","5","/","+"};

        int result = evalRPN(tokens);

        return result == 6;
    }

    public static boolean case3(){
        String[] tokens ={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        int result = evalRPN(tokens);

        return result == 22;
    }

    public static int evalRPN(String[] tokens) {
        Integer[] stack = new Integer[tokens.length];
        int index = 0;

        for (int i = 0; i < tokens.length;i++){
            if (tokens[i].equals("+")){
                Integer num1 = stack[index-2];
                Integer num2 = stack[index-1];

                int value = num1 + num2;
                stack[index-2] = value;
                index = index - 1;

            } else if (tokens[i].equals("-")) {
                Integer num1 = stack[index-2];
                Integer num2 = stack[index-1];

                int value = num1 - num2;
                stack[index-2] = value;
                index = index - 1;

            } else if (tokens[i].equals("*")) {
                Integer num1 = stack[index-2];
                Integer num2 = stack[index-1];

                int value = num1 * num2;
                stack[index-2] = value;
                index = index - 1;

            }  else if (tokens[i].equals("/")) {
                Integer num1 = stack[index-2];
                Integer num2 = stack[index-1];

                int value = num1 / num2;
                stack[index-2] = value;
                index = index - 1;

            } else {
                stack[index] = Integer.parseInt(tokens[i]);
                index++;
            }
        }

        return stack[index-1];
    }
}
