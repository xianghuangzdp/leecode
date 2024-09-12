package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.ListNode;
import com.zdp.study.hot.util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zdp
 * @date 2024/9/11 01:52
 * @desc 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class BuildTree {

    public static void main(String[] args) {
//        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
        System.out.println(case5()?"case5 success":"case5 fail");
    }

    public static boolean case1(){
        int [] preOrder = new int[]{3,9,20,15,7};
        int [] inOrder = new int[]{9,3,15,20,7};

        TreeNode result = buildTree(preOrder,inOrder);

        return true;
    }

    public static boolean case2(){
        int [] preOrder = new int[]{-1};
        int [] inOrder = new int[]{-1};

        TreeNode result = buildTree(preOrder,inOrder);

        return true;
    }

    public static boolean case3(){
        int [] preOrder = new int[]{1,2,3};
        int [] inOrder = new int[]{1,2,3};

        TreeNode result = buildTree(preOrder,inOrder);

        return true;
    }

    public static boolean case4(){
        int [] preOrder = new int[]{1,2,4,3};
        int [] inOrder = new int[]{1,2,3,4};

        TreeNode result = buildTree(preOrder,inOrder);

        return true;
    }

    public static boolean case5(){
        int [] preOrder = new int[]{1,3,2,4,6,5};
        int [] inOrder = new int[]{1,2,3,4,5,6};

        TreeNode result = buildTree(preOrder,inOrder);

        return true;
    }

    private static boolean checkResult(ListNode node,int[] target){
        for (int i = 0; i < target.length;i++){
            if (node == null || !Objects.equals(target[i],node.val)){
                return false;
            }

            node = node.next;
        }

        return node == null;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inOrderMap = new HashMap<>();

        for (int  i = 0; i < inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }

        TreeNode result = buildTree(preorder,inOrderMap,0,inorder.length-1,0);
        return result;
    }

    public static TreeNode buildTree(int[] preorder,
                                  Map<Integer,Integer> inOrderMap,int preOrderStart,int preOrderEnd
            ,int inOrderStart){

        if (preOrderStart > preOrderEnd){
            return null;
        }

        int root = preorder[preOrderStart];
        int rootIndexInOrder = inOrderMap.get(root);
        int leftTreeSize = rootIndexInOrder - inOrderStart;

        TreeNode result = new TreeNode(root);
        result.left = buildTree(preorder,inOrderMap
                ,preOrderStart+1,preOrderStart + leftTreeSize,inOrderStart);

        result.right = buildTree(preorder,inOrderMap
                ,preOrderStart + leftTreeSize+1,preOrderEnd,rootIndexInOrder+1);

        return result;
    }

}
