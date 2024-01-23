package cn.ocsio.leetcode.tree.c03;

// https://leetcode.cn/problems/path-sum/description/
public class E0112_hasPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        E0112_hasPathSum e = new E0112_hasPathSum();
        int targetSum = 5;
        boolean ans = e.hasPathSum(root, targetSum);
        System.out.println(ans);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode cur, int targetSum) {
        if (cur == null) {
            return false;
        }
        if (cur.left == null && cur.right == null) {
            return targetSum == cur.val;
        }
        return dfs(cur.left, targetSum - cur.val) || dfs(cur.right, targetSum - cur.val);
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
