package cn.ocsio.leetcode.tree.c01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
public class E0429_levelOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> children = new ArrayList<>();
        Node node3 = new Node(3);
        children.add(node3);
        children.add(new Node(2));
        children.add(new Node(1));
        root.children = children;
        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5));
        children2.add(new Node(6));
        node3.children = children2;

        E0429_levelOrder e = new E0429_levelOrder();
        List<List<Integer>> ans = e.levelOrder(root);
        System.out.println(ans);
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                li.add(poll.val);
                if (poll.children != null) {
                    for (Node child : poll.children) {
                        queue.offer(child);
                    }
                }
            }
            ans.add(li);
        }
        return ans;
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
