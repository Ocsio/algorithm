package cn.ocsio.leetcode.tree.c01;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
public class E0117_connect {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2, new Node(4), new Node(5), null);
        root.right = new Node(3, null, new Node(7), null);
        E0117_connect e = new E0117_connect();
        Node ans = e.connect(root);
        System.out.println(ans);
    }

    /*
        和 E0116_connect 一致
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                prev = poll;
                if (size >= 2 && i < size - 1) {
                    prev.next = queue.peek();
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return root;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
