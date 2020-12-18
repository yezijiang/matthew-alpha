package com.matthew.google.challenge.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author : matthew
 * @description :
 * @date : 2020/12/16 11:11 上午
 **/
public class Solution225 {
    private Queue<Integer> input;
    private Queue<Integer> output;
    /** Initialize your data structure here. */
    public Solution225() {
        input = new LinkedList<>();
        output = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        input.offer(x);
        while (!output.isEmpty()){
            input.offer(output.poll());
        }
        Queue<Integer> temp = null;
        temp = input;
        input = output;
        output = temp;

    }
    /** Push element x onto stack.
     * 思路二 只需要一个queue，
     *
     * */
    public void push2(int x) {
        int length = output.size();
        output.offer(x);
        for (int i = 0; i < length; i++) {
            output.offer(output.poll());
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return output.poll();
    }

    /** Get the top element. */
    public int top() {
        return output.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return output.isEmpty();
    }
    public static void main(String[] args) {
        Solution225 obj = new Solution225();
        obj.push2(1);
        obj.push2(2);
        obj.push2(3);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        obj.push2(4);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
