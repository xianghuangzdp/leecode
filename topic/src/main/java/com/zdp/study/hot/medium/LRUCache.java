package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zdp
 * @date 2024/9/10 01:33
 * @desc 146. LRU缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCache {
    private Map<Integer,Integer> valueMap = new HashMap<>();

    private int capacity = 0;
    private int currentCount;
    private ListNode start = new ListNode(0);
    private ListNode end = start;
    private Map<Integer,ListNode> nodeMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);

        int result = lRUCache.get(1);    // 返回 1
        if (result != 1){
            return false;
        }

        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        result = lRUCache.get(2);    // 返回 -1 (未找到)
        if (result != -1){
            return false;
        }

        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        result = lRUCache.get(1);    // 返回 -1 (未找到)
        if (result != -1){
            return false;
        }
        result = lRUCache.get(3);    // 返回 3
        if (result != 3){
            return false;
        }
        result = lRUCache.get(4);    // 返回 4
        if (result != 4){
            return false;
        }

        return true;
    }

    public static boolean case2(){
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1);

        int result = lRUCache.get(2);    // 返回 1
        if (result != 1){
            return false;
        }

        lRUCache.put(3, 2);

        result = lRUCache.get(2);    // 返回 1
        if (result != -1){
            return false;
        }

        result = lRUCache.get(3);    // 返回 1
        if (result != 2){
            return false;
        }

        return true;
    }

    public int get(int key) {
        Integer result = valueMap.get(key);
        if (result != null){
            logUse(key);
            return result;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (!valueMap.containsKey(key)){
            if (currentCount >= capacity){
                adjustCount();
            } else {
                currentCount++;
            }
        }

        logUse(key);
        valueMap.put(key,value);
    }

    private void logUse(int key){
        ListNode currentNode = nodeMap.get(key);
        if (currentNode != null){
            removeNodeFromList(currentNode);
            addNode2List(currentNode);
        } else {
            currentNode = new ListNode(key);
            nodeMap.put(key,currentNode);
            addNode2List(currentNode);
        }
    }

    private void adjustCount(){
        valueMap.remove(start.next.val);
        nodeMap.remove(start.next.val);
        removeNodeFromList(start.next);
    }

    private void removeNodeFromList(ListNode currentNode){
        if (end == currentNode){
            end = currentNode.front;
        }

        currentNode.front.next = currentNode.next;
        if (currentNode.next != null){
            currentNode.next.front = currentNode.front;
        }
        currentNode.next = null;
    }

    private void addNode2List(ListNode currentNode){
        end.next = currentNode;
        currentNode.front = end;
        end = currentNode;
    }
}
