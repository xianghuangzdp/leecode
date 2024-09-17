package com.zdp.study.hot.util.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/17 02:21
 * @desc
 */
public class Node {

    public String strValue;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(String strValue) {
        this.strValue = strValue;
        neighbors = new ArrayList<Node>();
    }
}