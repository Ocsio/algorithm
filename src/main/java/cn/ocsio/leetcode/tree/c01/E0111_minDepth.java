package cn.ocsio.leetcode.tree.c01;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/minimum-depth-of-binary-tree/
public class E0111_minDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        E0111_minDepth e = new E0111_minDepth();
        int ans = e.minDepth(root);
        System.out.println(ans);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // 某一层的某个节点无左右子树则返回 ans
                if (poll.left == null && poll.right == null) {
                    return ans + 1;
                }
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
