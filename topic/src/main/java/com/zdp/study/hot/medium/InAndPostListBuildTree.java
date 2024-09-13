package com.zdp.study.hot.medium;

import com.zdp.study.hot.util.ListNode;
import com.zdp.study.hot.util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zdp
 * @date 2024/9/13 23:54
 * @desc 106.从中序遍历和后续遍历序列中构造二叉树
 */
public class InAndPostListBuildTree {

    public static void main(String[] args) {
        System.out.println(case1()?"case1 success":"case1 fail");
//        System.out.println(case2()?"case2 success":"case2 fail");
//        System.out.println(case3()?"case3 success":"case3 fail");
//        System.out.println(case4()?"case4 success":"case4 fail");
//        System.out.println(case5()?"case5 success":"case5 fail");
    }

    public static boolean case1(){
        int [] postOrder = new int[]{9,15,7,20,3};
        int [] inOrder = new int[]{9,3,15,20,7};

        TreeNode result = buildTree(inOrder,postOrder);

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

    private static boolean checkResult(ListNode node, int[] target){
        for (int i = 0; i < target.length;i++){
            if (node == null || !Objects.equals(target[i],node.val)){
                return false;
            }

            node = node.next;
        }

        return node == null;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inOrderMap = new HashMap<>();

        for (int  i = 0; i < inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }

        TreeNode result = buildTree(postorder,inOrderMap,0,postorder.length-1,postorder.length-1);
        return result;
    }

    public static TreeNode buildTree(int[] postOrder,
                                     Map<Integer,Integer> inOrderMap,int inOrderStart,int inOrderEnd
            ,int postOrderEnd){

        if (inOrderStart > inOrderEnd){
            return null;
        }

        int root = postOrder[postOrderEnd];
        int rootIndexInOrder = inOrderMap.get(root);
        int rightTreeSize = inOrderEnd - rootIndexInOrder;

        TreeNode result = new TreeNode(root);
        result.right = buildTree(postOrder,inOrderMap
                ,rootIndexInOrder+1,inOrderEnd,postOrderEnd-1);

        result.left = buildTree(postOrder,inOrderMap
                ,inOrderStart,rootIndexInOrder-1,postOrderEnd-rightTreeSize-1);

        return result;
    }
}
