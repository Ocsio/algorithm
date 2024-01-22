package cn.ocsio.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/implement-queue-using-stacks/description/
public class E0232_MyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    /*
        inStack 和 outStack 来回倒腾
     */
    static class MyQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public MyQueue() {
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            in2out();
            return outStack.pop();
        }

        public int peek() {
            in2out();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        public void in2out() {
            if (!outStack.isEmpty()) {
                return;
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
