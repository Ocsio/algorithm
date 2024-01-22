package cn.ocsio.leetcode.tree.c01;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/maximum-depth-of-binary-tree/
public class E0104_maxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        E0104_maxDepth e = new E0104_maxDepth();
        int ans = e.maxDepth(root);
        System.out.println(ans);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 外层的 while 循环就是树的层数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 内层的 for 循环就是树的宽度
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            ans++;
        }
        return ans;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
