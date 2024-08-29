package com.zdp.study.hot.medium;

import java.util.*;

/**
 * @author zdp
 * @date 2024/8/28 23:56
 * @desc 题目：36.有效数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 */
public class ValidSudoku {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        char[][] number = new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        boolean result = isValidSudoku(number);

        System.out.println("case 1 result = " + result);

        return result == true;
    }

    public static boolean case2(){
        char[][] number = new char[][]{{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        boolean result = isValidSudoku(number);

        System.out.println("case 2 result = " + result);

        return result == false;
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rowMap = new HashMap<>(board.length);
        Map<Integer,Set<Character>> columnMap = new HashMap<>(board.length);

        for (int i = 0;i < board.length;i = i + 3){
            for (int column = 0; column < board.length;column = column + 3){
                Set<Character> nums = new HashSet<>();
                for (int r = 0;r < 3;r++){
                    for (int j = column;j < column + 3;j++){
                        int rowIndex = i + r;
                        int columnIndex = j;

                        char value = board[rowIndex][columnIndex];
                        if (Character.isDigit(value)) {
                            if (nums.contains(value)){
                                return false;
                            } else {
                                nums.add(value);
                            }

                            Set<Character> row = rowMap.get(rowIndex);
                            if (row == null){
                                row = new HashSet<>();
                                row.add(value);
                                rowMap.put(rowIndex,row);
                            } else {
                                if (row.contains(value)){
                                    return false;
                                } else {
                                    row.add(value);
                                }
                            }

                            Set<Character> columnChar = columnMap.get(columnIndex);
                            if (columnChar == null){
                                columnChar = new HashSet<>();
                                columnChar.add(value);
                                columnMap.put(columnIndex,columnChar);
                            } else {
                                if (columnChar.contains(value)){
                                    return false;
                                } else {
                                    columnChar.add(value);
                                }
                            }
                        }


                    }
                }
            }
        }

        return true;
    }
}
