package com.zdp.study.hot.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdp
 * @date 2024/9/4 02:05
 * @desc 155.最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class MinStack {

    private List<Integer> stack = new ArrayList<>();
    Integer minValue = null;

    public MinStack() {

    }

    public void push(int val) {
        stack.add(val);
        if (minValue == null || val < minValue){
            minValue = val;
        }
    }

    public void pop() {
        Integer value = stack.remove(stack.size()-1);
        if (value.equals(minValue)){
            minValue = null;
            for (Integer stackValue:stack){
                if (minValue == null || stackValue < minValue){
                    minValue = stackValue;
                }
            }
        }
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minValue;
    }
}
