package com.zdp.study.hot.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/4 01:51
 * @desc 71.简化路径
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
        System.out.println(case4()?"case4 success":"case4 fail");
    }

    public static boolean case1(){
        String source = "/home/";
        String result = simplifyPath(source);

        System.out.println("case 1 result = " + result);

        return result.equals("/home");
    }

    public static boolean case2(){
        String source = "/home//foo/";
        String result = simplifyPath(source);

        System.out.println("case 2 result = " + result);

        return result.equals("/home/foo");
    }

    public static boolean case3(){
        String source = "/home/user/Documents/../Pictures";
        String result = simplifyPath(source);

        System.out.println("case 3 result = " + result);

        return result.equals("/home/user/Pictures");
    }

    public static boolean case4(){
        String source = "/../";
        String result = simplifyPath(source);

        System.out.println("case 3 result = " + result);

        return result.equals("/");
    }

    public static String simplifyPath(String path) {
        List<String> pathList = new ArrayList<>();
        String[] pathSubList = path.split("/");

        for (int i = 0;i < pathSubList.length; i++){
            String subPath = pathSubList[i];
            if (subPath.isEmpty() || subPath.equals(".")){
                continue;
            }

            if (subPath.equals("..")){
                if (pathList.size() >= 1){
                    pathList.remove(pathList.size()-1);
                }
            } else {
                pathList.add(subPath);
            }
        }

        if (pathList.isEmpty()){
            return "/";
        }

        StringBuilder builder = new StringBuilder();
        for (String subPath:pathList){
            builder.append("/");
            builder.append(subPath);
        }

        return builder.toString();
    }
}
