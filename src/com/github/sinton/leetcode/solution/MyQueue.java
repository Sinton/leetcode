package com.github.sinton.leetcode.solution;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * 用栈实现队列
 */
public class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> tmpStack;

    public MyQueue() {
        stack = new Stack<>();
        tmpStack = new Stack<>();
    }

    public void push(int x) {
        while(!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }
        stack.push(x);
        while(!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
