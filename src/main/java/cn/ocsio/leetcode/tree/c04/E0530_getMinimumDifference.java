package cn.ocsio.leetcode.tree.c04;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
public class E0530_getMinimumDifference {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        E0530_getMinimumDifference e = new E0530_getMinimumDifference();
        int ans = e.getMinimumDifference(root);
        System.out.println(ans);
    }

    public int getMinimumDifference(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        // cur 节点的前一个节点
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                if (pre != null) {
                    ans = Math.min(Math.abs(pop.val - pre.val), ans);
                }
                pre = pop;
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
    }
}
