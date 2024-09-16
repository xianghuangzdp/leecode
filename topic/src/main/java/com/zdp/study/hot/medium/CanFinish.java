package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.graph.Node;

import java.util.*;

/**
 * @author zdp
 * @date 2024/9/16 18:10
 * @desc 207 课程表
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class CanFinish {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        int [][] prerequisites = new int[][]{
                {1,0}
        };

        boolean result = canFinish(2,prerequisites);

        return result == true;
    }

    public static boolean case2(){
        int [][] prerequisites = new int[][]{
                {1,0},{0,1},
        };

        boolean result = canFinish(2,prerequisites);

        return result == false;
    }

    public static boolean case3(){
        int [][] prerequisites = new int[][]{
                {1,4},{2,4},{3,1},{3,2},
        };

        boolean result = canFinish(5,prerequisites);

        return result == true;
    }

    public static boolean checkResult(double[] nums1,double [] nums2) {

        for (int j = 0; j < nums1.length; j++){
            if (nums1[j] - nums2[j] > 0.001) {
                return false;
            }
        }

        return true;
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites){
        Map<Integer, Node> nodeMap = new HashMap<>();

        initNode(numCourses,nodeMap);

        for (int [] pre:prerequisites){
            initNode(pre,nodeMap);
        }

        Map<Node,Integer> nodeStatus = new HashMap<>();

        for (int i = 0; i < numCourses; i++){
            boolean canFinish = checkCanFinish(i,nodeMap,nodeStatus);
            if (!canFinish){
                return false;
            }
        }

        return true;
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

    private static boolean checkCanFinish(int course,Map<Integer, Node> nodeMap,Map<Node,Integer> nodeStatus){
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
            return true;
        }

        for (Node node:courseNode.neighbors){
            boolean canFinish = checkCanFinish(node.val,nodeMap,nodeStatus);
            if (!canFinish){
                return false;
            }
        }

        nodeStatus.put(courseNode,2);

        return true;
    }

}
