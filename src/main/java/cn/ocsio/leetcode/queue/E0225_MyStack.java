package cn.ocsio.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.cn/problems/implement-stack-using-queues/
public class E0225_MyStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.offer(x);
            reOffer();
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

        public void reOffer() {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
        }
    }
}
