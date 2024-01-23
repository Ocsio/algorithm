package cn.ocsio.leetcode.tree.c03;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/find-bottom-left-tree-value/
public class E0513_findBottomLeftValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        E0513_findBottomLeftValue e = new E0513_findBottomLeftValue();
        int ans = e.findBottomLeftValue(root);
        System.out.println(ans);
    }

    /*
        层序遍历最简单
     */
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    ans = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
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
