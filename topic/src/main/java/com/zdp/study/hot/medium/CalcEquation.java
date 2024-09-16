package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.graph.CalNode;

import java.util.*;

/**
 * @author zdp
 * @date 2024/9/16 15:09
 * @desc 399.除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 */
public class CalcEquation {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        List<List<String>> equations = buildEquations1();
        double[] values = new double[]{2.0,3.0};
        List<List<String>> queries = buildQueries1();

        double[] result = calcEquation(equations,values,queries);

        double[] target = new double[]{6.00000,0.50000,-1.00000,1.00000,-1.00000};

        return checkResult(target,result);
    }

    public static boolean case2(){
        List<List<String>> equations = buildEquations2();
        double[] values = new double[]{1.5,2.5,5.0};
        List<List<String>> queries = buildQueries2();

        double[] result = calcEquation(equations,values,queries);

        double[] target = new double[]{3.75000,0.40000,5.00000,0.20000};

        return checkResult(target,result);
    }

    public static boolean case3(){
        List<List<String>> equations = buildEquations3();
        double[] values = new double[]{0.5};
        List<List<String>> queries = buildQueries3();

        double[] result = calcEquation(equations,values,queries);

        double[] target = new double[]{0.50000,2.00000,-1.00000,-1.00000};

        return checkResult(target,result);
    }

    public static boolean checkResult(double[] nums1,double [] nums2) {

        for (int j = 0; j < nums1.length; j++){
            if (nums1[j] - nums2[j] > 0.001) {
                return false;
            }
        }

        return true;
    }

    private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        Map<String, CalNode> nodeMap = new HashMap<>();
        for (int i = 0;i < equations.size();i++){
            initNode(equations.get(i),values[i],nodeMap);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size();i++){
            List<String> visitNode = new ArrayList<>();
            double queryResult = calQuery(queries.get(i).get(0),queries.get(i).get(1),nodeMap,visitNode);
            result[i] = queryResult;
        }

        return result;
    }

    private static void initNode(List<String> equation,double value,Map<String, CalNode> nodeMap){
        String node1 = equation.get(0);
        String node2 = equation.get(1);

        CalNode calNode1 = nodeMap.get(node1);
        CalNode calNode2 = nodeMap.get(node2);

        if (calNode1 == null){
            calNode1 = new CalNode(node1);
            nodeMap.put(node1,calNode1);
        }

        if (calNode2 == null){
            calNode2 = new CalNode(node2);
            nodeMap.put(node2,calNode2);
        }

        calNode1.neighbors.put(calNode2,value);
        calNode2.neighbors.put(calNode1,1/value);
    }

    private static double calQuery(String node1,String node2,Map<String, CalNode> nodeMap,List<String> visitNode){
        if (visitNode.contains(node1)){
            return -1D;
        }

        if (!nodeMap.containsKey(node1) || !nodeMap.containsKey(node2)){
            return -1D;
        }

        if (node1.equals(node2)){
            return 1D;
        }

        CalNode calNode1 = nodeMap.get(node1);
        CalNode calNode2 = nodeMap.get(node2);

        if (calNode1.neighbors.containsKey(calNode2)){
            return calNode1.neighbors.get(calNode2);
        }

        visitNode.add(node1);

        for (Map.Entry<CalNode,Double> entry:calNode1.neighbors.entrySet()){
            double calValue = calQuery(entry.getKey().val,node2,nodeMap,visitNode);
            if (calValue > 0){
                return calValue * entry.getValue();
            }
        }

        return -1;
    }

    public static List<List<String>> buildEquations1(){
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("a");
        temp.add("b");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("b");
        temp.add("c");
        result.add(temp);

        return result;
    }

    public static List<List<String>> buildQueries1(){
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("a");
        temp.add("c");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("b");
        temp.add("a");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("a");
        temp.add("e");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("a");
        temp.add("a");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("x");
        temp.add("x");
        result.add(temp);

        return result;
    }

    public static List<List<String>> buildEquations2(){
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("a");
        temp.add("b");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("b");
        temp.add("c");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("bc");
        temp.add("cd");
        result.add(temp);

        return result;
    }

    public static List<List<String>> buildQueries2(){
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("a");
        temp.add("c");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("c");
        temp.add("b");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("bc");
        temp.add("cd");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("cd");
        temp.add("bc");
        result.add(temp);

        return result;
    }

    public static List<List<String>> buildEquations3(){
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("a");
        temp.add("b");
        result.add(temp);

        return result;
    }

    public static List<List<String>> buildQueries3(){
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("a");
        temp.add("b");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("b");
        temp.add("a");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("a");
        temp.add("c");
        result.add(temp);

        temp = new ArrayList<>();
        temp.add("x");
        temp.add("y");
        result.add(temp);

        return result;
    }
}
