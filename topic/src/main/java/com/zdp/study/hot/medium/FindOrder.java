package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.graph.Node;

import java.util.*;

/**
 * @author zdp
 * @date 2024/9/16 20:49
 * @desc 210. 课程表2
 *
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 */
public class FindOrder {

    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int [][] prerequisites = new int[][]{
                {1,0}
        };

        int[] result = findOrder(2,prerequisites);
        int [] target = new int[]{0,1};

        return checkResult(target,result);
    }

    public static boolean case2(){
        int [][] prerequisites = new int[][]{
                {1,0},{2,0},{3,1},{3,2}
        };

        int[] result = findOrder(4,prerequisites);
        int [] target = new int[]{0,1,2,3};

        return checkResult(target,result);
    }

    public static boolean case3(){
        int [][] prerequisites = new int[][]{

        };

        int[] result = findOrder(1,prerequisites);
        int [] target = new int[]{0};

        return checkResult(target,result);
    }

    public static boolean checkResult(int[] nums1,int [] nums2) {

        for (int j = 0; j < nums1.length; j++){
            if (nums1[j] != nums2[j]) {
                return false;
            }
        }

        return true;
    }

    private static int[] findOrder(int numCourses, int[][] prerequisites){
        Map<Integer, Node> nodeMap = new HashMap<>();

        initNode(numCourses,nodeMap);

        for (int [] pre:prerequisites){
            initNode(pre,nodeMap);
        }

        Map<Node,Integer> nodeStatus = new HashMap<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0;i < numCourses;i++){
            boolean canFinish = checkCanFinish(i,nodeMap,nodeStatus,order);
            if (!canFinish){
                return new int[0];
            }
        }

        int [] result = new int[order.size()];
        for (int i = 0; i < order.size();i++){
            result[i] = order.get(i);
        }

        return result;
    }

    private static void initNode(int numCourses,Map<Integer, Node> nodeMap){
        for (int i = 0; i < numCourses; i++){
            nodeMap.put(i,new Node(i));
        }
    }

    private static void initNode(int[] pre,Map<Integer, Node> nodeMap){
        Integer course1 = pre[0];
        Integer course2 = pre[1];

        Node courseNode1 = nodeMap.get(course1);
        Node courseNode2 = nodeMap.get(course2);

        courseNode1.neighbors.add(courseNode2);
    }

    private static boolean checkCanFinish(int course,Map<Integer, Node> nodeMap,Map<Node,Integer> nodeStatus
            ,List<Integer> order){
        Node courseNode = nodeMap.get(course);

        if (Objects.equals(nodeStatus.get(courseNode),1)){
            return false;
        }

        if (Objects.equals(nodeStatus.get(courseNode),2)){
            return true;
        }

        if (nodeStatus.get(courseNode) == null){
            nodeStatus.put(courseNode,1);
        }

        if (courseNode.neighbors == null || courseNode.neighbors.size() == 0){
            nodeStatus.put(courseNode,2);
            order.add(courseNode.val);
            return true;
        }

        for (Node node:courseNode.neighbors){
            boolean canFinish = checkCanFinish(node.val,nodeMap,nodeStatus,order);
            if (!canFinish){
                return false;
            }
        }

        order.add(courseNode.val);
        nodeStatus.put(courseNode,2);

        return true;
    }
}
