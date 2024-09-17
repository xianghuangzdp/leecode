package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.graph.Node;

import java.util.*;

/**
 * @author zdp
 * @date 2024/9/17 01:38
 * @desc 433.最小基因变化
 *
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 *
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 *
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 *
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 */
public class MinMutation {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
        System.out.println(case3()?"case3 success":"case3 fail");
    }

    public static boolean case1(){
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String [] bank = new String[]{
                "AACCGGTA"
        };

        int result = minMutation(start,end,bank);

        return result == 1;
    }

    public static boolean case2(){
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String [] bank = new String[]{
                "AACCGGTA","AACCGCTA","AAACGGTA"
        };

        int result = minMutation(start,end,bank);

        return result == 2;
    }

    public static boolean case3(){
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String [] bank = new String[]{
                "AAAACCCC","AAACCCCC","AACCCCCC"
        };

        int result = minMutation(start,end,bank);

        return result == 3;
    }

    public static boolean checkResult(int[] nums1,int [] nums2) {

        for (int j = 0; j < nums1.length; j++){
            if (nums1[j] != nums2[j]) {
                return false;
            }
        }

        return true;
    }

    private static int minMutation(String startGene, String endGene, String[] bank){
        Map<String, Node> nodeMap = new HashMap<>();
        initNode(bank,nodeMap);

        List<Node> start = findStartNode(startGene,nodeMap,bank);
        if (start.size() == 0){
            return -1;
        }

        List<Node> visitNode = new ArrayList<>();

        return bfs(start,0,nodeMap,endGene,visitNode);
    }

    private static List<Node> findStartNode(String startGene,Map<String, Node> nodeMap,String[] bank){
        List<Node> result = new ArrayList<>();

        for (String b:bank){
            if (!b.equals(startGene) && checkCanChangeOnce(startGene.toCharArray(),b.toCharArray())){
                result.add(nodeMap.get(b));
            }
        }

        return result;
    }

    private static void initNode(String[] bank,Map<String, Node> nodeMap){
        for (String b:bank){
            nodeMap.put(b,new Node(b));
        }

        for (String b:bank){
            addNeighbor(nodeMap.get(b),nodeMap);
        }
    }

    private static void addNeighbor(Node node,Map<String, Node> nodeMap){
        nodeMap.forEach((k,v)->{
            if (!node.neighbors.contains(v)
                    && !node.strValue.equals(k)
                    && checkCanChangeOnce(node.strValue.toCharArray(),k.toCharArray())) {
                node.neighbors.add(v);
                v.neighbors.add(node);
            }
        });
    }

    private static boolean checkCanChangeOnce(char[] list1,char[] list2){
        int count = 0;
        for (int i = 0; i < list1.length;i++){
            if (list1[i] != list2[i]){
                count++;
                if (count >= 2){
                    return false;
                }
            }
        }

        return count == 1;
    }

    private static int bfs(List<Node> nodeList,int step,Map<String, Node> nodeMap,String endGene,List<Node> visitNode){

        if (nodeList.contains(nodeMap.get(endGene))){
            return step + 1;
        }

        Set<Node> next = new HashSet<>();
        for (Node node:nodeList){
            if (!visitNode.contains(node)){
                next.addAll(node.neighbors);
                visitNode.add(node);
            }
        }

        if (next.size() == 0){
            return -1;
        }

        List<Node> nextNodeList = new ArrayList<>();
        for (Node t:next){
            nextNodeList.add(t);
        }

        return bfs(nextNodeList,step+1,nodeMap,endGene,visitNode);
    }
}
