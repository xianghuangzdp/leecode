package com.zdp.study.hot.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/17 18:02
 * @desc 211.添加与搜索单词-数据结构设计
 */
public class WordDictionary {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
    }

    public static boolean case1(){
        WordDictionary test = new WordDictionary();
        test.addWord("bad");
        test.addWord("dad");
        test.addWord("mad");

        boolean result = test.search("pad");
        if (result){
            return false;
        }

        result = test.search("bad");
        if (!result){
            return false;
        }

        result = test.search(".ad");
        if (!result){
            return false;
        }

        result = test.search("b..");
        if (!result){
            return false;
        }

        return true;
    }

    private WordDictionary[] children = new WordDictionary[26];
    private boolean isEnd = false;

    public WordDictionary() {

    }

    public void addWord(String word) {
        if (search(word)){
            return;
        }

        addWord(word,this);
    }

    public boolean search(String word) {
        List<WordDictionary> dictionaries = new ArrayList<>();
        dictionaries.add(this);

        return search(word,dictionaries,0);
    }

    private static void addWord(String word,WordDictionary dictionary){
        for (int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (dictionary.children[index] == null){
                dictionary.children[index] = new WordDictionary();
            }

            dictionary = dictionary.children[index];
        }

        dictionary.isEnd = true;
    }

    private static boolean search(String word, List<WordDictionary> dictionaries, int index){
        List<WordDictionary> next = new ArrayList<>();
        char ch = word.charAt(index);

        if (index == word.length()-1){
            if (ch == '.'){
                for (WordDictionary dictionary:dictionaries){
                    for (int i = 0; i < dictionary.children.length;i++){
                        if (dictionary.children[i] != null && dictionary.children[i].isEnd){
                            return true;
                        }
                    }
                }

            } else {
                int charIndex = ch - 'a';
                for (WordDictionary dictionary:dictionaries){
                    if (dictionary.children[charIndex] != null && dictionary.children[charIndex].isEnd){
                        return true;
                    }
                }
            }

            return false;
        }

        if (ch == '.'){
            for (WordDictionary dictionary:dictionaries){
                for (int i = 0; i < dictionary.children.length;i++){
                    if (dictionary.children[i] != null){
                        next.add(dictionary.children[i]);
                    }
                }
            }
        } else {
            int charIndex = ch - 'a';

            for (WordDictionary dictionary:dictionaries){
                if (dictionary.children[charIndex] != null){
                    next.add(dictionary.children[charIndex]);
                }
            }
        }

        if (next.size() == 0){
            return false;
        }

        return search(word,next,index+1);
    }
}
