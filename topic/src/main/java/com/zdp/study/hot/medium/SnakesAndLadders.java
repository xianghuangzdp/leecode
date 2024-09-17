package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.graph.Node;

import java.util.*;

/**
 * @author zdp
 * @date 2024/9/16 23:01
 * @desc 909.蛇梯棋
 *
 * 给你一个大小为 n x n 的整数矩阵 board ，方格按从 1 到 n2 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1][0] 开始）的每一行改变方向。
 *
 * 你一开始位于棋盘上的方格  1。每一回合，玩家需要从当前方格 curr 开始出发，按下述要求前进：
 *
 * 选定目标方格 next ，目标方格的编号在范围 [curr + 1, min(curr + 6, n2)] 。
 * 该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
 * 传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。
 * 当玩家到达编号 n2 的方格时，游戏结束。
 * 如果 board[r][c] != -1 ，位于 r 行 c 列的棋盘格中可能存在 “蛇” 或 “梯子”。那个蛇或梯子的目的地将会是 board[r][c]。编号为 1 和 n2 的方格不是任何蛇或梯子的起点。
 *
 * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。
 *
 * 举个例子，假设棋盘是 [[-1,4],[-1,3]] ，第一次移动，玩家的目标方格是 2 。那么这个玩家将会顺着梯子到达方格 3 ，但 不能 顺着方格 3 上的梯子前往方格 4 。（简单来说，类似飞行棋，玩家掷出骰子点数后移动对应格数，遇到单向的路径（即梯子或蛇）可以直接跳到路径的终点，但如果多个路径首尾相连，也不能连续跳多个路径）
 * 返回达到编号为 n2 的方格所需的最少移动次数，如果不可能，则返回 -1。
 */
public class SnakesAndLadders {

    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
        System.out.println(case5()?"case5 success":"case5 fail");
    }

    public static boolean case1(){
        int [][] board = new int[][]{
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };

        int result = snakesAndLadders(board);

        return result == 4;
    }

    public static boolean case2(){
        int [][] board = new int[][]{
                {-1,-1},
                {-1,3}
        };

        int result = snakesAndLadders(board);

        return result == 1;
    }

    public static boolean case3(){
        int [][] board = new int[][]{
                {1,1,-1},
                {1,1,1},
                {-1,1,1}
        };

        int result = snakesAndLadders(board);

        return result == -1;
    }

    public static boolean case4(){
        int [][] board = new int[][]{
                {-1,10,-1,15,-1},
                {-1,-1,18,2,20},
                {-1,-1,12,-1,-1},
                {2,4,11,18,8},
                {-1,-1,-1,-1,-1}
        };

        int result = snakesAndLadders(board);

        return result == 3;
    }

    public static boolean case5(){
        int [][] board = new int[][]{
                {-1,-1,27,13,-1,25,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {44,-1,8,-1,-1,2,-1},
                {-1,30,-1,-1,-1,-1,-1},
                {3,-1,20,-1,46,6,-1},
                {-1,-1,-1,-1,-1,-1,29},
                {-1,29,21,33,-1,-1,-1}
        };

        int result = snakesAndLadders(board);

        return result == 4;
    }

    public static boolean checkResult(int[] nums1,int [] nums2) {

        for (int j = 0; j < nums1.length; j++){
            if (nums1[j] != nums2[j]) {
                return false;
            }
        }

        return true;
    }

    private static int snakesAndLadders(int[][] board){
        Map<Integer, Node> nodeMap = new HashMap<>();

        initNode(board,nodeMap);

        List<Node> root = new ArrayList<>();
        root.add(nodeMap.get(0));
        Set<Integer> hasVisitNode = new HashSet<>();

        return bfs(root,0,nodeMap,board.length*board.length-1,hasVisitNode);
    }

    private static void initNode(int[][] board,Map<Integer, Node> nodeMap){
        int n = board.length;
        boolean left = true;

        for (int i = n-1; i >= 0; i--){
            for (int j = 0; j < n;j++){
                int index = (n-1-i) * n + j;
                Node node = nodeMap.getOrDefault(index,new Node(index));
                nodeMap.put(index,node);

                if (index < n * n -1){
                    Node nextNode = nodeMap.getOrDefault(index+1,new Node(index+1));
                    nodeMap.put(index+1,nextNode);
                    node.neighbors.add(nextNode);
                }

                int value = calValue(board,i,j,left);

                if (value > -1){
                    Node nextNode = nodeMap.getOrDefault(value-1,new Node(value-1));
                    nodeMap.put(value-1,nextNode);
                    node.neighbors.add(nextNode);
                }
            }

            left = !left;
        }
    }

    private static int calValue(int[][] board,int i,int j,boolean left){
        if (left){
            return board[i][j];
        } else {
            return board[i][board[i].length - j - 1];
        }
    }

    private static int bfs(List<Node> nodeList,int step,Map<Integer, Node> nodeMap,int end,Set<Integer> hasVisitNode){

        Set<Integer> next = new HashSet<>();
        for (Node node:nodeList){
            bfs(node,6,false,next);
        }

        if (next.contains(end)){
            return step + 1;
        }

        if (step + 1 > end){
            return -1;
        }

        List<Node> nextNodeList = new ArrayList<>();
        for (Integer node:next){
            if (!hasVisitNode.contains(node)){
                nextNodeList.add(nodeMap.get(node));
                hasVisitNode.add(node);
            }
        }

        nextNodeList.sort(Comparator.comparing(i -> -i.val));

        return bfs(nextNodeList,step+1,nodeMap,end,hasVisitNode);
    }

    private static void bfs(Node node,int step,boolean jump,Set<Integer> nextList){
        if (jump){
            nextList.add(node.val);
            return;
        }

        if (step < 6){
            if (node.neighbors.size() > 1){
                bfs(findNextStep(node.neighbors,node.val),step-1,true,nextList);
            } else {
                nextList.add(node.val);
            }
        }

        if (step <= 0){
            return;
        }

        for (Node neighbor:node.neighbors){
            if (neighbor.val != node.val + 1){
                if (step < 6) {
                    bfs(neighbor, step - 1, true,nextList);
                }
            } else {
                bfs(neighbor, step - 1, false,nextList);
            }
        }
    }

    public static Node findNextStep(List<Node> neighbors,int index){
        for (Node node:neighbors){
            if (node.val != index + 1){
                return node;
            }
        }

        return neighbors.get(0);
    }
}
