package com.zdp.study.hot.medium;

/**
 * @author zdp
 * @date 2024/9/17 02:20
 * @desc 208.实现Trie(字典树)
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Trie {

    private Trie[] children = new Trie[26];
    private boolean isEnd = false;

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
    }

    public static boolean case1(){
        Trie trie = new Trie();
        trie.insert("apple");
        boolean result = trie.search("apple");
        if (!result){
            return false;
        }

        result = trie.search("app");
        if (result){
            return false;
        }

        result = trie.startsWith("app");
        if (!result){
            return false;
        }

        trie.insert("app");

        result = trie.search("app");
        if (!result){
            return false;
        }

        return true;
    }

    public void insert(String word) {
        insertNode(word,this);
    }

    public boolean search(String word) {
        return searchNode(word,this);
    }

    public boolean startsWith(String prefix) {
        return searchStartWith(prefix,this);
    }

    private static void insertNode(String word,Trie temp){
        for (int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (temp.children[index] == null){
                temp.children[index] = new Trie();
            }

            temp = temp.children[index];
        }

        temp.isEnd = true;
    }

    private static boolean searchNode(String word,Trie temp){
        for (int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (temp.children[index] == null){
                return false;
            }

            temp = temp.children[index];
        }

        return temp.isEnd;
    }

    private static boolean searchStartWith(String prefix,Trie temp){
        for (int i = 0; i < prefix.length();i++){
            char ch = prefix.charAt(i);
            int index = ch - 'a';

            if (temp.children[index] == null){
                return false;
            }

            temp = temp.children[index];
        }

        return true;
    }
}
