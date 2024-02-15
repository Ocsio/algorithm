package cn.ocsio.leetcode.dp.c03;

import java.util.HashMap;

// https://leetcode.cn/problems/house-robber-iii/description/
public class E0337_rob {
    HashMap<TreeNode, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(3, null, new TreeNode(1))
        );
        E0337_rob e = new E0337_rob();
        int ans = e.rob(root);
        System.out.println(ans);
    }

    public int robCache(TreeNode root) {
        return helper(root);
    }

    public int rob(TreeNode root) {
        int[] ans = process(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] process(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] ans = new int[2];
        int[] left = process(root.left);
        int[] right = process(root.right);
        // root 偷窃，那么不能偷 left 节点和 right 节点
        ans[1] = root.val + left[0] + right[0];
        // root 不偷窃，可以偷 left 节点和 right 节点
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return ans;
    }

    /*
        暴力递归 + 记忆化搜索
        在 root 树上偷窃的最大金额
     */
    public int helper(TreeNode root) {
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        if (root == null) {
            return 0;
        }
        // root 节点不偷窃
        int left = helper(root.left);
        int right = helper(root.right);
        // root 节点偷窃
        int res = root.val;
        if (root.left != null) {
            res += helper(root.left.left) + helper(root.left.right);
        }
        if (root.right != null) {
            res += helper(root.right.left) + helper(root.right.right);
        }
        int ans = Math.max(left + right, res);
        cache.put(root, ans);
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
