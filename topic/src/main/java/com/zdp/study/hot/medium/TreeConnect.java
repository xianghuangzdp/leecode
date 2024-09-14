package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/14 00:25
 * @desc 171.填充每一个节点的下一个右侧节点指针2
 * 给定一个二叉树：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 */
public class TreeConnect {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
        System.out.println(case2()?"case2 success":"case2 fail");
    }

    public static boolean case1(){
        Node root = buildNode11();

        Node result = connect(root);

        return true;
    }

    public static boolean case2(){
        Node result = connect(null);

        return false;
    }

    public static Node connect(Node root) {
        List<Node> floorNodeList = new ArrayList<>();
        if (root != null){
            floorNodeList.add(root);
        }

        visitFloor(floorNodeList);

        return root;
    }

    public static void visitFloor(List<Node> floorNodeList){
        if (floorNodeList.size() == 0){
            return;
        }

        List<Node> nextFloorNodeList = new ArrayList<>();
        for (Node node:floorNodeList){
            visitNode(node,nextFloorNodeList);
        }

        visitFloor(nextFloorNodeList);
    }

    public static void visitNode(Node root,List<Node> floorNodeList){
        if (root == null){
            return;
        }

        if (root.left != null){
            if (floorNodeList.size() > 0){
                floorNodeList.get(floorNodeList.size()-1).next = root.left;
            }

            floorNodeList.add(root.left);
        }

        if (root.right != null){
            if (floorNodeList.size() > 0){
                floorNodeList.get(floorNodeList.size()-1).next = root.right;
            }
            floorNodeList.add(root.right);
        }
    }

    public static Node buildNode11(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node7;

        return node1;
    }
}
