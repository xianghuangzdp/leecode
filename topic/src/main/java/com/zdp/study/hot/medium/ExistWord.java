package com.zdp.study.hot.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zdp
 * @date 2024/9/18 00:14
 * @desc 79.单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class ExistWord {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        boolean result = exist(board,"ABCCED");

        return result == true;
    }

    public static boolean case2(){
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        boolean result = exist(board,"SEE");

        return result == true;
    }

    public static boolean case3(){
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        boolean result = exist(board,"ABCB");

        return result == false;
    }

    public static boolean case4(){
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };

        boolean result = exist(board,"ABCESEEEFS");

        return result == true;
    }

    public static boolean checkResult(String[] str1,List<String> str2) {
        for (int i = 0; i < str1.length;i++){
            if (!str2.contains(str1[i])){
                return false;
            }
        }

        return true;
    }

    private static  boolean exist(char[][] board, String word){
        for (int i = 0; i < board.length;i++){
            for (int j = 0; j < board[0].length;j++){
                boolean exist = exist(board,word,i,j,new HashSet<>(),0);
                if (exist){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean exist(char[][] board, String word, int i, int j, Set<Integer> visitNode,int wordIndex){
        char ch = board[i][j];
        if (ch == word.charAt(wordIndex)) {
            int index = i * board[0].length + j;
            if (visitNode.contains(index)){
                return false;
            }

            if (word.length() == wordIndex + 1){
                return true;
            }

            visitNode.add(index);

            if (j < board[0].length - 1){
                boolean exist = exist(board,word,i,j+1,visitNode,wordIndex + 1);
                if (exist){
                    return true;
                }
            }

            if (i < board.length - 1){
                boolean exist = exist(board,word,i+1,j,visitNode,wordIndex + 1);
                if (exist){
                    return true;
                }
            }

            if (j > 0){
                boolean exist = exist(board,word,i,j-1,visitNode,wordIndex + 1);
                if (exist){
                    return true;
                }
            }

            if (i > 0){
                boolean exist = exist(board,word,i-1,j,visitNode,wordIndex + 1);
                if (exist){
                    return true;
                }
            }

            visitNode.remove(index);
            return false;
        }

        return false;
    }
}
