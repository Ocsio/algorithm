package cn.ocsio.leetcode.tree.c03;

// https://leetcode.cn/problems/balanced-binary-tree/description/
public class E0110_isBalanced {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        E0110_isBalanced e = new E0110_isBalanced();
        boolean ans = e.isBalanced(root);
        System.out.println(ans);
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        if (left == -1) {
            return -1;
        }
        int right = height(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
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
