package com.zdp.study.hot.util.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/16 04:15
 * @desc
 */
public class Node {

    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
