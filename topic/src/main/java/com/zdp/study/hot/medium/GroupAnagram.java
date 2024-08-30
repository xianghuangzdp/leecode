package com.zdp.study.hot.medium;


import java.util.*;

/**
 * @author zdp
 * @date 2024/8/30 01:08
 * @desc
 */
public class GroupAnagram {

    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);

        System.out.println("case 1 result = " + result);

        return true;
    }

    public static boolean case2(){
        String[] strs = new String[]{""};
        List<List<String>> result = groupAnagrams(strs);

        System.out.println("case 2 result = " + result);

        return true;
    }

    public static boolean case3(){
        String[] strs = new String[]{"a"};
        List<List<String>> result = groupAnagrams(strs);

        System.out.println("case 3 result = " + result);

        return true;
    }

    public static boolean case4(){
        String[] strs = new String[]{"ddddddddddg","dgggggggggg"};
        List<List<String>> result = groupAnagrams(strs);

        System.out.println("case 4 result = " + result);

        return true;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            String pattern = convert2Pattern(strs[i]);
            if (result.containsKey(pattern)){
                result.get(pattern).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.put(pattern,list);
            }
        }

        return new ArrayList<>(result.values());
    }

    public static String convert2Pattern(String value){
        if (Objects.equals(value,"")){
            return "";
        }

        int [] count = new int[26];
        for (int i = 0; i < value.length();i++){
            count[value.charAt(i)-'a']++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count.length;i++){
            if (count[i] > 0){
                builder.append((char)(i + 'a'));
                builder.append(count[i]);
                builder.append("_");
            }
        }

        return builder.toString();
    }
}
