package cn.ocsio.leetcode.tree.c03;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/sum-of-left-leaves/
public class E0404_sumOfLeftLeaves {
    int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        E0404_sumOfLeftLeaves e = new E0404_sumOfLeftLeaves();
        int ans = e.sumOfLeftLeaves(root);
        System.out.println(ans);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }
        dfs(root.left);
        dfs(root.right);
        return ans;
    }

    public int sumOfLeftLeavesTemp(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                // 是自右而来的叶子节点
                if (pop.left == null && pop.right == null && !stack.isEmpty() && stack.peek().left == pop) {
                    ans += pop.val;
                }
                cur = pop.right;
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

        @Override
        public String toString() {
            return "" + val;
        }
    }
}
