package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/9/16 04:15
 * @desc 133.克隆图
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * 测试用例格式：
 *
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 *
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 *
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回
 */
public class CloneGraph {

    public static Node cloneGraph(Node node) {
        Map<Node,Node> oldAndNewNodeMap = new HashMap<>();
        return cloneNode(node,oldAndNewNodeMap);
    }

    public static Node cloneNode(Node node,Map<Node,Node> oldAndNewNodeMap){
        if (node == null){
            return null;
        }

        if (oldAndNewNodeMap.containsKey(node)){
            return oldAndNewNodeMap.get(node);
        }

        Node result = new Node(node.val);
        oldAndNewNodeMap.put(node,result);

        List<Node> neighbors = new ArrayList<>();
        if (node.neighbors != null && node.neighbors.size() > 0){
            for (Node neighbor:node.neighbors){
                neighbors.add(cloneNode(neighbor,oldAndNewNodeMap));
            }
        }

        result.neighbors = neighbors;

        return result;
    }
}
