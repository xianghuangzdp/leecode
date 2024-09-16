package com.zdp.study.hot.util.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/9/16 17:35
 * @desc
 */
public class CalNode {
    public Map<CalNode,Double> neighbors;
    public String val;

    public CalNode(String _val) {
        val = _val;
        neighbors = new HashMap<>();
    }
}
